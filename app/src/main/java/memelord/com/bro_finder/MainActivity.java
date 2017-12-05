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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;

    private android.support.v7.widget.Toolbar brobar;

    private ListView eventListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init databaseManager
        //databaseManager.getInstance(this);
        //databaseManager.initialize(this, eventListView);

     android.support.v7.widget.Toolbar brobar = (Toolbar)findViewById(R.id.toptoolbar);
        setSupportActionBar(brobar);

        ActionBar broActionBar = getSupportActionBar();
        broActionBar.setDisplayHomeAsUpEnabled(true);
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
}
