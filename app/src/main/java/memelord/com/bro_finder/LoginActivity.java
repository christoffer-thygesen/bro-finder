package memelord.com.bro_finder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth broAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        broAuth = FirebaseAuth.getInstance();
        Button loginButton = (Button)findViewById(R.id.loginButton);
    }

    @Override
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = broAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void passwordRecovery(View v){

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =(int)(dm.widthPixels*.8); //80% Screen size
        int height =(int)(dm.heightPixels*0.5); //50% Screen size

        new PopupWindow(width,height);
    }

    public void userRegister(View v){
Intent intent = new Intent(this,RegisterUserActivity.class);
        startActivity(intent);
    }

    public void loginButtonClick(View v){


            }

    public void signIn(String email,String password){
        broAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.d(TAG, "sgnInWithEmail:Success");
                            FirebaseUser user = broAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "signInWithEmail:Failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed."),
                                    Toast.LENGTH_SHORT).show();
                            UpdateUI(null);
                        }

        })
    }
}
