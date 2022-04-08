package com.example.lms_siselo;

import java.io.Serializable;

public class KelasResponse implements Serializable {

    private String id_matpel;
    private String nama_matpel;
    private String kode_matpel;
    private String kelas_id;

    public String getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(String id_matpel) {
        this.id_matpel = id_matpel;
    }

    public String getNama_matpel() {
        return nama_matpel;
    }

    public void setNama_matpel(String nama_matpel) {
        this.nama_matpel = nama_matpel;
    }

    public String getKode_matpel() {
        return kode_matpel;
    }

    public void setKode_matpel(String kode_matpel) {
        this.kode_matpel = kode_matpel;
    }

    public String getKelas_id() {
        return kelas_id;
    }

    public void setKelas_id(String kelas_id) {
        this.kelas_id = kelas_id;
    }

    @Override
    public String toString() {
        return "KelasResponse{" +
                "id_matpel='" + id_matpel + '\'' +
                ", nama_matpel='" + nama_matpel + '\'' +
                ", kode_matpel='" + kode_matpel + '\'' +
                ", kelas_id='" + kelas_id + '\'' +
                '}';
    }
}