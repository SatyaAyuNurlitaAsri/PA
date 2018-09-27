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

@RegisterRowMapper(TidakSekolahO.Mapper.class)
public interface TidakSekolahR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_belum, tahun from blm_sekolah ORDER BY id desc limit :max offset :start")
  List<TidakSekolahO> list(int start, int max);
  

/**
   * Mengambil semua data belum/tidak sekolah
 */
  @SqlQuery("SELECT jml_belum FROM blm_sekolah")
  List<String> getAllTidakSekolah();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_belum FROM blm_sekolah WHERE id_kec=:idKec AND tahun=:tahun")
  String getTidakSekolahByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM blm_sekolah")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from blm_sekolah where id=:id")
  TidakSekolahO findById(long id);

   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO blm_sekolah(id_kec, jml_belum, tahun) VALUES(:idKec, :jmlBlmSekolah, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean TidakSekolahO TidakSekolahO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE blm_sekolah SET id_kec=:idKec, jml_belum=:jmlBlmSekolah, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean TidakSekolahO TidakSekolahO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM blm_sekolah WHERE id=:id")
  boolean delete(int id);

}