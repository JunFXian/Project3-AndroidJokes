package com.udacity.gradle.builditbigger.async;

/**
 * Created by Jun on 21/08/2017.
 */

public interface AsyncTaskCompleteListener <T>
{
    /**
     * Invoked when the AsyncTask has completed its execution.
     * @param result The resulting object from the AsyncTask.
     */
    void onTaskComplete(T... result);
}
