package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatSdO {

  public static class Mapper implements RowMapper<TamatSdO> {
    @Override public TamatSdO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatSdO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_sd"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatSd;
  private String tahun;

  public TamatSdO(int id, int idKec, String jmlTamatSd, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatSd = jmlTamatSd;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlTamatSd() {
    return jmlTamatSd;
  }
  
  public String getTahun() {
    return tahun;
  }


}
