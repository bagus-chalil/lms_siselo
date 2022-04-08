package com.example.lms_siselo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText t1,t2;
    Button btn_login;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        tv=(TextView)findViewById(R.id.tv);
        btn_login=findViewById(R.id.btnLogin);

        checkuserexistence();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processlogin();
            }
        });
    }

    void processlogin(){
        String email=t1.getText().toString();
        String password=t2.getText().toString();

        Call<LoginResponse> call=ApiClient
                .getInstance()
                .getapi()
                .verifyuser(email,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse obj=response.body();

                String output=obj.getMessage();
                String id=obj.getId();
                String role_id=obj.getRole_id();
                String nisn=obj.getNisn();
                String nama_guru=obj.getNama_guru();
                String kelas=obj.getKelas();
                String kelas_id=obj.getKelas_id();
                String name=obj.getName();
                String f_name=obj.getL_name();
                String l_name=obj.getL_name();
                if(output.equals("failed"))
                {
                    t1.setText("");
                    t2.setText("");
                    tv.setTextColor(Color.RED);
                    tv.setText("Invalid username or password");
                }
                if(output.equals("exist"))
                {
                    SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("email",t1.getText().toString());
                    editor.putString("password",t2.getText().toString());
                    editor.putString("id",id);
                    editor.putString("role_id",role_id);
                    editor.putString("nisn",nisn);
                    editor.putString("nama_guru",nama_guru);
                    editor.putString("kelas",kelas);
                    editor.putString("kelas_id",kelas_id);
                    editor.putString("name",name);
                    editor.putString("f_name",f_name);
                    editor.putString("f_name",l_name);
                    editor.commit();
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                tv.setText(t.toString());
                tv.setTextColor(Color.RED);
            }
        });

    }

    void checkuserexistence(){
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email")) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }else {
            tv.setText("Please login");
            tv.setTextColor(Color.RED);
        }
    }
}