package x.glass.client.clickgui;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.sxmurxy.fonts.styled.StyledFontRenderer;
import x.glass.client.Glass;
import x.glass.client.managers.ModuleManager;
import x.glass.client.module.Category;
import x.glass.client.module.Module;
import x.glass.client.utils.RenderUtil;

import java.awt.*;
import java.util.ArrayList;

public class Panel {
    int x, y, width, height;
    Category category;
    ArrayList<Button> buttons = new ArrayList<>();

    public Panel(int x, int y, int width, int height, Category category) {
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
        int buttonComponentsHeight = 0;
        for (Button button : buttons) {
            buttonComponentsHeight += button.animationUtil.getAnimation();
        }
        RenderUtil.drawRound(x - 2, y - 2, width + 4, height + buttons.size() * 18 + buttonComponentsHeight + 4, 5, new Color(0, 0, 0, 100));
        RenderUtil.drawRound(x, y, width, height + buttons.size() * 18 + buttonComponentsHeight, 5, Color.BLACK);
        StyledFontRenderer.drawShadowedCenteredXYString(matrixStack, Glass.font, category.name(), x + width / 2, y + height / 2, Color.WHITE);
        int buttonY = y + height;
        for (Button button : buttons) {
            button.y = buttonY;
            buttonY += height + button.animationUtil.getAnimation();
            button.render(matrixStack, mouseX, mouseY, partialTicks);
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        for (Button buttonn : buttons) {
            buttonn.mouseClicked(mouseX, mouseY, button);
        }
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (Button buttonn : buttons) {
            buttonn.mouseReleased(mouseX, mouseY, button);
        }
    }

    public void keyPressed(int keyCode, int scanCode, int modifiers) {
        for (Button buttonn : buttons) {
            buttonn.keyPressed(keyCode, scanCode, modifiers);
        }
    }
}
