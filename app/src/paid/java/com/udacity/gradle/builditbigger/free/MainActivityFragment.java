package com.udacity.gradle.builditbigger.free;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.EndpointAsyncWithContext;
import com.udacity.gradle.builditbigger.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

    private Button mTellJokeBtn;
    private ProgressBar mProgress;

    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        mTellJokeBtn = root.findViewById(R.id.btn_tell_joke);
        mProgress = root.findViewById(R.id.progressBar);
        mTellJokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJoke();
            }
        });

        return root;
    }

    private void getJoke() {
        EndpointAsyncWithContext endpointAsyncWithContext = new EndpointAsyncWithContext(this.getActivity(), mProgress);
        endpointAsyncWithContext.execute();
    }
}
