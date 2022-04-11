package com.example.lms_siselo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String url="http://siselo.allif.my.id/";
    private static ApiClient clienobject;
    private static Retrofit retrofit;

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    ApiClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static SiseloService getKelasService(){
        SiseloService kelasService = getRetrofit().create(SiseloService.class);
        return kelasService;
    }
    public static SiseloService getMapelService(){
        SiseloService mapelService = getRetrofit().create(SiseloService.class);
        return mapelService;
    }
    public static SiseloService getAbsenService(){
        SiseloService absenService = getRetrofit().create(SiseloService.class);
        return absenService;
    }
    public static SiseloService postAbsenService(){
        SiseloService absenPostService = getRetrofit().create(SiseloService.class);
        return absenPostService;
    }

    public static synchronized ApiClient getInstance()
    {
        if(clienobject==null)
            clienobject=new ApiClient();
        return  clienobject;
    }

    SiseloService getapi()
    {
        return retrofit.create(SiseloService.class);
    }
}