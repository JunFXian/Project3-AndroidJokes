package com.udacity.gradle.androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_library);

        Intent intentFromMainActivity = getIntent();
        // check if the intent and its data can pass correctly
        if (intentFromMainActivity != null) {
            if (intentFromMainActivity.hasExtra(Intent.EXTRA_TEXT)) {
                String myJokeContent = intentFromMainActivity.getStringExtra(Intent.EXTRA_TEXT);
                TextView jokeView = (TextView) findViewById(R.id.joke_content);
                jokeView.setText(myJokeContent);
            }
        }
    }
}
