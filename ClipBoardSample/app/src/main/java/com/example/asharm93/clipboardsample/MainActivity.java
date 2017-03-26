package com.example.asharm93.clipboardsample;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ClipboardManager myClipbrdmngr;
    private ClipData myClip;
    private EditText copyFeild, pasteFeild;
    private Button copy, paste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myClipbrdmngr=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        copyFeild=(EditText)findViewById(R.id.et1);
        pasteFeild=(EditText)findViewById(R.id.et2);
        copy=(Button)findViewById(R.id.button1);
        paste=(Button)findViewById(R.id.button2);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text=copyFeild.getText().toString();
                myClip=ClipData.newPlainText("text", Text);
                myClipbrdmngr.setPrimaryClip(myClip);
                Toast.makeText(MainActivity.this, "Text Copied", Toast.LENGTH_SHORT).show();
            }
        });

        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData abc=myClipbrdmngr.getPrimaryClip();
                ClipData.Item item=abc.getItemAt(0);
                String text=item.getText().toString();
                pasteFeild.setText(text);
                Toast.makeText(MainActivity.this, "Text Pasted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
