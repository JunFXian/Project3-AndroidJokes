/**
 * Created by Jun Xian for Udacity Android Developer Nanodegree project 3
 * Date: Aug 20, 2017
 * Reference:
 *      http://www.devsplanet.com/question/35796317
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

public class MainActivityFragment extends Fragment {
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        final ProgressBar spinner = (ProgressBar) root.findViewById(R.id.progress_bar);
        spinner.setVisibility(View.GONE);
        return root;
    }
}
