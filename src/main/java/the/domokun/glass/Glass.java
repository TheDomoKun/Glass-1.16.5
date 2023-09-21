package the.domokun.glass;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.Event;
import the.domokun.glass.events.*;

public class Glass {

    public static final String CLIENTNAME = "Glass";
    public static final String CLIENTVERSION = "0.1a";

    public void startup()
    {
        System.out.println("Starting "+CLIENTNAME+" "+CLIENTVERSION);
        EventManager.register(this);
    }

    public void shutdown()
    {
        System.out.println("Stopping "+CLIENTNAME+" "+CLIENTVERSION);
        EventManager.unregister(this);
    }



}
