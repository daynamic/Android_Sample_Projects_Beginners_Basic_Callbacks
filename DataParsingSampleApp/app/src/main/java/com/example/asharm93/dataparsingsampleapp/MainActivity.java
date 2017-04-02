package com.example.asharm93.dataparsingsampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String url="http://api.openweathermap.org/data/2.5/weather?q=";
    private EditText location, country, temperature, humidity, pressure;
    private Button b1;
    private HandleJSON obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location=(EditText)findViewById(R.id.et1);
        country=(EditText)findViewById(R.id.et2);
        temperature=(EditText)findViewById(R.id.et3);
        humidity=(EditText)findViewById(R.id.et4);
        pressure=(EditText)findViewById(R.id.et5);
        b1=(Button)findViewById(R.id.Button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1=location.getText().toString();
                String finalurl=url+url1;
                country.setText(finalurl);
                obj=new HandleJSON(finalurl);
                obj.fetchJSON();

                while(obj.parsingComplete);
                country.setText(obj.getCountry());
                temperature.setText(obj.getTemperature());
                humidity.setText(obj.getHumidity());
                pressure.setText(obj.getPressure());

            }
        });

    }
}
