package the.domokun.glass;

import com.darkmagician6.eventapi.EventManager;
import net.minecraft.client.Minecraft;

public class Glass {
    public static Minecraft mc = Minecraft.getInstance();

    public void startup() {
        EventManager.register(this);
    }

    public void shutdown() {
        EventManager.unregister(this);
    }
}
