package x.glass.client.module.modules.movement;

import com.darkmagician6.eventapi.Event;
import x.glass.client.events.MotionUpdateEvent;
import x.glass.client.events.PlayerTickEvent;
import x.glass.client.events.PushOutOfBlocksEvent;
import x.glass.client.module.Category;
import x.glass.client.module.Module;
import x.glass.client.utils.MoveUtil;

public class NoClip extends Module {
    public NoClip() {
        super("NoClip",Category.Move);
    }
    @Event
    public void event(PlayerTickEvent playerTickEvent)
    {
        MoveUtil.strafe(1.0f);
    }

    @Event
    public void push(PushOutOfBlocksEvent event)
    {
        event.cancel();
    }

    @Event
    public void motion(MotionUpdateEvent.Pre event)
    {
        mc.player.noClip = true;
    }
}
