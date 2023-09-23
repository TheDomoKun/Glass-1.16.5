package x.glass.client.module.modules.client;

import org.lwjgl.glfw.GLFW;
import x.glass.client.Glass;
import x.glass.client.clickgui.setting.settings.BooleanSetting;
import x.glass.client.clickgui.setting.settings.FloatSetting;
import x.glass.client.module.Category;
import x.glass.client.module.Module;

public class ClickGUI extends Module {
    BooleanSetting booleanSetting = new BooleanSetting("sss", true);
    FloatSetting floatSetting = new FloatSetting("sswew", 0, 1, 0);

    public ClickGUI() {
        super("ClickGUI", Category.Client, GLFW.GLFW_KEY_RIGHT_SHIFT);
        addSettings(booleanSetting, floatSetting);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Glass.clickGUIScreen);
    }
}
