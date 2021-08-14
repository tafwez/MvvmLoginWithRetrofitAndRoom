package com.hassantafwez.loginmvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hassantafwez.loginmvvm.Model.Datum;
import com.hassantafwez.loginmvvm.R;
import com.hassantafwez.loginmvvm.Repositery.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Repository repository;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        repository=new Repository(getApplication());


        repository.getAllCats().observe( this, new Observer<List<Datum>>() {
            @Override
            public void onChanged(List<Datum> data) {

                if (data != null && !data.isEmpty()){

                    if (data.get(0)!=null) {

                        Log.d(TAG, "userStatus: " + "user Existed");
                    }
                }else{

                    Log.d(TAG, "userStatus: " + "user is not Existed");
                    finish();
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                }




            }
        });
    }

    public void Logout(View view) {

        repository.deleteAll();
        finish();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));


    }
}