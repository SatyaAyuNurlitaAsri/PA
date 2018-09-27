package com.satya;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Database access for pets.
 */
@RegisterRowMapper(Surabayaa.Mapper.class)
public interface SurabayaaRepository {
  /**
   * List pets using start/max limits.
   *
   * @param start Start offset.
   * @param max Max number of rows.
   * @return Available pets.
   */
  @SqlQuery("SELECT id, kelurahan, kecamatan, ST_Astext(geom) from surabayaa limit :max offset :start")
  List<Surabayaa> list(int start, int max);

  /**
   * Find a pet by ID.
   *
   * @param id Pet ID.
   * @return Pet or null.
   */
  @SqlQuery("SELECT * from surabayaa where id=:id")
  Surabayaa findById(long id);


  @SqlUpdate("INSERT INTO surabayaa (kelurahan, kecamatan, geom) VALUES( :kelurahan, :kecamatan, ST_GeomFromText(:geom,4326))")
  @GetGeneratedKeys
  int insert(@BindBean Surabayaa Surabayaa);


  /**
   * Insert a pet and returns the generated PK.
   *
   * @param pet Pet to insert.
   * @return Primary key.
   */
  // @SqlUpdate("insert into pets(name) values(:name)")
  // @GetGeneratedKeys
  // long insert(@BindBean Pet pet);

  // /**
  //  * Update a pet and returns true if the pets was updated.
  //  *
  //  * @param pet Pet to update.
  //  * @return True if the pet was updated.
  //  */
  // @SqlUpdate("update pets set name=:name where id=:id")
  // boolean update(@BindBean Pet pet);

  // /**
  //  * Delete a pet by ID.
  //  *
  //  * @param id Pet ID.
  //  * @return True if the pet was deleted.
  //  */
  // @SqlUpdate("delete pets where id=:id")
  // boolean delete(long id);
}