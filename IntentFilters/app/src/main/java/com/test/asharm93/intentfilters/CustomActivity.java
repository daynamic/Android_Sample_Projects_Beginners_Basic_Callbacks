package com.test.asharm93.intentfilters;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by asharm93 on 12/11/2016.
 */
public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);

        TextView label=(TextView)findViewById(R.id.show_data);

        Uri url=getIntent().getData();
        label.setText(url.toString());

    }
}
