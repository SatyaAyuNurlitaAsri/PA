package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamatPtDetailO {

  public static class Mapper implements RowMapper<TamatPtDetailO> {
    @Override public TamatPtDetailO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TamatPtDetailO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_tmt_pt"), rs.getString("tahun"), rs.getString("name"));
    }
  }

  private int id;
  private int idKec;
  private String jmlTamatPt;
  private String tahun;
  private String name;

  public TamatPtDetailO(int id, int idKec, String jmlTamatPt, String tahun, String name) {
    this.id = id;
    this.idKec = idKec;
    this.jmlTamatPt = jmlTamatPt;
    this.tahun = tahun;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlTamatPt() {
    return jmlTamatPt;
  }
  
  public String getTahun() {
    return tahun;
  }

  public String getName() {
    return name;
  }

}
