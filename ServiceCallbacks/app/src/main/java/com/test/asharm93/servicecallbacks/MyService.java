package com.test.asharm93.servicecallbacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by asharm93 on 12/4/2016.
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //let it continue running until it is stopped.
        Toast.makeText(this, "Service Started ",Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed ", Toast.LENGTH_SHORT).show();
    }

}
