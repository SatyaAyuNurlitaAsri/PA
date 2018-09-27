package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataKecamatanO {

  public static class Mapper implements RowMapper<DataKecamatanO> {
    @Override public DataKecamatanO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new DataKecamatanO(rs.getInt("gid"),rs.getString("name"));
    }
  }

  private int gid;
  private String name;

  public DataKecamatanO(int gid, String name) {
    this.gid = gid;
    this.name = name;
  }

  public int getGid() {
    return gid;
  }

  public String getName() {
    return name;
  }

}
