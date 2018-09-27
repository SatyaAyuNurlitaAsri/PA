package com.satya.repository;

import com.satya.object.HasilO;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(HasilO.Mapper.class)
public interface HasilR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id, id_kec, hasil, tahun FROM hasil ORDER BY id desc limit :max offset :start")
  List<HasilO> list(int start, int max);

 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT * FROM hasil WHERE tahun::numeric=:tahun")
  List<HasilO> listByTahun(int tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM hasil")
  int total();

  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from hasil where id=:id")
  HasilO findById(long id);


   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO hasil (id_kec, hasil, tahun) VALUES( :idKec, :hasil, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean HasilO HasilO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE hasil SET id_kec=:idKec, hasil=:hasil, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean HasilO HasilO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM hasil WHERE id=:id")
  boolean delete(int id);

}