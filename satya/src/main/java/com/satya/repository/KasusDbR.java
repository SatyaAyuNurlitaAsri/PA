package com.satya.repository;

import com.satya.object.KasusDbO;
import com.satya.object.InfoWindowO;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(KasusDbO.Mapper.class)
@RegisterRowMapper(InfoWindowO.Mapper.class)
public interface KasusDbR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT id_kec, jml_kasus, tahun, id from kasus_db ORDER BY id desc limit :max offset :start")
  List<KasusDbO> list(int start, int max);

  /**
   * Mengambil semu jumlah kasus demam berdarah dari tabel kasus_db
 */
  @SqlQuery("SELECT jml_kasus FROM kasus_db")
  List<String> getAllJumlahKasus();

  /**
   * Mengambil jumlah kasus demam berdarah dari tabel kasus_db berdasarkan ID dan tahun
 */
  @SqlQuery("SELECT jml_kasus FROM kasus_db WHERE id_kec=:idKec AND tahun=:tahun")
  String getJumlahKasusByIdKec(int idKec, String tahun);

  /**
   * Get total item dari data ikan
   */
  @SqlQuery("SELECT COUNT(*) FROM kasus_db")
  int total();


  /**
    *Select data dari table surabayaa
 */
  @SqlQuery("SELECT * from kasus_db where id=:id")
  KasusDbO findById(long id);

  /**
    * Select data kasus demam berdarah berdasar ID kecamatan dan tahun
    */
  @SqlQuery("SELECT kd.jml_kasus, kp.jml_penduduk, km.jml_kemiskinan, blm.jml_belum, bts.jml_blm_sd, tsd.jml_tmt_sd, tsp.jml_tmt_smp, tsa.jml_tmt_sma, tpt.jml_tmt_pt FROM kasus_db AS kd, kepadatan_penduduk AS kp, angka_kemiskinan AS km, blm_sekolah AS blm, blm_tmt_sd AS bts, tmt_sd AS tsd, tmt_smp AS tsp, tmt_sma AS tsa, tmt_pt AS tpt "
    + "WHERE kd.id_kec=:idKecamatan"
    + " AND kd.tahun=:tahun"
    + " AND kp.tahun=:tahun"
    + " AND kp.id_kec=:idKecamatan"
    + " AND km.tahun=:tahun"
    + " AND km.id_kec=:idKecamatan"
    + " AND blm.tahun=:tahun"
    + " AND blm.id_kec=:idKecamatan"
    + " AND bts.tahun=:tahun"
    + " AND bts.id_kec=:idKecamatan"
    + " AND tsd.tahun=:tahun"
    + " AND tsd.id_kec=:idKecamatan"
    + " AND tsp.tahun=:tahun"
    + " AND tsp.id_kec=:idKecamatan"
    + " AND tsa.tahun=:tahun"
    + " AND tsa.id_kec=:idKecamatan"
    + " AND tpt.tahun=:tahun"
    + " AND tpt.id_kec=:idKecamatan"

  )
  InfoWindowO findForInfoWindow(int idKecamatan, String tahun);

   /**
   * Menambahkan Features dan me-return keberhasilannya.
   */
  @SqlUpdate("INSERT INTO kasus_db(id_kec, jml_kasus, tahun) VALUES(:idKec, :jmlKasus, :tahun)")
  @GetGeneratedKeys
  int insert(@BindBean KasusDbO KasusDbO);


  /**
   * Meng-update tablle surabayaa berdasarkan ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("UPDATE kasus_db SET id_kec=:idKec, jml_kasus=:jmlKasus, tahun=:tahun WHERE id=:id")
  boolean update(@BindBean KasusDbO KasusDbO);

  /**
   * Menghapus Features berdasar ID-nya dan me-return keberhasilannya.
   */
  @SqlUpdate("DELETE FROM kasus_db WHERE id=:id")
  boolean delete(int id);

}