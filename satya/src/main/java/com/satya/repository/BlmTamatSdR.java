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

@RegisterRowMapper(BlmTamatSdO.Mapper.class)
public interface BlmTamatSdR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_blm_sd, tahun from blm_tmt_sd ORDER BY id desc limit :max offset :start")
  List<BlmTamatSdO> list(int start, int max);

 /**
   * Mengambil semua data kemiskinan
 */
  @SqlQuery("SELECT jml_blm_sd FROM blm_tmt_sd")
  List<String> getAllBlmTamatSd();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_blm_sd FROM blm_tmt_sd WHERE id_kec=:idKec AND tahun=:tahun")
  String getBlmTamatSdByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM blm_tmt_sd")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from blm_tmt_sd where id=:id")
  BlmTamatSdO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO blm_tmt_sd(id_kec, jml_blm_sd, tahun) VALUES(:idKec, :jmlBlmTamatSd, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean BlmTamatSdO BlmTamatSdO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE blm_tmt_sd SET id_kec=:idKec, jml_blm_sd=:jmlBlmTamatSd, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean BlmTamatSdO BlmTamatSdO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM blm_tmt_sd WHERE id=:id")
  boolean delete(int id);

}