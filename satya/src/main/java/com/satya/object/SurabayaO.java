package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurabayaO {

  public static class Mapper implements RowMapper<SurabayaO> {
    @Override public SurabayaO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new SurabayaO(rs.getInt("gid"), rs.getString("id"), rs.getString("nm_des"), rs.getString("nm_kec"), rs.getString("kabupaten"), rs.getString("kecamatan"), rs.getString("desa"), rs.getInt("id_kec"), rs.getString("ST_AsText"));
    }
  }

  private int gid;
  private String id;
  private String nm_des;
  private String nm_kec;
  private String kabupaten;
  private String kecamatan;
  private String desa;
  private int id_kec;
  private String geom;

  public SurabayaO(int gid, String id, String nm_des, String nm_kec, String kabupaten, String kecamatan, String desa, int id_kec, String geom) {
    this.gid = gid;
    this.id = id;
    this.nm_des = nm_des;
    this.nm_kec = nm_kec;
    this.kabupaten = kabupaten;
    this.kecamatan = kecamatan;
    this.desa = desa;
    this.id_kec = id_kec;
    this.geom = geom;
  }

  public int getGid() {
    return gid;
  }

  public String getId() {
    return id;
  }

  public String getNm_Des() {
    return nm_des;
  }
  
  public String getNm_Kec() {
    return nm_kec;
  }

  public String getKabupaten() {
    return kabupaten;
  }

  public String getKecamatan() {
    return kecamatan;
  }

  public String getDesa() {
    return desa;
  }

  public int getId_Kec() {
    return id_kec;
  }

  public String getGeom() {
    return geom;
  }


}
