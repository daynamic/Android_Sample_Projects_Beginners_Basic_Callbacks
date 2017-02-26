package com.test.asharm93.broadcastreceivercallbacks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by asharm93 on 12/4/2016.
 */
public class MyReceiver extends BroadcastReceiver {
    String msg="Android :";
    /**Mandatory function of Broadcast Receivers*/
    @Override
    public void onReceive(Context context, Intent intent){
        Log.d(msg, "The onReceive() is executed");
        Toast.makeText(context, "Intent detected",Toast.LENGTH_SHORT).show();
    }
}
