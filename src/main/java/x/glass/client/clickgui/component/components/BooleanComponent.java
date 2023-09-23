package x.glass.client.clickgui.component.components;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.sxmurxy.fonts.styled.StyledFontRenderer;
import x.glass.client.Glass;
import x.glass.client.clickgui.Button;
import x.glass.client.clickgui.component.Component;
import x.glass.client.clickgui.setting.Setting;
import x.glass.client.clickgui.setting.settings.BooleanSetting;
import x.glass.client.utils.AnimationUtil;
import x.glass.client.utils.HoverUtil;

import java.awt.*;

public class BooleanComponent extends Component {
    public int x, y, width, height;
    Setting setting;
    AnimationUtil animationUtil = new AnimationUtil();

    public BooleanComponent(Button button, int x, int y, int width, int height, Setting setting) {
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
        StyledFontRenderer.drawShadowedCenteredXYString(matrixStack, Glass.font, setting.name + ": " + ((BooleanSetting) setting).value, x + width / 2 + animationUtil.getAnimation(), y + height / 2 + animationUtil.getAnimation(), Color.WHITE);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (HoverUtil.isHovered(mouseX, mouseY, x, y, width, height) && button == 0) {
            ((BooleanSetting) setting).value = !((BooleanSetting) setting).value;
        }
        super.mouseClicked(mouseX, mouseY, button);
    }
}
