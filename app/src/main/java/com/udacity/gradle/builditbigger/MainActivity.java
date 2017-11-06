/**
 * Created by Jun Xian for Udacity Android Developer Nanodegree project 3
 * Date: Aug 14, 2017
 * Reference:
 *      https://developers.google.com/admob/android/quick-start
 *      https://github.com/udacity/ud867/tree/master/FinalProject
 *      https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */

package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
//import android.widget.Toast;

import com.udacity.gradle.androidjokes.AndroidLibraryActivity;
import com.udacity.gradle.builditbigger.async.AsyncTaskCompleteListener;
import com.udacity.gradle.builditbigger.async.JokesAsyncTask;
//import com.udacity.gradle.jokes.Joker;


public class MainActivity extends AppCompatActivity{
    public String mJoke = null;
    ProgressBar spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (ProgressBar) findViewById(R.id.progress_bar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onTellJokeButtonClicked(View view) {
        spinner.setVisibility(View.VISIBLE);
        new JokesAsyncTask(this, new JokesAsyncTaskCompleteListener()).execute();
    }

    public class JokesAsyncTaskCompleteListener implements AsyncTaskCompleteListener<String> {
        @Override
        public void onTaskComplete(String... result) {
            mJoke = result[0];
            if (mJoke != null) {
//                Joker myJoker = new Joker();
//                String myJokerString = myJoker.getJoke();
                //                Toast.makeText(this, myJokerString, Toast.LENGTH_SHORT).show();
                //launch the activity from androidjokes library
                Intent myIntent = new Intent(MainActivity.this, AndroidLibraryActivity.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, mJoke);
                spinner.setVisibility(View.GONE);
                startActivity(myIntent);
            } else {
                mJoke = "";
            }
        }
    }

}
