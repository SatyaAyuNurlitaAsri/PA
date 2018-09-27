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

@RegisterRowMapper(TamatPtO.Mapper.class)
public interface TamatPtR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_tmt_pt, tahun from tmt_pt ORDER BY id desc limit :max offset :start")
  List<TamatPtO> list(int start, int max);

 /**
   * Mengambil semua data kemiskinan
 */
  @SqlQuery("SELECT jml_tmt_pt FROM tmt_pt")
  List<String> getAllTamatPt();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_tmt_pt FROM tmt_pt WHERE id_kec=:idKec AND tahun=:tahun")
  String getTamatPtByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM tmt_pt")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from tmt_pt where id=:id")
  TamatPtO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO tmt_pt(id_kec, jml_tmt_pt, tahun) VALUES(:idKec, :jmlTamatPt, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean TamatPtO TamatPtO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE tmt_pt SET id_kec=:idKec, jml_tmt_pt=:jmlTamatPt, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean TamatPtO TamatPtO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM tmt_pt WHERE id=:id")
  boolean delete(int id);

}