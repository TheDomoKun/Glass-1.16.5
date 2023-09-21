package x.glass.client.utils;

public class AnimationUtil {
    public static float animate(float current, float end, float minSpeed) {
        float movement = (end - current) * 0.065f * 240 / 60;
        if (movement > 0) {
            movement = Math.max(minSpeed, movement);
            movement = Math.min(end - current, movement);
        } else if (movement < 0) {
            movement = Math.min(-minSpeed, movement);
            movement = Math.max(end - current, movement);
        }
        return current + movement;
    }//ne testil //drugoy budet
}
