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

@RegisterRowMapper(MelekHurufO.Mapper.class)
public interface MelekHurufR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_amh, tahun from angka_melek_huruf ORDER BY id desc limit :max offset :start")
  List<MelekHurufO> list(int start, int max);



  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM angka_melek_huruf")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from angka_melek_huruf where id=:id")
  MelekHurufO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO angka_melek_huruf(id_kec, jml_amh, tahun) VALUES(:idKec, :jmlAmh, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean MelekHurufO MelekHurufO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE angka_melek_huruf SET id_kec=:idKec, jml_amh=:jmlAmh, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean MelekHurufO MelekHurufO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM angka_melek_huruf WHERE id=:id")
  boolean delete(int id);

}