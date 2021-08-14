package com.hassantafwez.loginmvvm.ApiClient;

import com.hassantafwez.loginmvvm.Model.LoginModelNew;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("teacher_login.php")
    Call<LoginModelNew> userLogin(@Field("emp_email")String email,
                                  @Field("emp_password")String passwrod,
                                  @Field("database_name")String Dbname);
}
