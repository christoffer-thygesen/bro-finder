package memelord.com.bro_finder;

import android.content.Intent;
import android.provider.ContactsContract;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;

    private android.support.v7.widget.Toolbar brobar;

    private ListView eventListView;

    private SeekBar searchRadius;

    private TextView searchRadiusText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeSeekbar(); //initializes seekbar with units and seekbar.onchangelistener

        //init databaseManager
        databaseManager = DatabaseManager.getInstance(this);
        //databaseManager.initialize(this, eventListView);

     android.support.v7.widget.Toolbar brobar = (Toolbar)findViewById(R.id.toptoolbar);
        setSupportActionBar(brobar);

        ActionBar broActionBar = getSupportActionBar();
        broActionBar.setDisplayHomeAsUpEnabled(true);

        //setting Search Radius Seekbar
        searchRadiusText.setText("Distance " + searchRadius.getProgress() + " Km");
        searchRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
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
            }
        });
    }

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
}
