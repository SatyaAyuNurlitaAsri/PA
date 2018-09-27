package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PendudukDetailO {

  public static class Mapper implements RowMapper<PendudukDetailO> {
    @Override public PendudukDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new PendudukDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_penduduk"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlPenduduk;
  private String tahun;
  private String name;

  public PendudukDetailO(int id, int idKec, String jmlPenduduk, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlPenduduk = jmlPenduduk;
    this.tahun = tahun;
    this.name = name;
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

  public String getName() {
    return name;
  }

}
