package com.satya.repository;

import com.satya.object.TahunO;
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

@RegisterRowMapper(TahunO.Mapper.class)
@RegisterRowMapper(InfoWindowO.Mapper.class)
public interface TahunR {

  /**
   * Mengambil semua tahun dari tabel tahun
 */
  @SqlQuery("SELECT tahun FROM tahun")
  List<String> getAllTahun();
 

}