package memelord.com.bro_finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgotPasswordActivity extends AppCompatActivity {
    FirebaseAuth broAuth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = broAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void backToLogin(View v){
    Intent intent = new Intent(this,LoginActivity.class);
    startActivity(intent);
    }

    public void pwRecover(View v){
/*
      broAuth emailAddress = "user@example.com";

        broAuth.sendPasswordResetEmail(emailAddress).then(function() {
            // Email sent.
        }).catch(function(error) {
            // An error happened.
        });*/

    }

}
