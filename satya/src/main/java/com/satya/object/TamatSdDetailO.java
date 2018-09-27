package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatSdDetailO {

  public static class Mapper implements RowMapper<TamatSdDetailO> {
    @Override public TamatSdDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatSdDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_sd"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatSd;
  private String tahun;
  private String name;

  public TamatSdDetailO(int id, int idKec, String jmlTamatSd, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatSd = jmlTamatSd;
    this.tahun = tahun;
    this.name = name;
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

  public String getName() {
    return name;
  }

}
