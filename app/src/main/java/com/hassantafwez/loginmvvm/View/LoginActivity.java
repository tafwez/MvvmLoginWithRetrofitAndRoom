package com.hassantafwez.loginmvvm.View;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hassantafwez.loginmvvm.ApiClient.ApiClient;
import com.hassantafwez.loginmvvm.Model.Datum;
import com.hassantafwez.loginmvvm.Model.LoginModelNew;
import com.hassantafwez.loginmvvm.Model.LoginUser;
import com.hassantafwez.loginmvvm.Repositery.Repository;
import com.hassantafwez.loginmvvm.vmodel.LoginViewModel;
import com.hassantafwez.loginmvvm.R;
import com.hassantafwez.loginmvvm.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Tag";
    private LoginViewModel loginViewModel;

    private ActivityMainBinding binding;
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository=new Repository(getApplication());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(@Nullable LoginUser loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if (!loginUser.isEmailValid()) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password");
                    binding.txtPassword.requestFocus();
                }
                else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.txtPassword.setError("Enter at least 6 Digit password");
                    binding.txtPassword.requestFocus();
                }
                else {
                    binding.lblEmailAnswer.setText(loginUser.getStrEmailAddress());
                    binding.lblPasswordAnswer.setText(loginUser.getStrPassword());
                    login(loginUser.getStrEmailAddress(),loginUser.getStrPassword());

                }

            }
        });



        repository.getAllCats().observe( this, new Observer<List<Datum>>() {
            @Override
            public void onChanged(List<Datum> data) {

                if (data != null && !data.isEmpty()){

                    if (data.get(0)!=null) {

                        Log.d(TAG, "userStatus: " + "user Existed");
                    }
                }else{

                    Log.d(TAG, "userStatus: " + "user is not Existed");
                }




            }
        });




    }

    public void login(String email,String password){
        Call<LoginModelNew> loginResponseCall = ApiClient.getUserService().userLogin(email,password,"simpthqt_demo");
        loginResponseCall.enqueue(new Callback<LoginModelNew>() {
            @Override
            public void onResponse(Call<LoginModelNew> call, Response<LoginModelNew> response) {

                if(response.isSuccessful()){

                    Log.d(TAG, "onResponse: "+response.body());

                    if (response.body().getStatus()==1){

                        List<Datum> data=response.body().getData();
                        Log.d(TAG, "onResponse: "+String.valueOf(data.size()));
                        Log.d(TAG, "onResponse: "+data.get(0).getEmpEmail());
                        Log.d(TAG, "onResponse: "+response.body().getData());

                        repository.insert(response.body().getData());
                        finish();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));

                    }
                    else{

                        Toast.makeText(getApplication(),"password is wrong",Toast.LENGTH_SHORT).show();
                    }









                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginModelNew> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

}