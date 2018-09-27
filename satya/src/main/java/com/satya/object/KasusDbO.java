package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KasusDbO {

  public static class Mapper implements RowMapper<KasusDbO> {
    @Override public KasusDbO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new KasusDbO(rs.getInt("id_kec"), rs.getString("jml_kasus"), rs.getString("tahun"), rs.getInt("id"));
    }
  }

  private int idKec;
  private String jmlKasus;
  private String tahun;
  private int id;

  public KasusDbO(int idKec, String jmlKasus, String tahun, int id) {
    this.idKec = idKec;
    this.jmlKasus = jmlKasus;
    this.tahun = tahun;
    this.id = id;

  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlKasus() {
    return jmlKasus;
  }
  
  public String getTahun() {
    return tahun;
  }

  public int getId() {
    return id;
  }


}
