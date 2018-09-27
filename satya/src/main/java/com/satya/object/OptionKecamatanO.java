package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionKecamatanO {

  public static class Mapper implements RowMapper<OptionKecamatanO> {
    @Override public OptionKecamatanO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new OptionKecamatanO(rs.getInt("gid"),rs.getString("text"));
    }
  }

  private int gid;
  private String name;

  public OptionKecamatanO(int gid, String text) {
    this.gid = gid;
    this.name = text;
  }

  public int getId() {
    return gid;
  }

  public String getText() {
    return name;
  }
}
