package com.udacity.gradle.builditbigger.tests;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointAsync;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AndroidTestClass {


    @Test
    public void checkResponse() {
        EndpointAsync endpointAsync = new EndpointAsync();

        try {
            String value = endpointAsync.get(30, TimeUnit.SECONDS);
            assertNotNull(value);
            assert (value.length() > 0);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
