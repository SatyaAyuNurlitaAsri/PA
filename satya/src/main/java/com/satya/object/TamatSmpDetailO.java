package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatSmpDetailO {

  public static class Mapper implements RowMapper<TamatSmpDetailO> {
    @Override public TamatSmpDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatSmpDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_smp"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatSmp;
  private String tahun;
  private String name;

  public TamatSmpDetailO(int id, int idKec, String jmlTamatSmp, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatSmp = jmlTamatSmp;
    this.tahun = tahun;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlTamatSmp() {
    return jmlTamatSmp;
  }
  
  public String getTahun() {
    return tahun;
  }

  public String getName() {
    return name;
  }

}
