package x.glass.client.module;

import x.glass.client.module.modules.client.ClickGUI;
import x.glass.client.module.modules.misc.ElytraSwap;

import java.util.ArrayList;

public class ModuleManager {
    public static ArrayList<Module> modules = new ArrayList<>();

    public static void addFeatures() {
        addModule(ClickGUI.class);
        addModule(ElytraSwap.class);
    }

    public static void addModule(Class<?> clazz) {
        try {
            modules.add((Module) clazz.newInstance());
        } catch (Exception ignored) {
        }
    }

    public static boolean moduleIncluded(Class<?> clazz) {
        for (Module module : modules) {
            if (module.included && module.getClass() == clazz) {
                return true;
            }
        }
        return false;
    }
}