package com.example.lms_siselo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SiseloService {

    @GET("C_Kelas/")
    Call<List<KelasResponse>> getAllKelas();

    @FormUrlEncoded
    @POST("C_Login/")
    Call<LoginResponse> verifyuser(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("C_Kelas")
    Call<List<KelasResponse>> link(@Query("nisn")String nisn);

    @GET("C_Kelas/")
    Call<List<AbsensiResponse>> getAllMapelAbsen();

    @GET("C_Absensi")
    Call<List<AbsensiResponse>> link1(@Query("nisn")String nisn);

}
