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

@RegisterRowMapper(BlmTamatSdDetailO.Mapper.class)
public interface BlmTamatSdDetailR {

  @SqlQuery("SELECT a.id, a.id_kec, a.jml_blm_sd, a.tahun, b.name from blm_tmt_sd a,sby b where a.id_kec=b.gid ORDER BY a.id desc limit :max offset :start")
  List<BlmTamatSdDetailO> list(int start, int max);

}