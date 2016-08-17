package cn.berserker.projectlearning.presentation.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.berserker.projectlearning.R;
import hugo.weaving.DebugLog;
import timber.log.Timber;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    @DebugLog
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.testClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLog(v);
            }
        });
    }

    @DebugLog
    private void calculateLog(View view) {
        Timber.i("A button with ID %s was clicked to say '%s'.", view.getId(), ((Button)view).getText());
    }
}
