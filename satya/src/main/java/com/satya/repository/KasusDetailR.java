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

@RegisterRowMapper(KasusDetailO.Mapper.class)
public interface KasusDetailR {

  @SqlQuery("SELECT a.id_kec, a.jml_kasus, a.tahun, a.id, b.name from kasus_db a,sby b where a.id_kec=b.gid ORDER BY a.id desc limit :max offset :start")
  List<KasusDetailO> list(int start, int max);

}