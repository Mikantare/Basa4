package com.bespalov.basa4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;

public class AddToDoActivity extends AppCompatActivity {

    private EditText editPerformer;
    private EditText editEndDate;
    private EditText editDescription;
    private TextView startDate;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        editPerformer = findViewById(R.id.editPerformer);
        editEndDate = findViewById(R.id.editEndDate);
        editDescription = findViewById(R.id.editDescription);
        startDate = findViewById(R.id.startDate);
        Date date = new Date();
        startDate.setText(date.toString());


    }
}