package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoWindowO {

  public static class Mapper implements RowMapper<InfoWindowO> {
    @Override public InfoWindowO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new InfoWindowO(rs.getString("jml_kasus"), rs.getString("jml_penduduk"), rs.getString("jml_kemiskinan"), rs.getString("jml_belum"), rs.getString("jml_blm_sd"), rs.getString("jml_tmt_sd"), rs.getString("jml_tmt_smp"), rs.getString("jml_tmt_sma"), rs.getString("jml_tmt_pt"));
    }
  }

  private String jmlKasus;
  private String jmlPenduduk;
  private String jmlKemiskinan;
  private String jmlTidakSekolah;
  private String jmlBlmTamatSd;
  private String jmlTamatSd;
  private String jmlTamatSmp;
  private String jmlTamatSma;
  private String jmlTamatPt;

  public InfoWindowO(String jmlKasus, String jmlPenduduk, String jmlKemiskinan, String jmlTidakSekolah, String jmlBlmTamatSd, String jmlTamatSd, String jmlTamatSmp, String jmlTamatSma, String jmlTamatPt) {
    this.jmlKasus = jmlKasus;
    this.jmlPenduduk = jmlPenduduk;
    this.jmlKemiskinan = jmlKemiskinan;
    this.jmlTidakSekolah = jmlTidakSekolah;
    this.jmlBlmTamatSd = jmlBlmTamatSd;
    this.jmlTamatSd = jmlTamatSd;
    this.jmlTamatSmp = jmlTamatSmp;
    this.jmlTamatSma = jmlTamatSma;
    this.jmlTamatPt = jmlTamatPt;
  }

  public String getJmlKasus() {
    return jmlKasus;
  }
  
  public String getJmlPenduduk() {
    return jmlPenduduk;
  }

  public String getJmlKemiskinan() {
    return jmlKemiskinan;
  }

  public String getJmlTidakSekolah() {
    return jmlTidakSekolah;
  }

  public String getJmlBlmTamatSd() {
    return jmlBlmTamatSd;
  }

  public String getJmlTamatSd() {
    return jmlTamatSd;
  }

  public String getJmlTamatSmp() {
    return jmlTamatSmp;
  }

  public String getJmlTamatSma() {
    return jmlTamatSma;
  }

  public String getJmlTamatPt() {
    return jmlTamatPt;
  }

}
