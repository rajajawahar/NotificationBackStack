package com.example.raja.notificationstackexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity {


    private MyBroadcast myBroadcast = new MyBroadcast();
    private IntentFilter intentFilter = new IntentFilter("INITIAL CHECK");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        registerReceiver(myBroadcast, intentFilter);
        findViewById(R.id.create_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent("INITIAL CHECK");
                sendBroadcast(intnet);
            }
        });
        Toast.makeText(this, "Normal Intent get called", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "onNewIntent get called", Toast.LENGTH_SHORT).show();
    }


}
