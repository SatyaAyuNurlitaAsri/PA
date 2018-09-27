package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlmTamatSdO {

  public static class Mapper implements RowMapper<BlmTamatSdO> {
    @Override public BlmTamatSdO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new BlmTamatSdO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_blm_sd"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlBlmTamatSd;
  private String tahun;

  public BlmTamatSdO(int id, int idKec, String jmlBlmTamatSd, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlBlmTamatSd = jmlBlmTamatSd;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlBlmTamatSd() {
    return jmlBlmTamatSd;
  }
  
  public String getTahun() {
    return tahun;
  }


}
