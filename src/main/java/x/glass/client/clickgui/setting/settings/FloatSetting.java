package x.glass.client.clickgui.setting.settings;

import ua.leansani.phasma.clickgui.setting.Setting;

public class FloatSetting extends Setting {
    public float minimum, maximum, value;

    public FloatSetting(String name, float minimum, float maximum, float value) {
        super(name);
        this.minimum = minimum;
        this.maximum = maximum;
        this.value = value;
    }
}
