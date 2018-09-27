package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KasusDetailO{

  public static class Mapper implements RowMapper<KasusDetailO> {
    @Override public KasusDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new KasusDetailO(rs.getInt("id_kec"), rs.getString("jml_kasus"), rs.getString("tahun"), rs.getInt("id"), rs.getString("name"));
    }
  }

  private int idKec;
  private String jmlKasus;
  private String tahun;
  private int id;
  private String name;

  public KasusDetailO(int idKec, String jmlKasus, String tahun, int id, String name) {
    this.idKec = idKec;
    this.jmlKasus = jmlKasus;
    this.tahun = tahun;
    this.id = id;
    this.name = name;

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

  public String getName() {
    return name;
  }

}
