package com.example.madhu.inradius;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MadhuRima on 19-03-2017.
 */

public class Profile_dashboard extends Fragment {
    android.support.v7.widget.Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile, container, false);


        return view;
    }

    public static Profile_dashboard newInstance() {
        Profile_dashboard fragment = new Profile_dashboard();
        return fragment;
    }
}
