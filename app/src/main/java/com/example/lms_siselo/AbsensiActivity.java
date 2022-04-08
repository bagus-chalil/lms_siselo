package com.example.lms_siselo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsensiActivity extends AppCompatActivity implements AbsensiAdapter.ClickedItem{

    Toolbar toolbar;
    RecyclerView recyclerView1;

    AbsensiAdapter absenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        toolbar = findViewById(R.id.toolbar);
        recyclerView1 = findViewById(R.id.recyclerviewA);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        absenAdapter = new AbsensiAdapter(this::ClickedAbsen);

        getAllAbsensi();

    }

    public void getAllAbsensi(){

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);

        if(sp.contains("email")) {
            String nisn=sp.getString("nisn","");

            SiseloService serviceAPI=ApiClient.getMapelService();
            serviceAPI.link1(nisn).enqueue(new Callback<List<AbsensiResponse>>() {
                @Override
                public void onResponse(Call<List<AbsensiResponse>> call, Response<List<AbsensiResponse>> response) {
                    if(response.isSuccessful()){
                        List<AbsensiResponse> absenResponses = response.body();
                        absenAdapter.setData(absenResponses);
                        recyclerView1.setAdapter(absenAdapter);

                    }
                }

                @Override
                public void onFailure(Call<List<AbsensiResponse>> call, Throwable t) {

                }
            });
        }else {
            Call<List<AbsensiResponse>> userlist = ApiClient.getAbsenService().getAllMapelAbsen();

            userlist.enqueue(new Callback<List<AbsensiResponse>>() {
                @Override
                public void onResponse(Call<List<AbsensiResponse>> call, Response<List<AbsensiResponse>> response) {

                    if(response.isSuccessful()){
                        List<AbsensiResponse> absenResponses = response.body();
                        absenAdapter.setData(absenResponses);
                        recyclerView1.setAdapter(absenAdapter);

                    }

                }

                @Override
                public void onFailure(Call<List<AbsensiResponse>> call, Throwable t) {
                    Log.e("failure",t.getLocalizedMessage());

                }
            });
        }

    }

    @Override
    public void ClickedAbsen(AbsensiResponse absenResponse) {

        startActivity(new Intent(this,AbsensiSiswa.class).putExtra("data",absenResponse));
    }

}