package com.test.asharm93.fragmentscallback;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by asharm93 on 12/8/2016.
 */
public class LM_Fragment extends Fragment {
String msg="Android : ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(msg,"in onCreat of landscape mode");
       /**
        * Inflate the layout for this fragment
        * */
        return inflater.inflate(R.layout.lm_fragment,container,false);

    }
}
