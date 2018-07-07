package com.simdea.omniad.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainViewFragment extends Fragment {

    public MainViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_view, container, false);

        FrameLayout layout = (FrameLayout) v.findViewById(R.id.admanager);

        return v;
    }
}
