package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KemiskinanDetailO {

  public static class Mapper implements RowMapper<KemiskinanDetailO> {
    @Override public KemiskinanDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new KemiskinanDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_kemiskinan"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlKemiskinan;
  private String tahun;
  private String name;

  public KemiskinanDetailO(int id, int idKec, String jmlKemiskinan, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlKemiskinan = jmlKemiskinan;
    this.tahun = tahun;
    this.name = name;
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

  public String getName() {
    return name;
  }

}
