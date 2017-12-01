package memelord.com.bro_finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar broToolbar = (Toolbar)findViewById(R.id.toptoolbar);
       //setSupportActionBar(broToolbar);
    }

public void tologin(View v){
        goToLoginPage();
}

    public void goToLoginPage(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
