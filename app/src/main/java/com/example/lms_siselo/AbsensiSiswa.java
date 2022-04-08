package com.example.lms_siselo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AbsensiSiswa extends AppCompatActivity {

    TextView username,nama;
    AbsensiResponse absenResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi_siswa);

        username  = findViewById(R.id.nama_absen);
        nama = findViewById(R.id.email);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            absenResponse = (AbsensiResponse) intent.getSerializableExtra("data");

            String usernamedata = absenResponse.getTgl_absen();
            String emaildata = absenResponse.getNama_matpel();

            username.setText(usernamedata);
            nama.setText(emaildata);

        }
    }
}