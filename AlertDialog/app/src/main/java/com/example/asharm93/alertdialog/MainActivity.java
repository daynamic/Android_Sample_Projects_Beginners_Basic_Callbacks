package com.example.asharm93.alertdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Click(View v){
        AlertDialog.Builder alertdialogbuilder= new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("Please make a choice");
        alertdialogbuilder.setPositiveButton("+ive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(getApplicationContext(), PositiveActivity.class);
                startActivity(i);
            }
        });
        alertdialogbuilder.setNegativeButton("-ive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), NegativeActivity.class);
                startActivity(i);
            }
        });
         AlertDialog alertDialog= alertdialogbuilder.create();
        alertDialog.show();

    }

}
