package com.satya.object;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TampilDataO {

  public static class Mapper implements RowMapper<TampilDataO> {
    @Override public TampilDataO map(final ResultSet rs, final StatementContext ctx) throws SQLException {
      return new TampilDataO(rs.getString("nama_kec"), rs.getString("jumlahpenduduk"), rs.getString("jumlahkasus"));
    }
  }

  private String name;
  private String jml_penduduk;
  private String jml_kasus;


  public TampilDataO(String nama_kec, String jumlahpenduduk, String jumlahkasus) {
    this.name = nama_kec;
    this.jml_penduduk = jumlahpenduduk;
    this.jml_kasus = jumlahkasus;

  }

  public String getName() {
    return name;
  }

  public String getJmlPenduduk() {
    return jml_penduduk;
  }
  
  public String getJmlKasus() {
    return jml_kasus;
  }


}
