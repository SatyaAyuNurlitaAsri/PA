package com.satya.repository;

import com.satya.object.PendapatanO;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(PendapatanO.Mapper.class)
public interface PendapatanR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, jml_pendapatan, tahun FROM pendapatan_perkapita ORDER BY id desc limit :max offset :start")
  List<PendapatanO> list(int start, int max);


  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM pendapatan_perkapita")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from pendapatan_perkapita where id=:id")
  PendapatanO findById(long id);


   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO pendapatan_perkapita (id_kec, jml_pendapatan, tahun) VALUES( :idKec, :jmlPendapatan, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean PendapatanO PendapatanO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE pendapatan_perkapita SET id_kec=:idKec, jml_pendapatan=:jmlPendapatan, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean PendapatanO PendapatanO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM pendapatan_perkapita WHERE id=:id")
  boolean delete(int id);

}