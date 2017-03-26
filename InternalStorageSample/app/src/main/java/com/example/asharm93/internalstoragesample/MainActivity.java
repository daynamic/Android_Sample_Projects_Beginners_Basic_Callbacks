package com.example.asharm93.internalstoragesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private Button save, read;
    private String data,file ="mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.et1);
        save=(Button)findViewById(R.id.button1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=et.getText().toString();
                try{
                    FileOutputStream fOut=openFileOutput(file, MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(MainActivity.this, "file saved", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        read=(Button)findViewById(R.id.button2);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fIn=openFileInput(file);
                    int c;
                    String temp="";
                    while((c=fIn.read())!=-1){
                        temp=temp+Character.toString((char)c);

                    }
                    Toast.makeText(MainActivity.this, "Here is what you saved "+temp, Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
