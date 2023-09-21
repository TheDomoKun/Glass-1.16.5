package x.glass.client.events;

import com.darkmagician6.eventapi.events.callables.EventCancellable;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.util.text.ITextComponent;

public class RenderNametagEvent extends EventCancellable {
    AbstractClientPlayerEntity entityIn;
    ITextComponent displayNameIn;
    MatrixStack matrixStackIn;
    IRenderTypeBuffer bufferIn;
    int packedLightIn;

    public AbstractClientPlayerEntity getEntityIn() {
        return entityIn;
    }

    public ITextComponent getDisplayNameIn() {
        return displayNameIn;
    }

    public MatrixStack getMatrixStackIn() {
        return matrixStackIn;
    }

    public IRenderTypeBuffer getBufferIn() {
        return bufferIn;
    }

    public int getPackedLightIn() {
        return packedLightIn;
    }

    public RenderNametagEvent(AbstractClientPlayerEntity entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        this.entityIn = entityIn;
        this.displayNameIn = displayNameIn;
        this.matrixStackIn = matrixStackIn;
        this.bufferIn = bufferIn;
        this.packedLightIn = packedLightIn;
    }
}
