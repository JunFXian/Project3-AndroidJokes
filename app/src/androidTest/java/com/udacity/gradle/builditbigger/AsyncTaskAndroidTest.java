/**
 * Created by Jun Xian for Udacity Android Developer Nanodegree project 3
 * Date: Aug 17, 2017
 * Reference:
 *      http://roisagiv.github.io/blog/2014/01/06/testing-a-loader-using-instrumentation/
 *      https://stackoverflow.com/questions/33396311/instrumentation-testing-getactivity-is-causing-a-nullpointerexception
 *      https://stackoverflow.com/questions/9405561/test-if-a-button-starts-a-new-activity-in-android-junit-pref-without-robotium
 */

package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.udacity.gradle.builditbigger.async.AsyncTaskCompleteListener;
import com.udacity.gradle.builditbigger.async.JokesAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskAndroidTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private String myJoke = null;
    private MainActivity mActivity;
    public AsyncTaskAndroidTest() {
        super(MainActivity.class);
    }

    @Test
    public void testJokesAsyncTask() {
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
        new JokesAsyncTask(mActivity, new JokesAsyncTaskCompleteListener()).execute();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("InstrucmentationTest", myJoke);
        assertTrue(!myJoke.isEmpty());
    }

    public class JokesAsyncTaskCompleteListener implements AsyncTaskCompleteListener<String> {
        @Override
        public void onTaskComplete(String... result) {
            myJoke = result[0];
        }
    }
}
