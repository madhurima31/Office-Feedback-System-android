package com.example.madhu.inradius;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MadhuRima on 19-03-2017.
 */

public class Discussions_dashboard extends Fragment {
    android.support.v7.widget.Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.discussions, container, false);

        toolbar = (android.support.v7.widget.Toolbar)view.findViewById(R.id.toolbar);
        return view;
    }

    public static Discussions_dashboard newInstance() {
        Discussions_dashboard fragment = new Discussions_dashboard();
        return fragment;
    }
}
