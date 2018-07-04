package com.example.madhu.inradius;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Madhu on 7/3/2018.
 */



public class Subcriptions_dashboard extends Fragment {
    android.support.v7.widget.Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.subscriptions, container, false);

        toolbar = (android.support.v7.widget.Toolbar)view.findViewById(R.id.toolbar);
        return view;
    }

    public static Feedback_dashboard newInstance() {
        Feedback_dashboard fragment = new Feedback_dashboard();
        return fragment;
    }

}