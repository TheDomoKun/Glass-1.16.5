package x.glass.client.utils;

public class AnimationUtil {
    public float animation, to, speed = 0.1f;
    long mc = System.currentTimeMillis();

    public AnimationUtil() {
    }

    public AnimationUtil(float speed) {
        this.speed = speed;
    }

    public float getAnimation() {
        int count = (int) ((System.currentTimeMillis() - mc) / 5);
        if (count > 0) {
            mc = System.currentTimeMillis();
        }
        for (int i = 0; i < count; i++) {
            animation = lerp(animation, to, speed);
        }
        return animation;
    }

    public float lerp(float a, float b, float f) {
        return a + f * (b - a);
    }
}
