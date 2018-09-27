package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MelekHurufO {

  public static class Mapper implements RowMapper<MelekHurufO> {
    @Override public MelekHurufO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new MelekHurufO(rs.getInt("id"), rs.getInt("id_kec"), rs.getString("jml_amh"), rs.getString("tahun"));
    }
  }

  private int id;
  private int idKec;
  private String jmlAmh;
  private String tahun;

  public MelekHurufO(int id, int idKec, String jmlAmh, String tahun) {
    this.id = id;
    this.idKec = idKec;
    this.jmlAmh = jmlAmh;
    this.tahun = tahun;

  }

  
  public int getId() {
    return id;
  }

  public int getIdKec() {
    return idKec;
  }

  public String getJmlAmh() {
    return jmlAmh;
  }
  
  public String getTahun() {
    return tahun;
  }


}
