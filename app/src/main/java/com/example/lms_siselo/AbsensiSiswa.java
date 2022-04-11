package com.example.lms_siselo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsensiSiswa extends AppCompatActivity {

    TextView t_matapelajaran,t_kelas,t_tgl_absen,t_nama,t_nisn,t_wali;
    Button btn_present;
    AbsensiResponse absenResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi_siswa);

        t_matapelajaran = (TextView) findViewById(R.id.dataA_matapelajaran);
        t_kelas = (TextView) findViewById(R.id.dataA_kelas);
        t_tgl_absen = (TextView) findViewById(R.id.dataA_tgl_presensi);

        t_nisn = (TextView) findViewById(R.id.dataA_nisn);
        t_nama = (TextView) findViewById(R.id.dataA_nama);
        t_wali = (TextView) findViewById(R.id.dataA_n_kelas);
        
        btn_present = (Button) findViewById(R.id.btn_presensi);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            absenResponse = (AbsensiResponse) intent.getSerializableExtra("data");

            SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);

            String idmatpeldata = absenResponse.getNama_matpel();
            String idkelasdata = absenResponse.getNama_kelas();
            String idtanggaldata = absenResponse.getTgl_absen();

            t_matapelajaran.setText(idmatpeldata);
            t_kelas.setText(idkelasdata);
            t_tgl_absen.setText(idtanggaldata);

            t_nisn.setText(sp.getString("nisn", ""));
            t_nama.setText(sp.getString("name", ""));
            t_wali.setText(sp.getString("nama_guru", ""));

        }
        btn_present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPostPresensi();
            }
        });
    }

    private void processPostPresensi() {
        Intent intent = getIntent();
        absenResponse = (AbsensiResponse) intent.getSerializableExtra("data");
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);

        String idabsendata = absenResponse.getId_absen();
        String nisndata = sp.getString("nisn", "");


        Call<AbsensiResponse> postKontakCall = ApiClient.getMapelService().postAbsensi(idabsendata, nisndata);
        postKontakCall.enqueue(new Callback<AbsensiResponse>() {
            @Override
            public void onResponse(Call<AbsensiResponse> call, Response<AbsensiResponse> response) {
                startActivity(new Intent(getApplicationContext(),AbsensiSiswa.class));
                finish();
            }

            @Override
            public void onFailure(Call<AbsensiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });

    }
}