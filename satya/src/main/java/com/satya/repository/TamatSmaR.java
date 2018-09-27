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

@RegisterRowMapper(TamatSmaO.Mapper.class)
public interface TamatSmaR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_tmt_sma, tahun from tmt_sma ORDER BY id desc limit :max offset :start")
  List<TamatSmaO> list(int start, int max);

 /**
   * Mengambil semua data kemiskinan
 */
  @SqlQuery("SELECT jml_tmt_sma FROM tmt_sma")
  List<String> getAllTamatSma();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_tmt_sma FROM tmt_sma WHERE id_kec=:idKec AND tahun=:tahun")
  String getTamatSmaByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM tmt_sma")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from tmt_sma where id=:id")
  TamatSmaO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO tmt_sma(id_kec, jml_tmt_sma, tahun) VALUES(:idKec, :jmlTamatSma, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean TamatSmaO TamatSmaO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE tmt_sma SET id_kec=:idKec, jml_tmt_sma=:jmlTamatSma, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean TamatSmaO TamatSmaO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM tmt_sma WHERE id=:id")
  boolean delete(int id);

}