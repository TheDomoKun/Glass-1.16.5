package x.glass.client;

import com.darkmagician6.eventapi.Event;
import com.darkmagician6.eventapi.EventManager;
import dev.sxmurxy.fonts.common.Lang;
import dev.sxmurxy.fonts.styled.StyledFont;
import net.minecraft.client.Minecraft;
import x.glass.client.events.KeyboardEvent;
import x.glass.client.module.Module;
import x.glass.client.managers.ModuleManager;
import x.glass.client.clickgui.ClickGUIScreen;

/*
*
* ⠀⠀⠀⣴⣾🌵🌵⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⢸🌵🌵🌵🌵🌵🌵⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠈⢿🌵🌵🌵🌵⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠈⣉⣩⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣼🌵🌵🌵⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⢀⣼🌵🌵🌵🌵🌵⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⢀⣾🌵🌵🌵🌵🌵🌵⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢠⣾🌵🌵⠉🌵🌵🌵🌵🌵⡄⠀⢀⣠⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠙🌵🌵⣧🌵🌵🌵🌵🌵⡇⢠🌵🌵🌵🌵🌵⣧⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠈⠻🌵🌵🌵🌵🌵🌵⣷⠸🌵🌵🌵🌵🌵⡿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠘⠿⢿🌵🌵🌵🌵⡄⠙⠻⠿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡟⣩⣝⢿⠀⠀⣠⣶⣶⣦⡀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣷⡝🌵⣦⣠⣾🌵🌵🌵🌵⣷⡀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀🌵🌵⣮⢻🌵⠟🌵🌵🌵🌵🌵⣷⡀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀🌵🌵🌵⡇⠀⠀⠻⠿⠻🌵🌵🌵🌵⣦⡀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢰🌵🌵🌵⠇⠀⠀⠀⠀⠀⠘🌵🌵🌵🌵🌵⡆⠀⠀
⠀⠀⠀⠀⠀⠀⢸🌵🌵🌵⠀⠀⠀⠀⠀⠀⣠⣾🌵🌵🌵🌵⠇⠀⠀
⠀⠀⠀⠀⠀⠀⢸🌵🌵⡿⠀⠀⠀⢀⣴🌵🌵🌵🌵⣟⣋⣁⣀⣀⠀
⠀⠀⠀⠀⠀⠀⠹🌵🌵⠇⠀⠀⠀⠸🌵🌵🌵🌵🌵🌵🌵🌵🌵🌵⠇
* */

public class Glass {
    public static Minecraft mc = Minecraft.getInstance();
    public static ClickGUIScreen clickGUIScreen;
    public static ModuleManager moduleManager;

    public static final String FONT_DIR = "/assets/" + "glass" + "/font/";


    public static StyledFont font = new StyledFont("font.ttf", 17, 0.0f, 0f, 0.5f, Lang.ENG_RU);

    public Glass() {
        moduleManager = new ModuleManager();

        EventManager.register(this);
    }

    public void startup() {

        moduleManager.addFeatures();

        clickGUIScreen = new ClickGUIScreen();
    }

    public void shutdown() {
        EventManager.unregister(this);
    }

    @Event
    public void onKey(KeyboardEvent keyboardEvent) {
        for (Module module : ModuleManager.modules) {
            if (module.key == keyboardEvent.getKey() && keyboardEvent.getAction() == 1) {
                module.toggle();
            }
        }
    }
}
