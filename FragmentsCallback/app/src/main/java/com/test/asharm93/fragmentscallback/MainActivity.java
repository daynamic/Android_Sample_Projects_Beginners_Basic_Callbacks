package com.test.asharm93.fragmentscallback;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config= getResources().getConfiguration();

        FragmentManager fManager= getFragmentManager();
        FragmentTransaction fTransaction=fManager.beginTransaction();

        /**
         * Check the device orientation and act accordingly
         * */

        if(config.orientation== Configuration.ORIENTATION_LANDSCAPE){
            /**
             * Landscape Mode of the device
             * */

            LM_Fragment ls_fragment = new LM_Fragment();
            fTransaction.replace(android.R.id.content,ls_fragment);

        }
        else{
            /**
             * Portrait Mode of the device
             * */

            PM_Fragment pm_fragment= new PM_Fragment();
            fTransaction.replace(android.R.id.content,pm_fragment);
        }

        fTransaction.commit();
    }


    public void Click(View view){
        Intent i = new Intent(MainActivity.this,NewActivity.class);
        startActivity(i);
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
