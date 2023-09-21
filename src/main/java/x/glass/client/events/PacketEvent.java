package x.glass.client.events;

import com.darkmagician6.eventapi.events.callables.EventCancellable;
import net.minecraft.network.IPacket;

public class PacketEvent extends EventCancellable {

    IPacket<?> packet;

    public static class Incoming extends PacketEvent{
        public Incoming(IPacket<?> packet) {
            this.packet = packet;
        }
    }
    public static class Outgoing extends PacketEvent{
        public Outgoing(IPacket<?> packet) {
            this.packet = packet;
        }
    }

}
