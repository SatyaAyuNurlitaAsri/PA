package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlmTamatSdDetailO {

  public static class Mapper implements RowMapper<BlmTamatSdDetailO> {
    @Override public BlmTamatSdDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new BlmTamatSdDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_blm_sd"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlBlmTamatSd;
  private String tahun;
  private String name;

  public BlmTamatSdDetailO(int id, int idKec, String jmlBlmTamatSd, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlBlmTamatSd = jmlBlmTamatSd;
    this.tahun = tahun;
    this.name = name;
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

  public String getName() {
    return name;
  }

}
