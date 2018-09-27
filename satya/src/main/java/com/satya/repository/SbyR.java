package com.satya.repository;

import com.satya.object.SbyO;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(SbyO.Mapper.class)
public interface SbyR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT gid, name, ST_Astext(geom) from sby limit :max offset :start")
  List<SbyO> list(int start, int max);

 /**
   * Mengambil semua data surabaya
 */
  @SqlQuery("SELECT gid FROM sby")
  List<String> getAllSby();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from sby where gid=:gid")
  SbyO findById(long gid);


   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO sby (gid, name, geom) VALUES( :gid, name, ST_GeomFromText(:geom,4326))")
  @GetGeneratedKeys
  int insert(@BindBean SbyO SbyO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE sby SET gid=:gid, name=:name, geom=:ST_GeomFromText(:geom,4326) WHERE gid=:gid")
  boolean update(@BindBean SbyO SbyO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM sby WHERE gid=:gid")
  boolean delete(int gid);

}