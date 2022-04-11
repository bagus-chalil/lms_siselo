package com.example.lms_siselo;

import java.io.Serializable;
import java.util.Date;

public class AbsensiResponse implements Serializable {
    String id_absen;
    String tgl_absen;
    String m_mapel_id;
    String absensi_active;
    String id_matpel;
    String nama_matpel;
    String kode_matpel;
    String id_kelas;
    String nama_kelas;
    String ada;
    String nisn;

    public AbsensiResponse(String id_absen, String tgl_absen, String m_mapel_id, String absensi_active, String id_matpel, String nama_matpel, String kode_matpel, String id_kelas, String nama_kelas, String ada, String nisn) {
        this.id_absen = id_absen;
        this.tgl_absen = tgl_absen;
        this.m_mapel_id = m_mapel_id;
        this.absensi_active = absensi_active;
        this.id_matpel = id_matpel;
        this.nama_matpel = nama_matpel;
        this.kode_matpel = kode_matpel;
        this.id_kelas = id_kelas;
        this.nama_kelas = nama_kelas;
        this.ada = ada;
        this.nisn = nisn;
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

    public String getM_mapel_id() {
        return m_mapel_id;
    }

    public void setM_mapel_id(String m_mapel_id) {
        this.m_mapel_id = m_mapel_id;
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

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    @Override
    public String toString() {
        return "AbsensiResponse{" +
                "id_absen='" + id_absen + '\'' +
                ", tgl_absen='" + tgl_absen + '\'' +
                ", m_mapel_id='" + m_mapel_id + '\'' +
                ", absensi_active='" + absensi_active + '\'' +
                ", id_matpel='" + id_matpel + '\'' +
                ", nama_matpel='" + nama_matpel + '\'' +
                ", kode_matpel='" + kode_matpel + '\'' +
                ", id_kelas='" + id_kelas + '\'' +
                ", nama_kelas='" + nama_kelas + '\'' +
                ", ada='" + ada + '\'' +
                ", nisn='" + nisn + '\'' +
                '}';
    }
}
