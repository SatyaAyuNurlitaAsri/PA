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

@RegisterRowMapper(KemiskinanO.Mapper.class)
public interface KemiskinanR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_kemiskinan, tahun FROM angka_kemiskinan ORDER BY id desc limit :max offset :start")
  List<KemiskinanO> list(int start, int max);


  /**
   * Mengambil semua data kemiskinan
 */
  @SqlQuery("SELECT jml_kemiskinan FROM angka_kemiskinan")
  List<String> getAllKemiskinan();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_kemiskinan FROM angka_kemiskinan WHERE id_kec=:idKec AND tahun=:tahun")
  String getKemiskinanByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM angka_kemiskinan")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from angka_kemiskinan where id=:id")
  KemiskinanO findById(long id);


   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO angka_kemiskinan (id_kec, jml_kemiskinan, tahun) VALUES( :idKec, :jmlKemiskinan, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean KemiskinanO KemiskinanO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE angka_kemiskinan SET id_kec=:idKec, jml_kemiskinan=:jmlKemiskinan, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean KemiskinanO KemiskinanO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM angka_kemiskinan WHERE id=:id")
  boolean delete(int id);

}