package com.example.asharm93.basicanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
@Override
public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.zoomInOut:
            {
                ImageView image=(ImageView)findViewById(R.id.imageview1);
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
                image.startAnimation(animation);
            }
                return true;

            case R.id.rotate360:
            {
                ImageView image1=(ImageView)findViewById(R.id.imageview1);
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                image1.startAnimation(animation);
            }

                return true;

            case R.id.fadeInOut:
            {
                ImageView image2 =(ImageView)findViewById(R.id.imageview1);
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                image2.startAnimation(animation);
            }

                return true;
        }
        return false;

    }


}
