package memelord.com.bro_finder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MyEventsActivity extends AppCompatActivity {

    //final ArrayList<String> eventAdapter = new ArrayList<String>(this,R.layout.custom_row_for_event, a);
   // final PostAdapter postAdapter = new PostAdapter(this, postList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
    }
}
