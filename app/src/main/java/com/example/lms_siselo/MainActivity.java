package com.example.lms_siselo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    TextView main_nisn,nama_siswa;
    Button btn_logout;
    ImageView btn_absen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_nisn=(TextView)findViewById(R.id.m_nisn);
        nama_siswa=(TextView)findViewById(R.id.nama_siswa);
        btn_logout=(Button)findViewById(R.id.btn_Logout);

        btn_absen=(ImageView)findViewById(R.id.btn_absen);

        BottomNavigationView bottom = findViewById(R.id.navigasi_bawah);

        //Function Cek Session
        checkuserexistence();

        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_kelas:
                        Intent kelas = new Intent(MainActivity.this, KelasActivity.class);
                        startActivity(kelas);
                        break;
                    case R.id.menu_home :
                        Intent home = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(home);
                        finish();
                        break;
                    case R.id.menu_profil :

                        break;
                }
                return true;
            }
        });

        btn_absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AbsensiActivity.class));
                finish();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                sp.edit().remove("email").commit();
                sp.edit().remove("password").commit();
                sp.edit().remove("nisn").commit();
                sp.edit().remove("name").commit();
                sp.edit().apply();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        });
    }
    public void checkuserexistence()
    {
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email")) {
            main_nisn.setText(sp.getString("nisn", ""));
            nama_siswa.setText(sp.getString("name", ""));
        }else {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }
}