package memelord.com.bro_finder;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyProfileActivity extends AppCompatActivity {
    FirebaseUser broUser = FirebaseAuth.getInstance().getCurrentUser();

    private static final String TAG = "ManageUser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        android.support.v7.widget.Toolbar brobar = (Toolbar)findViewById(R.id.toptoolbar);
        setSupportActionBar(brobar);

        ActionBar broActionBar = getSupportActionBar();
        broActionBar.setDisplayHomeAsUpEnabled(true);

        TextView account_Email = (TextView)findViewById(R.id.accountEmail);
        account_Email.setText("Current E-mail: " + broUser.getEmail());
        AuthCredential creds = EmailAuthProvider.getCredential("user@example.com","password1234");
        broUser.reauthenticate(creds); //get authentication of user upon visit of manage user page
    }



    public void changeEmailButton(View v){
        String tet = findViewById(R.id.inputEmail).
     broUser.updateEmail().addOnCompleteListener(new OnCompleteListener<Void>() {
         @Override
         public void onComplete(@NonNull Task<Void> task) {
             if (task.isSuccessful()) {
                 Log.d(TAG, "User email updated");
                 Toast.makeText(MyProfileActivity.this, "e-mail successfully updated!",
                         Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(MyProfileActivity.this, "e-mail not complete",
                         Toast.LENGTH_SHORT).show();
             }
         }
     });

    }
/*
    public void changePasswordButton(View v){

        broUser = FirebaseAuth().getCurrentUser;
        var newPassword = getASecureRandomPassword();

        broUser.updatePassword(newPassword).then(function() {
            // Update successful.
        }).catch(function(error) {
            // An error happened.
        });

    }

    public void deleteAccount(View v){


        broUser.delete().then(function() {
            // User deleted.
        }).catch(function(error) {
            // An error happened.
        });

    }*/

    }


