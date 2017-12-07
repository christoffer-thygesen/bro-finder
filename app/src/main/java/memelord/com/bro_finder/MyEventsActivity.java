package memelord.com.bro_finder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        final ArrayList<Event> myEventsList = new ArrayList<>();
        final MyEventsAdapter myAdapter = new MyEventsAdapter(this,myEventsList);
        final MyEventsAdapter myParticipatingEventsAdapter = new MyEventsAdapter(this,myEventsList);

        Event a = new Event("123", "Kicking a ball", "Football", "abc", "John", 5, 2,  2017, 06022017, 333, 444);
        Event b = new Event("1234", "Kicking a bottle", "Beer", "ab", "Jo", 6, 2,  2017, 06022017, 333, 444);
        Event c = new Event("1235", "Kicking ", "Walk", "abcd", "Johnathan", 5, 3,  2017, 06022017, 333, 444);
        myEventsList.add(0,a);
        myEventsList.add(1,b);
        myEventsList.add(2,c);


        ListView myEvents = findViewById(R.id.MyEventList);
        myEvents.setAdapter(myAdapter);
        ListView participatingEvents = findViewById(R.id.myParticipatingEvents);
        participatingEvents.setAdapter(myParticipatingEventsAdapter);



        /*
       for(Event myEvents : myEventList) {
   if(Event.getId(creatorID).equals(someId) {
   ListView myEvents = (ListView)findViewById(R.id.myEventList);
       //found it!
   }
}

for(Event myParticipatingEvents : myEventList)(
if(Event.getId( *id = participating*?){
ListView participatingEvents = (ListView)findViewById(R.id.myParticipatingEvents);
        * */





    }
/*
    public void checkBoxAll(View v){
int events = myEvents.getCount();
for(int i = 0; i<events;i++){
myEvents.setItemChecked(i,true);
}}*/


    public void refreshButton(View v){

        recreate();
        Toast.makeText( MyEventsActivity.this, "Refreshed page",
                Toast.LENGTH_SHORT).show();
    }


}
