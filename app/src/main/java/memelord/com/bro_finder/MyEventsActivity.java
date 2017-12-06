package memelord.com.bro_finder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyEventsActivity extends AppCompatActivity {
    /*
        final ArrayList<String> myEventList = new ArrayList<String>();
        final ArrayAdapter myEventAdapter = new ArrayAdapter(this,R.layout.myeventlist , myEventList);
        ListView listView = (ListView)findViewById(R.id.list);
        //listView.setAdapter(myEventAdapter);

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        final ArrayList<Event> myEventList = new ArrayList<>();
        final MyEventsAdapter myAdapter = new MyEventsAdapter(this,myEventList);
        ListView listView = (ListView)findViewById(R.id.MyEventList);
        listView.setAdapter(myAdapter);

        ArrayList<Event> arrayhere = new ArrayList<>();

        Event a = new Event("123", "Kicking a ball", "Football", "abc", "John", 5, 2,  2017, 06022017, 333, 444);
        Event b = new Event("1234", "Kicking a bottle", "Beer", "ab", "Jo", 6, 2,  2017, 06022017, 333, 444);
        Event c = new Event("1235", "Kicking ", "Walk", "abcd", "Johnathan", 5, 3,  2017, 06022017, 333, 444);
        arrayhere.add(a);
        arrayhere.add(b);
        arrayhere.add(c);


    }

    public void checkBoxAll(View v){


    }


    public void refreshButton(View v){
        recreate();
    }


}
