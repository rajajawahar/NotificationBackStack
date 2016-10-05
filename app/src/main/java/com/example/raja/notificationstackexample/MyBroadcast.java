package com.example.raja.notificationstackexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by raja on 10/5/16.
 */

public class MyBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Inside onReceive", Toast.LENGTH_SHORT).show();
        int id = new Random().nextInt();


        Intent launchIntent = new Intent(context, SecondActivity.class).putExtra("Id", id);

        launchIntent.setData(new Uri.Builder().scheme("data")
                .appendQueryParameter("text", "my text").build());
        launchIntent.putExtra("Id", id);
        launchIntent.setAction(id + "");

        Intent parentIntent = new Intent(context, FirstActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        PendingIntent resultPendingIntent =
                stackBuilder.addNextIntentWithParentStack(parentIntent).addNextIntent(launchIntent).
                        getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationCompatBuilder =
                new NotificationCompat.Builder(context);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(id, notificationCompatBuilder.build());
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationCompatBuilder.setAutoCancel(true).
                setContentTitle("First Notification").
                setContentText("Initial Notification").
                setSmallIcon(R.mipmap.ic_launcher).
                setContentIntent(resultPendingIntent);
        mNotifyMgr.notify(id, notificationCompatBuilder.build());
    }
}
