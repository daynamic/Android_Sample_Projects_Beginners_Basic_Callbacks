package com.test.asharm93.fragmentscallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class NewActivity extends AppCompatActivity {
    String msg="Android : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Log.d(msg, "The onCreate() event");
    }
    /**Called when the Activity is about to get visible*/
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(msg,"The onStart() event");
    }

    /**Called when the activity has become visible*/
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(msg,"The onResume() event");
    }

    /**Called when another Activity is taking focus*/
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(msg,"The onPause() event");
    }

    /**Called when the activity is no longer visible*/
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(msg,"The onStop() event");
    }

    /**Called just before the Activity is destroyed*/
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(msg,"The onDestroy() event");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new, menu);
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
