package x.glass.client;

import com.darkmagician6.eventapi.Event;
import com.darkmagician6.eventapi.EventManager;
import net.minecraft.client.Minecraft;
import x.glass.client.events.KeyEvent;
import x.glass.client.module.Module;
import x.glass.client.module.ModuleManager;
import x.glass.client.module.clickgui.ClickGUIScreen;

public class Glass {
    public static Minecraft mc = Minecraft.getInstance();
    public static ClickGUIScreen clickGUIScreen;

    public void startup() {
        EventManager.register(this);
        ModuleManager.addFeatures();
        clickGUIScreen = new ClickGUIScreen();
    }

    public void shutdown() {
        EventManager.unregister(this);
    }

    @Event
    public void onKey(KeyEvent keyEvent) {
        for (Module module : ModuleManager.modules) {
            if (module.key == keyEvent.key && keyEvent.action == 1) {
                module.toggle();
            }
        }
    }
}
