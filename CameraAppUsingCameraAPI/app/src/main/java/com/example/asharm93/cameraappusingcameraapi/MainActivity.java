package com.example.asharm93.cameraappusingcameraapi;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends RuntimePermissionsActivity {

    private Camera camObject;
    private ShowCamera showCamera;
    private ImageView pic;
    private Button show;
    public static final int REQUEST_PERMISSIONS = 20;

    public static Camera isCameraAvailable(){
        Camera object=null;
        try{
            object = Camera.open();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    private PictureCallback capturesIt=new PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera){
            Bitmap bitmap= BitmapFactory.decodeByteArray(data, 0, data.length);
            if(bitmap==null){
                Toast.makeText(MainActivity.this, "Pic not taken", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Pic Taken", Toast.LENGTH_SHORT).show();
            }
            camObject.release();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pic=(ImageView)findViewById(R.id.imageview1);
        camObject= isCameraAvailable();
        showCamera= new ShowCamera(this, camObject);
        FrameLayout preview=(FrameLayout)findViewById(R.id.camera_preview);
        preview.addView(showCamera);
        show=(Button)findViewById(R.id.button_capture);
        show.setOnClickListener(new View.OnClickListener() {
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
        camObject.takePicture(null, null, capturesIt);
    }
}
