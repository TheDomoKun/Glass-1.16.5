package x.glass.client.events;

import com.darkmagician6.eventapi.events.Event;

public class PlayerTickEvent implements Event {
    public static class Pre extends PlayerTickEvent{}
    public static class Post extends PlayerTickEvent{}
}
