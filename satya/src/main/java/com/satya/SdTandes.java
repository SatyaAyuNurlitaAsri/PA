package com.satya;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SdTandes {

  public static class Mapper implements RowMapper<SdTandes> {
    @Override public SdTandes map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new SdTandes(rs.getInt("gid"), rs.getString("name"), rs.getString("latitude"), rs.getString("longitude"), rs.getString("ST_AsText"));
    }
  }

  private int gid;

  private String name;

  private String latitude;

  private String longitude;

  private String theGeom;

  public SdTandes(int gid, String name, String latitude, String longitude, String theGeom) {
    this.gid = gid;
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
    this.theGeom = theGeom;
  }

  public int getGid() {
    return gid;
  }

  public String getName() {
    return name;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public String getTheGeom() {
    return theGeom;
  }


}
