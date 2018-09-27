package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatPtO {

  public static class Mapper implements RowMapper<TamatPtO> {
    @Override public TamatPtO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatPtO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_pt"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatPt;
  private String tahun;

  public TamatPtO(int id, int idKec, String jmlTamatPt, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatPt = jmlTamatPt;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlTamatPt() {
    return jmlTamatPt;
  }
  
  public String getTahun() {
    return tahun;
  }


}
