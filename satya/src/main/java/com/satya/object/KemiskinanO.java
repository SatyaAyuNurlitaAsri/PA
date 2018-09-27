package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KemiskinanO {

  public static class Mapper implements RowMapper<KemiskinanO> {
    @Override public KemiskinanO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new KemiskinanO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_kemiskinan"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlKemiskinan;
  private String tahun;

  public KemiskinanO(int id, int idKec, String jmlKemiskinan, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlKemiskinan = jmlKemiskinan;
    this.tahun = tahun;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlKemiskinan() {
    return jmlKemiskinan;
  }
  
  public String getTahun() {
    return tahun;
  }


}
