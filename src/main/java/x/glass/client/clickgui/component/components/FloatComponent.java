package x.glass.client.clickgui.component.components;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.sxmurxy.fonts.styled.StyledFontRenderer;
import x.glass.client.Glass;
import x.glass.client.clickgui.Button;
import x.glass.client.clickgui.component.Component;
import x.glass.client.clickgui.setting.Setting;
import x.glass.client.clickgui.setting.settings.FloatSetting;
import x.glass.client.utils.AnimationUtil;
import x.glass.client.utils.HoverUtil;
import x.glass.client.utils.RenderUtil;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatComponent extends Component {
    public int x, y, width, height;
    Setting setting;
    boolean sliding;
    AnimationUtil animationUtil = new AnimationUtil(), animationUtil2 = new AnimationUtil();

    public FloatComponent(Button button, int x, int y, int width, int height, Setting setting) {
        super(button);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setting = setting;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        animationUtil.to = HoverUtil.isHovered(mouseX, mouseY, x, y, width, height) ? 2 : 0;
        animationUtil2.to = (width - 10) * (((FloatSetting) setting).value - ((FloatSetting) setting).minimum) / (((FloatSetting) setting).maximum - ((FloatSetting) setting).minimum);
        RenderUtil.drawRound(x + 5, y + height / 2 + height / 6, animationUtil2.getAnimation(), 2, 1, Color.WHITE);
        StyledFontRenderer.drawShadowedCenteredXYString(matrixStack, Glass.font, setting.name + ": " + ((FloatSetting) setting).value, x + width / 2 + animationUtil.getAnimation(), y + height / 2 - height / 6 + animationUtil.getAnimation(), Color.WHITE);
        if (sliding) {
            ((FloatSetting) setting).value = (float) round((double) (mouseX - (x + 5)) * (((FloatSetting) setting).maximum - ((FloatSetting) setting).minimum) / (width - 10) + ((FloatSetting) setting).minimum, 1);
            if (((FloatSetting) setting).value > ((FloatSetting) setting).maximum) {
                ((FloatSetting) setting).value = ((FloatSetting) setting).maximum;
            } else if (((FloatSetting) setting).value < ((FloatSetting) setting).minimum) {
                ((FloatSetting) setting).value = ((FloatSetting) setting).minimum;
            }
        }
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }


    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (HoverUtil.isHovered(mouseX, mouseY, x, y, width, height) && button == 0) {
            sliding = true;
        }
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        sliding = false;
        super.mouseReleased(mouseX, mouseY, button);
    }

    public double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
