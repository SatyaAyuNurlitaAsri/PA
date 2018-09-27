package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TidakSekolahDetailO {

  public static class Mapper implements RowMapper<TidakSekolahDetailO> {
    @Override public TidakSekolahDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TidakSekolahDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_belum"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlBlmSekolah;
  private String tahun;
  private String nama;

  public TidakSekolahDetailO(int id, int idKec, String jmlBlmSekolah, String tahun, String nama) {
    this.id = id;
    this.idKec = idKec;
    this.jmlBlmSekolah = jmlBlmSekolah;
    this.tahun = tahun;
    this.nama = nama;
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

  public String getNama() {
    return nama;
  }

}
