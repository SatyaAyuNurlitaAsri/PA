package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatSmaDetailO {

  public static class Mapper implements RowMapper<TamatSmaDetailO> {
    @Override public TamatSmaDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatSmaDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_sma"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatSma;
  private String tahun;
  private String name;

  public TamatSmaDetailO(int id, int idKec, String jmlTamatSma, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatSma = jmlTamatSma;
    this.tahun = tahun;
    this.name = name;
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

  public String getName() {
    return name;
  }

}
