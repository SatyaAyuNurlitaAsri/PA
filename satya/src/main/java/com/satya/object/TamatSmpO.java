package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatSmpO {

  public static class Mapper implements RowMapper<TamatSmpO> {
    @Override public TamatSmpO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatSmpO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_smp"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatSmp;
  private String tahun;

  public TamatSmpO(int id, int idKec, String jmlTamatSmp, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatSmp = jmlTamatSmp;
    this.tahun = tahun;
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


}
