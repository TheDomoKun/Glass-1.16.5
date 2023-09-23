package x.glass.client.clickgui.setting.settings;

import x.glass.client.clickgui.setting.Setting;

public class BooleanSetting extends Setting {
    public boolean value;

    public BooleanSetting(String name, boolean value) {
        super(name);
        this.value = value;
    }
}
