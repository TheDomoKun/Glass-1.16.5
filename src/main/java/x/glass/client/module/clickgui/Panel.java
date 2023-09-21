package x.glass.client.module.clickgui;

import com.mojang.blaze3d.matrix.MatrixStack;
import x.glass.client.module.Module;
import x.glass.client.module.ModuleCategory;
import x.glass.client.module.ModuleManager;
import x.glass.client.module.utils.RenderUtil;

import java.awt.*;
import java.util.ArrayList;

import static x.glass.client.Glass.mc;

public class Panel {
    int x, y, width, height;
    ModuleCategory category;
    ArrayList<Button> buttons = new ArrayList<>();

    public Panel(int x, int y, int width, int height, ModuleCategory category) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.category = category;
        for (Module module : ModuleManager.modules) {
            if (module.category == category) {
                buttons.add(new Button(x, y + 18, width, height, module));
                y += 18;
            }
        }
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderUtil.drawRound(x, y, width, height + buttons.size() * 18, 5, Color.BLACK);
        //  SimplifiedFontRenderer.drawShadowedCenteredXYString(matrixStack, Glass.font, category.name(), x + width / 2, y + height / 2, Color.WHITE);
        for (Button button : buttons) {
            button.render(matrixStack, mouseX, mouseY, partialTicks);
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        for (Button buttonn : buttons) {
            buttonn.mouseClicked(mouseX, mouseY, button);
        }
    }
}
