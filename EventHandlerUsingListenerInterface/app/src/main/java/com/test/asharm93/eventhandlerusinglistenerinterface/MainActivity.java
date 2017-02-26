package com.test.asharm93.eventhandlerusinglistenerinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button sButton,lButton;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finds bot of the buttons
        sButton=(Button)findViewById(R.id.button_s);
        lButton=(Button)findViewById(R.id.button_l);

        //register click event
        sButton.setOnClickListener(this);
        lButton.setOnClickListener(this);


    }

    //implement the OnClickListener callback
    public void onClick(View v){
        if(v.getId()==R.id.button_s){
            tv1=(TextView)findViewById(R.id.tv1);
            tv1.setTextSize(15);
            return;
        }
        if(v.getId()==R.id.button_l){
            tv1=(TextView)findViewById(R.id.button_l);
            tv1.setTextSize(29);
            return;
        }
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
