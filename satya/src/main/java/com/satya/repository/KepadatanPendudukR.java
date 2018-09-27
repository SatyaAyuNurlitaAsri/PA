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

@RegisterRowMapper(KepadatanPendudukO.Mapper.class)
public interface KepadatanPendudukR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_penduduk, tahun from kepadatan_penduduk ORDER BY id desc limit :max offset :start")
  List<KepadatanPendudukO> list(int start, int max);

  /**
   * Mengambil semua data kepadatan penduduk
 */
  @SqlQuery("SELECT jml_penduduk FROM kepadatan_penduduk")
  List<String> getAllKepadatanPenduduk();

  /**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_penduduk FROM kepadatan_penduduk WHERE id_kec=:idKec AND tahun=:tahun")
  String getKepadatanPendudukByIdKec(int idKec, String tahun);
  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM kepadatan_penduduk")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from kepadatan_penduduk where id=:id")
  KepadatanPendudukO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO kepadatan_penduduk(id_kec, jml_penduduk, tahun) VALUES(:idKec, :jmlPenduduk, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean KepadatanPendudukO KepadatanPendudukO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE kepadatan_penduduk SET id_kec=:idKec, jml_penduduk=:jmlPenduduk, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean KepadatanPendudukO KepadatanPendudukO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM kepadatan_penduduk WHERE id=:id")
  boolean delete(int id);

}