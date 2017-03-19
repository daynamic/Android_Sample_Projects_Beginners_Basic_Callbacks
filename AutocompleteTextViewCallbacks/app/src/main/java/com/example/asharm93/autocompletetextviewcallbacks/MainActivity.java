package com.example.asharm93.autocompletetextviewcallbacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;
    private MultiAutoCompleteTextView mactv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String[] countries=getResources().getStringArray(R.array.countries);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);

        actv=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        mactv=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);

        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
