package x.glass.client.module;

import com.darkmagician6.eventapi.EventManager;
import net.minecraft.client.Minecraft;
import x.glass.client.clickgui.setting.Setting;

import java.util.ArrayList;
import java.util.Arrays;

public class Module {
    public static Minecraft mc = Minecraft.getInstance();
    public String name;
    public Category category;
    public int key;
    public boolean included;
    public ArrayList<Setting> settings = new ArrayList<>();

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Module(String name, Category category, int key) {
        this.name = name;
        this.category = category;
        this.key = key;
    }

    public void onEnable() {
        included = true;
        EventManager.register(this);
    }

    public void onDisable() {
        included = false;
        EventManager.unregister(this);
    }

    public void toggle() {
        if (included) {
            onDisable();
        } else {
            onEnable();
        }
    }

    public void addSettings(Setting... settings) {
        this.settings.addAll(Arrays.asList(settings));
    }
}
