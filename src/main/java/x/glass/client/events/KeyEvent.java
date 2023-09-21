package x.glass.client.events;

import com.darkmagician6.eventapi.events.callables.EventCancellable;

public class KeyEvent extends EventCancellable {
    public int key, action;

    public KeyEvent(int key, int action) {
        this.key = key;
        this.action = action;
    }
}