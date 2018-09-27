package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllVarO {

  // public static class Mapper implements RowMapper<AllVarO> {
  //   @Override public AllVarO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
  //     return new AllVarO(rs.getdouble("jml_kasus"), rs.getdouble("jml_penduduk"), rs.getdouble("jml_kemiskinan"), rs.getdouble("jml_belum"), rs.getdouble("jml_blm_sd"), rs.getdouble("jml_tmt_sd"), rs.getdouble("jml_tmt_smp"), rs.getdouble("jml_tmt_sma"), rs.getdouble("jml_tmt_pt"));
  //   }
  // }

  private int idKecamatan;
  private String tahun;
  private double kasusDb;
  private double kepadatanPenduduk;
  private double kemiskinan;
  private double tidakSekolah;
  private double blmTamatSd;
  private double tamatSd;
  private double tamatSmp;
  private double tamatSma;
  private double tamatPt;

  public AllVarO(int idKecamatan, String tahun, double kasusDb, double kepadatanPenduduk, double kemiskinan, double tidakSekolah, double blmTamatSd, double tamatSd, double tamatSmp, double tamatSma, double tamatPt) {
    this.idKecamatan = idKecamatan;
    this.tahun = tahun;
    this.kasusDb = kasusDb;
    this.kepadatanPenduduk = kepadatanPenduduk;
    this.kemiskinan = kemiskinan;
    this.tidakSekolah = tidakSekolah;
    this.blmTamatSd = blmTamatSd;
    this.tamatSd = tamatSd;
    this.tamatSmp = tamatSmp;
    this.tamatSma = tamatSma;
    this.tamatPt = tamatPt;
  }

  public int getIdKecamatan() {
    return idKecamatan;
  }

  public String getTahun() {
    return tahun;
  }

  public double getKasusDb() {
    return kasusDb;
  }

  public double getKepadatanPenduduk() {
    return kepadatanPenduduk;
  }

  public double getKemiskinan() {
    return kemiskinan;
  }
  
  public double getTidakSekolah() {
    return tidakSekolah;
  }

  public double getBlmTamatSd() {
    return blmTamatSd;
  }

  public double getTamatSd() {
    return tamatSd;
  }

  public double getTamatSmp() {
    return tamatSmp;
  }

  public double getTamatSma() {
    return tamatSma;
  }

  public double getTamatPt() {
    return tamatPt;
  }
}
