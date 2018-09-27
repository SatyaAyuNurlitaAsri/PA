package com.satya.repository;

import com.satya.object.DataKecamatanO;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(DataKecamatanO.Mapper.class)
public interface DataKecamatanR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT gid, name from sby limit :max offset :start")
  List<DataKecamatanO> list(int start, int max);


  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from sby where gid=:gid")
  DataKecamatanO findById(long gid);


   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO sby (gid, name) VALUES( :gid, name)")
  @GetGeneratedKeys
  int insert(@BindBean DataKecamatanO DataKecamatanO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE sby SET gid=:gid, name=:name WHERE gid=:gid")
  boolean update(@BindBean DataKecamatanO DataKecamatanO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM sby WHERE gid=:gid")
  boolean delete(int gid);

}