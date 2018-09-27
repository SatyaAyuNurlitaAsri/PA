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

@RegisterRowMapper(TamatSmaDetailO.Mapper.class)
public interface TamatSmaDetailR {

  @SqlQuery("SELECT a.id, a.id_kec, a.jml_tmt_sma, a.tahun, b.name from tmt_sma a,sby b where a.id_kec=b.gid ORDER BY a.id desc limit :max offset :start")
  List<TamatSmaDetailO> list(int start, int max);

}