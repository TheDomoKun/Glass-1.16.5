package x.glass.client.clickgui.component;

import com.mojang.blaze3d.matrix.MatrixStack;
import x.glass.client.clickgui.Button;

public class Component {
    Button button;

    public Component(Button button) {
        this.button = button;
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
    }
}
