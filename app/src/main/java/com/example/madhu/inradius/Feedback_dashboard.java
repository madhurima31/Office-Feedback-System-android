package com.example.madhu.inradius;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MadhuRima on 19-03-2017.
 */

public class Feedback_dashboard extends Fragment {
    android.support.v7.widget.Toolbar toolbar;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.feedback, container, false);
            toolbar = (android.support.v7.widget.Toolbar)view.findViewById(R.id.toolbar);
//            toolbar.setTitle("InRadius");
//            toolbar.setSubtitle("Inside HighRadius");

            toolbar.inflateMenu(R.menu.upper_menu);
            return view;
        }

        public static Feedback_dashboard newInstance() {
            Feedback_dashboard fragment = new Feedback_dashboard();
            return fragment;
        }

    }


