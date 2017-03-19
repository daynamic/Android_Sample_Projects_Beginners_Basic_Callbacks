package com.example.asharm93.bestpracticesandroidbasic;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {


    private Button check;
    private BatteryManager battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check=(Button)findViewById(R.id.button);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter ifilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                Intent batteryStatus= registerReceiver(null, ifilter);
                int status=batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

                boolean isCharging= status ==
                        BatteryManager.BATTERY_STATUS_CHARGING ||
                        status ==BatteryManager.BATTERY_STATUS_FULL;

                //How are we charging

                int chargePlug=batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                boolean usbCharge= chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                boolean acCharge= chargePlug==BatteryManager.BATTERY_PLUGGED_AC;

                if(usbCharge){
                    Toast.makeText(MainActivity.this, "Mobile is charging on USB", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Mobile is charging on AC", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
