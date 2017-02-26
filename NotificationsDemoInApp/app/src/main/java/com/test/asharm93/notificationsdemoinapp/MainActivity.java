package com.test.asharm93.notificationsdemoinapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;
    private int notificationID=100;
    private int numMessages=0;
    Button startBtn,cancelBtn,updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn=(Button)findViewById(R.id.start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dislplayNotification();
            }
        });

        cancelBtn=(Button)findViewById(R.id.cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNotification();
            }
        });

        updateBtn=(Button)findViewById(R.id.update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNotification();
            }
        });


    }

    protected void dislplayNotification(){
        Log.d("Start"," notification ");

        /**
         * Invoking the default Notification Service
         * */

        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("New Message");
        mBuilder.setContentText("you have received a new message. ");
        mBuilder.setTicker("New Message Alert !");
        mBuilder.setSmallIcon(R.drawable.abc);

        /**
         * Increase notification number everytime a new notification arrives
         * */
        mBuilder.setNumber(++numMessages);


        /**
         * Add Big View Specific Configuration
         * */
        NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle();

        String[] events=new String[6];
        events[0]=new String("This is the first line....");
        events[1]=new String("This is the second line....");
        events[2]=new String("This is the third line....");
        events[3]=new String("This is the fourth line....");
        events[4]=new String("This is the fifth line....");
        events[5]=new String("This is the sixth line....");


        //sets a title for the inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details :");

        //Move events into the big view
        for(int i=0;i<events.length;i++){
            inboxStyle.addLine(events[i]);
        }
        mBuilder.setStyle(inboxStyle);

        /**
         * Creates an explicit intent for an Activity in your app
         * */
        Intent result=new Intent(this, NotificationView.class);

        TaskStackBuilder stackBuilder= TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationView.class);

        /**
         * Adds the Intent that starts the Activity to the top of the stack
         * */
        stackBuilder.addNextIntent(result);
        PendingIntent resultPendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        /**
         * notificationID allows you to update the notification later on
         * */

        mNotificationManager.notify(notificationID,mBuilder.build());

    }

    protected void cancelNotification(){
        Log.d("Cancel"," notification ");
        if(notificationID!=0)
        mNotificationManager.cancel(notificationID);
        else
            Toast.makeText(this,"the notification id is "+notificationID,Toast.LENGTH_SHORT);
    }

    protected void updateNotification(){
        Log.d("Update "," Notification ");

        /**
         * Invoking the default notification Service
         * */
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Updated Message");
        mBuilder.setContentText("You have got updated message. ");
        mBuilder.setTicker("Updated Message Alert! ");
        mBuilder.setSmallIcon(R.drawable.abc);

        /**
         * Increase in the number every time a new notification arrives
         * */
        mBuilder.setNumber(++numMessages);

        /**
         * Creates an explicit intent for an activity in your app
         * */
        Intent result=new Intent(this,NotificationView.class);

        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationView.class);

        /**
         * Adds intent that starts the activity to the top of the stack
         * */
        stackBuilder.addNextIntent(result);

        PendingIntent resultPendingIntent=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);


        mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        /***
         * Update the existing notification using the same Notification ID
         */
      mNotificationManager.notify(notificationID,mBuilder.build());

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
