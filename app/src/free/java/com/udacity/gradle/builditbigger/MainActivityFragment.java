/**
 * Created by Jun Xian for Udacity Android Developer Nanodegree project 3
 * Date: Aug 14, 2017
 * Reference:
 *      http://www.tutorialspoint.com/android/android_loading_spinner.htm
 *      https://developers.google.com/admob/android/interstitial
 */

package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.udacity.gradle.builditbigger.BuildConfig;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        MobileAds.initialize(getContext(), BuildConfig.admob_id);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        final ProgressBar spinner = (ProgressBar) root.findViewById(R.id.progress_bar);
        spinner.setVisibility(View.GONE);
        return root;
    }
}
