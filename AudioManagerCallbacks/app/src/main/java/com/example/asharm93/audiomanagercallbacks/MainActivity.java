package com.example.asharm93.audiomanagercallbacks;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button viberate, ring,silent,mode;
    private TextView Status;
    private AudioManager myAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mode=(Button)findViewById(R.id.button);
        ring=(Button)findViewById(R.id.button2);
        silent=(Button)findViewById(R.id.button3);
        viberate=(Button)findViewById(R.id.button4);
        Status=(TextView)findViewById(R.id.textView2);

        myAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mod=myAudioManager.getRingerMode();
                if(mod==AudioManager.RINGER_MODE_NORMAL){
                    Status.setText("Current Status : Ring");
                }
                else if(mod==AudioManager.RINGER_MODE_SILENT){
                    Status.setText("Current Status : Silent");
                }
                else if(mod==AudioManager.RINGER_MODE_VIBRATE){
                    Status.setText("Current Status : Vibrate");
                }
                else{

                }
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });

        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
        });

        viberate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });
    }
}
