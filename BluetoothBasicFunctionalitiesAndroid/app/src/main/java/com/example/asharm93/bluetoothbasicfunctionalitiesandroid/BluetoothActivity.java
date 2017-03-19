package com.example.asharm93.bluetoothbasicfunctionalitiesandroid;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    private Button On, Off, Visible, list;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice>pairedDevices;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        BA= BluetoothAdapter.getDefaultAdapter();
        lv=(ListView)findViewById(R.id.list);
        On=(Button)findViewById(R.id.button1);
        Visible=(Button)findViewById(R.id.button2);
        list=(Button)findViewById(R.id.button3);
        Off=(Button)findViewById(R.id.button4);

        On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BA.isEnabled()){
                    Intent turnOn=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn,0);
                    Toast.makeText(BluetoothActivity.this, "Turned On!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(BluetoothActivity.this, "Already On!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(getVisible,0);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pairedDevices = BA.getBondedDevices();
                ArrayList list=new ArrayList();
                for (BluetoothDevice bt: pairedDevices){
                    list.add(bt.getName());
                }
                Toast.makeText(BluetoothActivity.this, "Showing paired Devices!!!", Toast.LENGTH_SHORT).show();
                final ArrayAdapter adapter = new ArrayAdapter(BluetoothActivity.this, android.R.layout.simple_list_item_1,list);
                lv.setAdapter(adapter);
            }
        });

        Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BA.isEnabled())
                {
                BA.disable();
                    Toast.makeText(BluetoothActivity.this, "Turned Off !!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(BluetoothActivity.this, "Not turned On !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
