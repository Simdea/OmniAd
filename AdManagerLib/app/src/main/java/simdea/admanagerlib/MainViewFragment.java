package simdea.admanagerlib;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import simdea.admanager.Manager;

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

        Manager layout = (Manager) v.findViewById(R.id.admanager);


        return v;
    }
}
