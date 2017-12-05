package memelord.com.bro_finder;

import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Christoffer on 05-12-2017.
 */

public class EventUpdater {
    private Activity activity;
    private ListView eventListView;
    private ArrayList<Event> eventArray;

    public EventUpdater(Activity activity, ListView eventListView) {
        this.activity = activity;
        this.eventListView = eventListView;
        eventArray = new ArrayList<>();
    }

    public void addEvent(Event event) {
        if(event != null) {
            eventArray.add(event);
            //need a custom list adapter
        }
    }
}
