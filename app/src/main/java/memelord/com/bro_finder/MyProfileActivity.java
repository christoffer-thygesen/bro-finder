package memelord.com.bro_finder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyProfileActivity extends AppCompatActivity {
    FirebaseAuth broAuth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = broAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        broAuth.getCurrentUser();

        android.support.v7.widget.Toolbar brobar = (Toolbar)findViewById(R.id.toptoolbar);
        setSupportActionBar(brobar);

        ActionBar broActionBar = getSupportActionBar();
        broActionBar.setDisplayHomeAsUpEnabled(true);


    }

   /* public void changeEmailButton(View v){

     currentUser.updateEmail("user@example.com").then(function() {
            // Update successful.
        }).catch(function(error) {
            // An error happened.
        });
    }

    public void changePasswordButton(View v){

        currentUser = FirebaseAuth().getCurrentUser;
        var newPassword = getASecureRandomPassword();

        currentUser.updatePassword(newPassword).then(function() {
            // Update successful.
        }).catch(function(error) {
            // An error happened.
        });

    }

    public void deleteAccount(View v){


        currentUser.delete().then(function() {
            // User deleted.
        }).catch(function(error) {
            // An error happened.
        });

    }
*/
    }


