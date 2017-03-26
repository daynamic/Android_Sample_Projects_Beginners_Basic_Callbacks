package com.example.asharm93.cameraappusingdefaultsystemapp;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends RuntimePermissionsActivity {

    private ImageView img;
    public static final int REQUEST_PERMISSIONS = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=(ImageView)findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.requestAppPermissions(new
                        String[]{Manifest.permission.CAMERA,
                        }, R.string
                        .runtime_permissions_txt, REQUEST_PERMISSIONS);
            }
        });

    }
    @Override
    public void onPermissionsGranted(final int requestCode) {
        Toast.makeText(this, "Permission Received.", Toast.LENGTH_LONG).show();
        opencam();
    }

    public void opencam(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bp=(Bitmap) data.getExtras().get("data");
        img.setImageBitmap(bp);
    }

}
