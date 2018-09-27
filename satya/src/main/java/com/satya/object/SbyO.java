package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SbyO {

  public static class Mapper implements RowMapper<SbyO> {
    @Override public SbyO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new SbyO(rs.getInt("gid"),rs.getString("name"), rs.getString("ST_AsText"));
    }
  }

  private int gid;
  private String name;
  private String geom;
  private double hasil;

  public SbyO(int gid, String name, String geom) {
    this.gid = gid;
    this.name = name;
    this.geom = geom;
    this.hasil = 0;
  }

  public int getGid() {
    return gid;
  }

  public String getName() {
    return name;
  }

  public String getGeom() {
    return geom;
  }

  public double getHasil() {
    return hasil;
  }

  public void setHasil(double hasil) {
    this.hasil = hasil;
  }
}
