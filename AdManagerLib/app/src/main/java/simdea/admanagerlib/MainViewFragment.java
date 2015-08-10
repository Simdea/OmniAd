package simdea.admanagerlib;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import simdea.admanager.AdManager;

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

        //Initialize Manager
        AdManager adManager = new AdManager(getActivity(), null);


        //Inject Manager view to App layout
        layout.addView(adManager.getRootView());


        return v;
    }
}
