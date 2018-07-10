package com.simdea.omniad.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simdea.omniad.AdMobProvider;
import com.simdea.omniad.RandomAdView;


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

        RandomAdView layout = v.findViewById(R.id.admanager);
        layout.register(new AdMobProvider(getContext(), "ca-app-pub-6371453241242670/8838057599"));
        layout.loadAds(getContext());
        return v;
    }
}
