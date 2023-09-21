package x.glass.client.module.modules.client;

import org.lwjgl.glfw.GLFW;
import x.glass.client.Glass;
import x.glass.client.module.Module;
import x.glass.client.module.ModuleCategory;

import static x.glass.client.Glass.mc;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", ModuleCategory.Client, GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Glass.clickGUIScreen);
    }
}
