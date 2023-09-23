package x.glass.client.utils;

import net.minecraft.client.Minecraft;

public class MoveUtil {
    static Minecraft mc = Minecraft.getInstance();
    public static void strafe(float speed)
    {

        double sin = Math.sin(-Math.toRadians(mc.player.rotationYaw));
        double cos = Math.cos(Math.toRadians(mc.player.rotationPitch));

        mc.player.setMotion(sin,mc.player.getMotion().y,cos);

    }

}
