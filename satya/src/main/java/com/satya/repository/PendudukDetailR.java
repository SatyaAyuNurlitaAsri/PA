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

@RegisterRowMapper(PendudukDetailO.Mapper.class)
public interface PendudukDetailR {

  @SqlQuery("SELECT a.id, a.id_kec, a.jml_penduduk, a.tahun, b.name from kepadatan_penduduk a,sby b where a.id_kec=b.gid ORDER BY a.id desc limit :max offset :start")
  List<PendudukDetailO> list(int start, int max);

}