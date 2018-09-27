package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TidakSekolahO {

  public static class Mapper implements RowMapper<TidakSekolahO> {
    @Override public TidakSekolahO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TidakSekolahO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_belum"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlBlmSekolah;
  private String tahun;

  public TidakSekolahO(int id, int idKec, String jmlBlmSekolah, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlBlmSekolah = jmlBlmSekolah;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlBlmSekolah() {
    return jmlBlmSekolah;
  }
  
  public String getTahun() {
    return tahun;
  }


}
