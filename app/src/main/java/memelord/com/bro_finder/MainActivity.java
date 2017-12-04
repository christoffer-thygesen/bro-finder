package memelord.com.bro_finder;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        databaseManager = DatabaseManager.getInstance(this);

        //intented();
=======
        //Toolbar broToolbar = (Toolbar)findViewById(R.id.toptoolbar);
       //setSupportActionBar(broToolbar);
    }
>>>>>>> ff5478a27d3722c51608979e31424ae998cd7bd2

public void tologin(View v){
        goToLoginPage();
}

<<<<<<< HEAD
    }

    public void intented(){
=======
    public void goToLoginPage(){
>>>>>>> ff5478a27d3722c51608979e31424ae998cd7bd2
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
