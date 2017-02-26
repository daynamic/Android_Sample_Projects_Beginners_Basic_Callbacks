package com.test.asharm93.fragmentscallback;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by asharm93 on 12/8/2016.
 */
public class PM_Fragment extends Fragment {
String msg="Android : ";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(msg, "in onAttach of portrait mode");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(msg, "in onCreate of portrait mode");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         * */
        Log.d(msg, "in onCreateView of portrait mode");
        return inflater.inflate(R.layout.pm_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(msg, "in onActivityCreated of portrait mode");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(msg, "in onStart of portrait mode");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(msg, "in onResume of portrait mode");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(msg, "in onPause of portrait mode");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(msg, "in onStop of portrait mode");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(msg, "in onDestroyView of portrait mode");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "in onDestroy of portrait mode");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(msg, "in onDetach of portrait mode");
    }
}
