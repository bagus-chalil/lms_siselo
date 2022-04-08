package com.example.lms_siselo;


public class LoginResponse {
    String message;
    String id;
    String role_id;
    String nisn;
    String nama_guru;
    String kelas;
    String kelas_id;
    String name;
    String f_name;
    String l_name;

    public LoginResponse(String message, String id, String role_id, String nisn, String nama_guru, String kelas_id, String kelas, String name, String f_name, String l_name) {
        this.message = message;
        this.id = id;
        this.role_id = role_id;
        this.nisn = nisn;
        this.nama_guru = nama_guru;
        this.kelas = kelas;
        this.kelas_id = kelas_id;
        this.name = name;
        this.f_name = f_name;
        this.l_name = l_name;
    }

    public LoginResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelas_id() {
        return kelas_id;
    }

    public void setKelas_id(String kelas_id) {
        this.kelas_id = kelas_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
}
