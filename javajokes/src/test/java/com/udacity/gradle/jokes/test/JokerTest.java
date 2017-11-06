/**
 * Created by Jun on 15/08/2017.
 * References:
 *      https://classroom.udacity.com/nanodegrees/nd801/parts/8995005d-dc19-4c5f-b912-183c9a421c04
 *      https://github.com/udacity/ud867/tree/master/4.01-Demo-CreatingAJavaLibrary
 */

package com.udacity.gradle.jokes.test;

import com.udacity.gradle.jokes.Joker;

import org.junit.Test;

public class JokerTest {
    @Test
    public void test() {
        Joker joker = new Joker();
        assert joker.getJoke().length() != 0;
    }
}
