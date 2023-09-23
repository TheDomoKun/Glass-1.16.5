package x.glass.client.clickgui;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.sxmurxy.fonts.styled.StyledFontRenderer;
import org.lwjgl.glfw.GLFW;
import x.glass.client.Glass;
import x.glass.client.clickgui.component.Component;
import x.glass.client.clickgui.component.components.BooleanComponent;
import x.glass.client.clickgui.component.components.FloatComponent;
import x.glass.client.clickgui.setting.Setting;
import x.glass.client.clickgui.setting.settings.BooleanSetting;
import x.glass.client.module.Module;
import x.glass.client.utils.AnimationUtil;
import x.glass.client.utils.HoverUtil;
import x.glass.client.utils.RenderUtil;
import x.glass.client.utils.StencilUtil;

import java.awt.*;
import java.util.ArrayList;

public class Button {
    int x, y, width, height;
    Module module;
    boolean binding, open;
    ArrayList<Component> components = new ArrayList<>();
    AnimationUtil animationUtil = new AnimationUtil(), animationUtil2 = new AnimationUtil();

    public Button(int x, int y, int width, int height, Module module) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.module = module;
        for (Setting setting : module.settings) {
            if (setting instanceof BooleanSetting) {
                components.add(new BooleanComponent(this, 0, 0, width, height, setting));
            } else {
                components.add(new FloatComponent(this, 0, 0, width, height, setting));
            }
        }
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        animationUtil.to = open ? components.size() * height : 0;
        animationUtil2.to = HoverUtil.isHovered(mouseX, mouseY, x, y, width, height) ? 2 : 0;
        StyledFontRenderer.drawShadowedCenteredXYString(matrixStack, Glass.font, binding ? "press a key..." : module.name + (!module.settings.isEmpty() ? (open ? " <" : " >") : ""), x + width / 2 + animationUtil2.getAnimation(), y + height / 2 + animationUtil2.getAnimation(), module.included ? Color.MAGENTA : Color.WHITE);
        int componentY = y + height;
        for (Component component : components) {
            if (open) {
                if (component instanceof BooleanComponent) {
                    ((BooleanComponent) component).x = x;
                    ((BooleanComponent) component).y = componentY;
                } else {
                    ((FloatComponent) component).x = x;
                    ((FloatComponent) component).y = componentY;
                }
                componentY += height;
                StencilUtil.initStencilToWrite();
                RenderUtil.drawRound(x, y, width, height + animationUtil.getAnimation(), 0, Color.WHITE);
                StencilUtil.readStencilBuffer(1);
                component.render(matrixStack, mouseX, mouseY, partialTicks);
                StencilUtil.uninitStencilBuffer();
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (HoverUtil.isHovered(mouseX, mouseY, x, y, width, height)) {
            if (button == 0) {
                module.toggle();
            } else if (button == 1) {
                open = !open;
            } else if (button == 2) {
                binding = !binding;
            }
        }
        for (Component component : components) {
            if (open) {
                component.mouseClicked(mouseX, mouseY, button);
            }
        }
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (Component component : components) {
            if (open) {
                component.mouseReleased(mouseX, mouseY, button);
            }
        }
    }

    public void keyPressed(int keyCode, int scanCode, int modifiers) {
        if (binding) {
            if (keyCode != GLFW.GLFW_KEY_ESCAPE) {
                if (keyCode != GLFW.GLFW_KEY_DELETE) {
                    module.key = keyCode;
                } else {
                    module.key = 0;
                }
            }
            binding = false;
        }
    }
}
