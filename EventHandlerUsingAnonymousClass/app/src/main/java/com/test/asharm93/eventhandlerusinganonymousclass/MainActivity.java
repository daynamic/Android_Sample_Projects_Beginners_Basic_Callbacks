package com.test.asharm93.eventhandlerusinganonymousclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button sButton,lButton;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------ find both the buttons-----
        sButton=(Button)findViewById(R.id.button_s);
        lButton=(Button)findViewById(R.id.button_l);

        //--- register click event with first button
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--- find the text view
                tv1=(TextView)findViewById(R.id.tv1);
                tv1.setTextSize(14);
            }
        });


        //------ register click event of the second button
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1=(TextView)findViewById(R.id.tv1);
                tv1.setTextSize(20);
            }
        });




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
