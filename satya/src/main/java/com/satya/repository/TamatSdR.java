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

@RegisterRowMapper(TamatSdO.Mapper.class)
public interface TamatSdR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_tmt_sd, tahun from tmt_sd ORDER BY id desc limit :max offset :start")
  List<TamatSdO> list(int start, int max);

 /**
   * Mengambil semua data tamat sd
 */
  @SqlQuery("SELECT jml_tmt_sd FROM tmt_sd")
  List<String> getAllTamatSd();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_tmt_sd FROM tmt_sd WHERE id_kec=:idKec AND tahun=:tahun")
  String getTamatSdByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM tmt_sd")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from tmt_sd where id=:id")
  TamatSdO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO tmt_sd(id_kec, jml_tmt_sd, tahun) VALUES(:idKec, :jmlTamatSd, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean TamatSdO TamatSdO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE tmt_sd SET id_kec=:idKec, jml_tmt_sd=:jmlTamatSd, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean TamatSdO TamatSdO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM tmt_sd WHERE id=:id")
  boolean delete(int id);

}