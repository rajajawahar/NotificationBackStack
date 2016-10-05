package com.example.raja.notificationstackexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ((TextView) findViewById(R.id.tv)).setText(getIntent().getIntExtra("Id", -1) + "");

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ((TextView) findViewById(R.id.tv)).setText(getIntent().getIntExtra("Id", -1) + "");
    }
}
