package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KepadatanPendudukO {

  public static class Mapper implements RowMapper<KepadatanPendudukO> {
    @Override public KepadatanPendudukO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new KepadatanPendudukO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_penduduk"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlPenduduk;
  private String tahun;

  public KepadatanPendudukO(int id, int idKec, String jmlPenduduk, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlPenduduk = jmlPenduduk;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlPenduduk() {
    return jmlPenduduk;
  }
  
  public String getTahun() {
    return tahun;
  }


}
