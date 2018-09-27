package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PendapatanO {

  public static class Mapper implements RowMapper<PendapatanO> {
    @Override public PendapatanO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new PendapatanO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_pendapatan"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlPendapatan;
  private String tahun;

  public PendapatanO(int id, int idKec, String jmlPendapatan, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlPendapatan = jmlPendapatan;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlPendapatan() {
    return jmlPendapatan;
  }
  
  public String getTahun() {
    return tahun;
  }


}
