package com.example.asharm93.cameraappusingcameraapi;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.security.spec.ECField;

/**
 * Created by asharm93 on 3/26/17.
 */

public class ShowCamera extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holdMe;
    private Camera theCamera;

    public ShowCamera(Context context, Camera camera){
        super(context);
        theCamera=camera;
        holdMe=getHolder();
        holdMe.addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        try{
            theCamera.setPreviewDisplay(holder);
            theCamera.startPreview();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0){

    }


}
