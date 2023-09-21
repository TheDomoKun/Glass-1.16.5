package x.glass.client.clickgui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import x.glass.client.module.ModuleCategory;

import java.util.ArrayList;

public class ClickGUIScreen extends Screen {
    ArrayList<Panel> panels = new ArrayList<>();

    public ClickGUIScreen() {
        super(ITextComponent.getTextComponentOrEmpty(""));
        int x = 10;
        for (ModuleCategory category : ModuleCategory.values()) {
            panels.add(new Panel(x, 10, 120, 18, category));
            x += 10 + 120;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        for (Panel panel : panels) {
            panel.render(matrixStack, mouseX, mouseY, partialTicks);
        }
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (Panel panel : panels) {
            panel.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
