package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HasilO {

  public static class Mapper implements RowMapper<HasilO> {
    @Override public HasilO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new HasilO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("hasil"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String hasil;
  private String tahun;

  public HasilO(int id, int idKec, String hasil, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.hasil = hasil;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getHasil() {
    return hasil;
  }
  
  public String getTahun() {
    return tahun;
  }


}
