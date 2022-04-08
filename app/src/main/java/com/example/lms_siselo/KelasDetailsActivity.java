package com.example.lms_siselo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class KelasDetailsActivity extends AppCompatActivity {

    TextView username,email,joined;
    KelasResponse userResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas_detail);

        username  = findViewById(R.id.nama_kelas);
        email = findViewById(R.id.email);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            userResponse = (KelasResponse) intent.getSerializableExtra("data");

            String usernamedata = userResponse.getNama_matpel();
            String emaildata = userResponse.getId_matpel();

            username.setText(usernamedata);
            email.setText(emaildata);


        }


    }
}