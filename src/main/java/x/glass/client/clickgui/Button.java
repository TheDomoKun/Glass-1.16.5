package x.glass.client.clickgui;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.sxmurxy.fonts.simplified.SimplifiedFontRenderer;
import dev.sxmurxy.fonts.styled.StyledFontRenderer;
import x.glass.client.Glass;
import x.glass.client.module.Module;
import x.glass.client.utils.HoverUtil;

import java.awt.*;

public class Button {
    int x, y, width, height;
    Module module;

    public Button(int x, int y, int width, int height, Module module) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.module = module;
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
         StyledFontRenderer.drawShadowedCenteredXYString(matrixStack, Glass.font, module.name, x + width / 2, y + height / 2, module.included ? Color.RED : Color.WHITE);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (HoverUtil.isHovered(mouseX, mouseY, x, y, width, height) && button == 0) {
            module.toggle();
        }
    }
}
