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

@RegisterRowMapper(TamatSmpO.Mapper.class)
public interface TamatSmpR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_tmt_smp, tahun from tmt_smp ORDER BY id desc limit :max offset :start")
  List<TamatSmpO> list(int start, int max);

 /**
   * Mengambil semua data kemiskinan
 */
  @SqlQuery("SELECT jml_tmt_smp FROM tmt_smp")
  List<String> getAllTamatSmp();

/**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_tmt_smp FROM tmt_smp WHERE id_kec=:idKec AND tahun=:tahun")
  String getTamatSmpByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM tmt_smp")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from tmt_smp where id=:id")
  TamatSmpO findById(long id);




   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO tmt_smp(id_kec, jml_tmt_smp, tahun) VALUES(:idKec, :jmlTamatSmp, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean TamatSmpO TamatSmpO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE tmt_smp SET id_kec=:idKec, jml_tmt_smp=:jmlTamatSmp, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean TamatSmpO TamatSmpO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM tmt_smp WHERE id=:id")
  boolean delete(int id);

}