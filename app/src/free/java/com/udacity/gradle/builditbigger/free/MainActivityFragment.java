package com.udacity.gradle.builditbigger.free;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.EndpointAsyncWithContext;
import com.udacity.gradle.builditbigger.R;


public class MainActivityFragment extends Fragment {

    private Button mTellJokeBtn;
    private ProgressBar mProgress;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        MobileAds.initialize(this.getActivity(), getString(R.string.banner_ad_unit_id));

        mTellJokeBtn = root.findViewById(R.id.btn_tell_joke);
        mProgress = root.findViewById(R.id.progressBar);
        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mTellJokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAd();
                getJoke();
            }
        });
        return root;
    }

    private void getJoke() {
        EndpointAsyncWithContext endpointAsyncWithContext = new EndpointAsyncWithContext(MainActivityFragment.this.getActivity(), mProgress);
        endpointAsyncWithContext.execute();
    }

    private void loadAd() {
        if (getActivity() != null) {
            final InterstitialAd interstitialAd = new InterstitialAd(getActivity());
            interstitialAd.setAdUnitId("/6499/example/interstitial");
            interstitialAd.loadAd(new AdRequest.Builder().build());

            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    interstitialAd.show();
                }
            });
        }
    }
}
