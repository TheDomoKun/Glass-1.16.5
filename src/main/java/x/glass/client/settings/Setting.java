package x.glass.client.settings;

public class Setting {

    String name;

    String currentMode;
    String[] modes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    public String[] getModes() {
        return modes;
    }

    public void setModes(String[] modes) {
        this.modes = modes;
    }

    public String getDefaultMode() {
        return defaultMode;
    }

    public void setDefaultMode(String defaultMode) {
        this.defaultMode = defaultMode;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public float getInc() {
        return inc;
    }

    public void setInc(float inc) {
        this.inc = inc;
    }

    public float getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(float defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    String defaultMode;

    float min,max,current,inc,defaultVal;

    boolean toggled;

    public Setting(String name, String currentMode, String defaultMode,String ...modes) {
        this.name = name;
        this.currentMode = currentMode;
        this.modes = modes;
        this.defaultMode = defaultMode;
    }

    public Setting(String name, float min, float max, float current, float inc) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.current = current;
        this.inc = inc;
    }

    public Setting(String name, float defaultVal) {
        this.name = name;
        this.defaultVal = defaultVal;
    }
}
