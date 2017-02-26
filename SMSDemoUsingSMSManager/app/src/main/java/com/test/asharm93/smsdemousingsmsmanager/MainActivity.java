package com.test.asharm93.smsdemousingsmsmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendsms;
    EditText txtphonenum,txtMessage;
    String msg="Android :";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendsms=(Button)findViewById(R.id.btnSend);
        txtMessage=(EditText)findViewById(R.id.editTextSMS);
        txtphonenum=(EditText)findViewById(R.id.editTextPhoneNumber);

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    public void sendSMS(){
        Log.d(msg,"Send SMS  ");

        String phone=txtphonenum.getText().toString();
        String msgg=txtMessage.getText().toString();

        try{
            SmsManager sms= SmsManager.getDefault();
            sms.sendTextMessage(phone,null,msgg,null,null);
            Toast.makeText(getApplicationContext(), "SMS sent.,,", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "SMS failed, please try again later...", Toast.LENGTH_SHORT).show();
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
