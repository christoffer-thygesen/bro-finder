package memelord.com.bro_finder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void passwordRecovery(View v){

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =(int)(dm.widthPixels*.8); //80% Screen size
        int height =(int)(dm.heightPixels*0.5); //50% Screen size

        new PopupWindow(width,height);
    }

    public void userRegister(View v){
Intent intent = new Intent(LoginActivity.class,RegisterUserActivity.class);
        startActivity(intent);
    }
}
