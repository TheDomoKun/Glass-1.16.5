package x.glass.client.events;

import com.darkmagician6.eventapi.events.callables.EventCancellable;

public class KeyboardEvent extends EventCancellable {
    int key, action;

    public KeyboardEvent(int key, int action) {
        this.key = key;
        this.action = action;
    }

    public int getKey() {
        return key;
    }

    public int getAction() {
        return action;
    }
}