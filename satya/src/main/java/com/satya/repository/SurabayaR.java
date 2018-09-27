package com.satya.repository;

import com.satya.object.*;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(SurabayaO.Mapper.class)
public interface SurabayaR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT gid, id, nm_des, nm_kec, kabupaten, kecamatan, desa, id_kec, ST_Astext(geom) from sby_desa limit :max offset :start")
  List<SurabayaO> list(int start, int max);


  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from sby_desa where gid=:gid")
  SurabayaO findById(long gid);


   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO sby_desa (id, nm_des, nm_kec, kabupaten, kecamatan, desa, id_kec, geom) VALUES( :id, :nma_des, :nm_kec, :kabupaten, :kecamatan,:desa, :id_kec, ST_GeomFromText(:geom,4326))")
  @GetGeneratedKeys
  int insert(@BindBean SurabayaO SurabayaO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE sby_desa SET id=:id, nm_des=:nm_des, nm_kec=:nm_kec, kabupaten:kabupaten, kecamatan:kecamatan, desa:desa, id_kec:id_kec, geom=ST_GeomFromText(:geom,4326) WHERE gid=:gid")
  boolean update(@BindBean SurabayaO SurabayaO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM sby_desa WHERE gid=:gid")
  boolean delete(int gid);

}