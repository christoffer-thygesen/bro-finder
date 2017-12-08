package memelord.com.bro_finder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;

    private android.support.v7.widget.Toolbar brobar;

    private ListView eventListView;

    private SeekBar searchRadius;

    private TextView searchRadiusText;




    //https://androidkennel.org/android-tutorial-getting-the-users-location/ Location  && https://developer.android.com/guide/topics/location/strategies.html
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE); //error
        boolean enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(!enabled) {
            Toast.makeText( MainActivity.this, "Please turn on GPS!",
                    Toast.LENGTH_SHORT).show();
        }
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                makeUseOfNewLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        String locationProvider = LocationManager.GPS_PROVIDER; //use GPS for determining Location of user

        if(checkPermission(locationProvider) == true){
        locationManager.requestLocationUpdates(locationProvider,0,0,locationListener);}

        final ListView events = findViewById(R.id.eventList);
        final ArrayList<Event> eventsListing = new ArrayList<>();
        final EventAdapter myAdapter2 = new EventAdapter(this, eventsListing);

        Event d = new Event("123", "Kicking a ball", "Football", "abc", "John", 5, 2, 2017, 06022017, 333, 444, 555);
        Event e = new Event("1234", "Kicking a bottle", "Beer", "ab", "Jo", 6, 2, 2017, 06022017, 333, 444, 555);
        Event f = new Event("1235", "Kicking ", "Walk", "abcd", "Johnathan", 5, 3, 2017, 06022017, 333, 444, 555);
        eventsListing.add(0, d);
        eventsListing.add(1, e);
        eventsListing.add(2, f);

        events.setAdapter(myAdapter2);


        initializeSeekbar(); //initializes seekbar with units and seekbar.onchangelistener

        //init databaseManager
        databaseManager = DatabaseManager.getInstance(this);
        //databaseManager.initialize(this, eventListView);

     android.support.v7.widget.Toolbar brobar = (Toolbar)findViewById(R.id.toptoolbar);
        setSupportActionBar(brobar);

        ActionBar broActionBar = getSupportActionBar();
        broActionBar.setDisplayHomeAsUpEnabled(true);

        //setting Search Radius Seekbar
        searchRadius.setProgress(10); //default value 10 km
        searchRadiusText.setText("Distance " + searchRadius.getProgress() + " Km");
        searchRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 10; //default value 10 km
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                searchRadiusText.setText("Distance " + progress + " km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                searchRadiusText.setText("Distance " + progress + " km");
                //set new radius by method & call recreate()?

                /*
                Location loc1 = new Location("User"); //user Location
                loc1.getLatitude();
                loc1.getLongitude();

                loc1.distanceTo(events);
                if(loc1.distanceTo(events)<= progress)
                */
            }
        });

    }

    /*    Collections.sort(events, new Comparator<Event>() {
            public int compare(Event a, Event b){
               // return b.getDate().compareTo(a.getDate());
                return 0;
            }
        });
    }*/

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(this,MyProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.myevents_action:
                Intent intent2 = new Intent(this,MyEventsActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public void tologin(View v){
        goToLoginPage();
    }


    public void goToLoginPage() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void toCreateEvent(View view) {
        Intent intent = new Intent(this,CreateEventActivity.class);
        startActivity(intent);
    }

    public void initializeSeekbar(){
        searchRadius = findViewById(R.id.searchRadius);
        searchRadiusText = findViewById(R.id.searchRadiusUnits);
    }

    public Location makeUseOfNewLocation(Location location){
        Location newLocation = location;
        return newLocation;
    }

    private boolean checkPermission(String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(this,LocationManager.GPS_PROVIDER);
            if (result == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}


