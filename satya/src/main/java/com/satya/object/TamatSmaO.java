package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatSmaO {

  public static class Mapper implements RowMapper<TamatSmaO> {
    @Override public TamatSmaO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatSmaO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_sma"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatSma;
  private String tahun;

  public TamatSmaO(int id, int idKec, String jmlTamatSma, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatSma = jmlTamatSma;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlTamatSma() {
    return jmlTamatSma;
  }
  
  public String getTahun() {
    return tahun;
  }


}
