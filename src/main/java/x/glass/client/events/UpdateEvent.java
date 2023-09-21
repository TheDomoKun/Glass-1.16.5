package x.glass.client.events;

import com.darkmagician6.eventapi.events.Event;

public class UpdateEvent implements Event {
    public static class Pre extends UpdateEvent{}
    public static class Post extends UpdateEvent{}
}
