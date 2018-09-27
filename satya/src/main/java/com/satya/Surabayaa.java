package com.satya;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Surabayaa {

  public static class Mapper implements RowMapper<Surabayaa> {
    @Override public Surabayaa map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new Surabayaa(rs.getInt("id"), rs.getString("kelurahan"), rs.getString("kecamatan"), rs.getString("ST_AsText"));
    }
  }

  private int id;

  private String kelurahan;

  private String kecamatan;

  private String geom;

  public Surabayaa(int id, String kelurahan, String kecamatan, String geom) {
    this.id = id;
    this.kelurahan = kelurahan;
    this.kecamatan = kecamatan;
    this.geom = geom;
  }

  public int getId() {
    return id;
  }

  public String getKelurahan() {
    return kelurahan;
  }

  public String getKecamatan() {
    return kecamatan;
  }
  
  public String getGeom() {
    return geom;
  }


}
