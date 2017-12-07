package memelord.com.bro_finder;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.gms.location.places.ui.PlacePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateEventActivity extends AppCompatActivity {

    private int PLACE_PICKER_REQUEST = 1;

    private String id;
    private String desc;
    private String commentsID;
    private String creator;
    private Calendar myCalendar;
    private Place location;

    private EditText chooseDate;
    private EditText chooseTime;
    private EditText chooseLocation;
    private Button buttonFinish;
    private DatabaseManager databaseManager;
    private FirebaseAuth broAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        databaseManager = DatabaseManager.getInstance(this);
        chooseDate = findViewById(R.id.textDatePicker);
        chooseTime = findViewById(R.id.textTimePicker);
        chooseLocation = findViewById(R.id.textLocationPicker);
        buttonFinish = findViewById(R.id.buttonFinish);
        myCalendar = Calendar.getInstance();
        broAuth = FirebaseAuth.getInstance();

        final Calendar myCalendar = Calendar.getInstance();

        //DatePickerDialog - pop up
        final DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MMM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

                chooseDate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        final TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                myCalendar.set(Calendar.HOUR_OF_DAY, hour);
                myCalendar.set(Calendar.MINUTE, minute);
                String myFormat = "h:mm";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

                chooseTime.setText(sdf.format(myCalendar.getTime()));
            }
        };

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateEventActivity.this, datePickerListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(CreateEventActivity.this, timePickerListener, myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE), false).show();
            }
        });

        chooseLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(CreateEventActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseManager.getUsername(broAuth.getCurrentUser().getUid());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                location = PlacePicker.getPlace(this, data);

                if(location != null) {
                    chooseLocation.setText(location.getAddress());
                }
            }
        }
    }

    private void AddEvent(String id, String desc, String title, String commentsID,
                          String creator, int day,
                          int month, int year, long timestamp, double location_Lat,
                          double location_Lng) {
        if(!validateForm()) { return; }

        FirebaseUser user = broAuth.getCurrentUser();
//
//        id;
//        desc;
//        commentsID;
//        creator;
//        myCalendar;
//        location;

        Event event = new Event(null, null, null, null, null,
                0, 0,0,0,0,0);
        databaseManager.addEvent(event);
    }

    private boolean validateForm() {
        return true;
    }
}


