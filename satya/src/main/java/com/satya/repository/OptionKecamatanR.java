package com.satya.repository;

import com.satya.object.OptionKecamatanO;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */

@RegisterRowMapper(OptionKecamatanO.Mapper.class)
public interface OptionKecamatanR {
 
 /**
   * Select data dari table Surabayaa
 */
  @SqlQuery("SELECT gid, name AS text from sby")
  List<OptionKecamatanO> option();

  @SqlQuery("SELECT gid, name AS text from sby WHERE name ILIKE :keyword")
  List<OptionKecamatanO> optionByName(String keyword);

}