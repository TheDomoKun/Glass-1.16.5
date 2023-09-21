package the.domokun.glass.events;

import com.darkmagician6.eventapi.events.Event;
import com.mojang.blaze3d.matrix.MatrixStack;

public class RenderOverlayEvent implements Event {

    MatrixStack matrixStack;
    float partialTicks;

    public MatrixStack getMatrixStack() {
        return matrixStack;
    }

    public float getPartialTicks() {
        return partialTicks;
    }

    public RenderOverlayEvent(MatrixStack matrixStack, float partialTicks) {
        this.matrixStack = matrixStack;
        this.partialTicks = partialTicks;
    }
}
