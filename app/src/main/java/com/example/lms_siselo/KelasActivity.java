package com.example.lms_siselo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelasActivity extends AppCompatActivity implements KelasAdapter.ClickedItem{

    Toolbar toolbar;
    RecyclerView recyclerView;

    KelasAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        usersAdapter = new KelasAdapter(this::ClickedUser);

        getAllUsers();

    }

    public void getAllUsers(){

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);

        if(sp.contains("email")) {
            String nisn=sp.getString("nisn","");

            SiseloService serviceAPI=ApiClient.getMapelService();
            serviceAPI.link(nisn).enqueue(new Callback<List<KelasResponse>>() {
                @Override
                public void onResponse(Call<List<KelasResponse>> call, Response<List<KelasResponse>> response) {
                    if(response.isSuccessful()){
                        List<KelasResponse> userResponses = response.body();
                        usersAdapter.setData(userResponses);
                        recyclerView.setAdapter(usersAdapter);

                    }
                }

                @Override
                public void onFailure(Call<List<KelasResponse>> call, Throwable t) {

                }
            });
        }else {
            Call<List<KelasResponse>> userlist = ApiClient.getKelasService().getAllKelas();

            userlist.enqueue(new Callback<List<KelasResponse>>() {
                @Override
                public void onResponse(Call<List<KelasResponse>> call, Response<List<KelasResponse>> response) {

                    if(response.isSuccessful()){
                        List<KelasResponse> userResponses = response.body();
                        usersAdapter.setData(userResponses);
                        recyclerView.setAdapter(usersAdapter);

                    }

                }

                @Override
                public void onFailure(Call<List<KelasResponse>> call, Throwable t) {
                    Log.e("failure",t.getLocalizedMessage());

                }
            });
        }

    }

    @Override
    public void ClickedUser(KelasResponse userResponse) {

        startActivity(new Intent(this,KelasDetailsActivity.class).putExtra("data",userResponse));
    }
}