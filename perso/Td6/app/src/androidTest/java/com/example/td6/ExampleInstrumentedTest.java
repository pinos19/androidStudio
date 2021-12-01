package com.example.td6;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        GithubService service = RetrofitUtil.get();
        Call<String> call = service.listRepos("jorisdeguet");
        Response<String> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultat = response.body();
        Log.i("RETROFIT",resultat);
    }
    @Test
    public void testSimpleUtilisateur() throws IOException{
        // Context of the app under test.
        GithubService service = RetrofitUtil.get();
        Call<String> call = service.utilisateur("jorisdeguet");
        Response<String> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultat = response.body();
        Log.i("RETROFIT",resultat);
    }
}