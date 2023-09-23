package x.glass.client.clickgui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import x.glass.client.module.Category;

import java.util.ArrayList;

public class ClickGUIScreen extends Screen {
    ArrayList<Panel> panels = new ArrayList<>();

    public ClickGUIScreen() {
        super(ITextComponent.getTextComponentOrEmpty(""));
        int x = 10;
        for (Category category : Category.values()) {
            panels.add(new Panel(x, 10, 120, 18, category));
            x += 10 + 120;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        panels.forEach(panel -> panel.render(matrixStack, mouseX, mouseY, partialTicks));
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        panels.forEach(panel -> panel.mouseClicked(mouseX, mouseY, button));
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        panels.forEach(panel -> panel.mouseReleased(mouseX, mouseY, button));
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        panels.forEach(panel -> panel.keyPressed(keyCode, scanCode, modifiers));
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
