package pireslabs.com.backgroundtests.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pireslabs.com.backgroundtests.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoneFragment extends AbstractBasicFragment {


    public DoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this replaceFragment
        return inflater.inflate(R.layout.fragment_done, container, false);
    }

}
