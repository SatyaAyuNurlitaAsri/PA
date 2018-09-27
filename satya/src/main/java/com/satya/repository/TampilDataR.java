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

@RegisterRowMapper(TampilDataO.Mapper.class)
public interface TampilDataR {
 
 /**
 *Niatnya mau dibuat info window di halaman View heheheh
   * Select data dari table surabaya, kasus_db dan kepadatan_penduduk, 
 */
  @SqlQuery("SELECT a.name AS nama_kec, b.jml_penduduk AS jumlahpenduduk, c.jml_kasus AS jumlahkasus FROM sby a, kepadatan_penduduk b, kasus_db c WHERE b.id_kec=a.gid AND c.id_kec=a.gid AND c.tahun LIKE :tahun AND b.tahun LIKE :tahun")
  List<TampilDataO> list(String tahun);

  //catatan note
  //SELECT a.name AS nama_kec, b.jml_penduduk AS jumlahpenduduk, c.jml_kasus AS jumlahkasus, d.jml_kemiskinan AS jumlahkemiskinan FROM sby a, kepadatan_penduduk b, kasus_db c, angka_kemiskinan d WHERE b.id_kec=a.gid AND c.id_kec=a.gid AND d.id_kec=a.gid AND c.tahun='2012' AND b.tahun='2012' AND d.tahun='2012'

}