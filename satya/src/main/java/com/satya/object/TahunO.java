package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TahunO {

  public static class Mapper implements RowMapper<TahunO> {
    @Override public TahunO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TahunO(rs.getInt("id"),rs.getString("tahun"));
    }
  }

  private int id;
  private String tahun;

  public TahunO(int id, String tahun) {
    this.id = id;
    this.tahun = tahun;

  }


  public int getId() {
    return id;
  }

  public String getTahun() {
    return tahun;
  }


}
