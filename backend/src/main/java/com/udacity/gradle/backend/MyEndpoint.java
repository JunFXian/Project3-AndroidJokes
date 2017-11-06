/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.gradle.udacity.com",
                ownerName = "backend.gradle.udacity.com"
        )
)
public class MyEndpoint {
    /**
     * A endpoint method that takes a name and returns the joke
     */
    @ApiMethod(name = "getJokesFromLibrary")
    public MyBean getJokesFromLibrary() {
        MyBean response = new MyBean();
        Joker myJoker = new Joker();
        String myJokerString = myJoker.getJoke();
        response.setData(myJokerString);
        return response;
    }
}
