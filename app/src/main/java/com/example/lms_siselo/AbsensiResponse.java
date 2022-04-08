package com.example.lms_siselo;

import java.io.Serializable;
import java.util.Date;

public class AbsensiResponse implements Serializable {
    String id_absen;
    String tgl_absen;
    String absensi_active;
    String id_matpel;
    String nama_matpel;
    String kode_matpel;
    String ada;

    public AbsensiResponse(String id_absen, String tgl_absen, String absensi_active, String id_matpel, String nama_matpel, String kode_matpel, String ada) {
        this.id_absen = id_absen;
        this.tgl_absen = tgl_absen;
        this.absensi_active = absensi_active;
        this.id_matpel = id_matpel;
        this.nama_matpel = nama_matpel;
        this.kode_matpel = kode_matpel;
        this.ada = ada;
    }

    public String getId_absen() {
        return id_absen;
    }

    public void setId_absen(String id_absen) {
        this.id_absen = id_absen;
    }

    public String getTgl_absen() {
        return tgl_absen;
    }

    public void setTgl_absen(String tgl_absen) {
        this.tgl_absen = tgl_absen;
    }

    public String getAbsensi_active() {
        return absensi_active;
    }

    public void setAbsensi_active(String absensi_active) {
        this.absensi_active = absensi_active;
    }

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

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    @Override
    public String toString() {
        return "AbsensiResponse{" +
                "id_absen='" + id_absen + '\'' +
                ", tgl_absen='" + tgl_absen + '\'' +
                ", absensi_active='" + absensi_active + '\'' +
                ", id_matpel='" + id_matpel + '\'' +
                ", nama_matpel='" + nama_matpel + '\'' +
                ", kode_matpel='" + kode_matpel + '\'' +
                ", ada='" + ada + '\'' +
                '}';
    }
}
