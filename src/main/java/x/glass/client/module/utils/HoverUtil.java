package x.glass.client.module.utils;

public class HoverUtil {
    public static boolean isHovered(double mouseX, double mouseY, int x, int y, int width, int height) {
        return mouseX > x && mouseY > y && mouseX < x + width && mouseY < y + height;
    }
}
