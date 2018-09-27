package com.satya.api;

import com.satya.repository.*;
import com.satya.object.*;


import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Status;
import org.jooby.jdbc.Jdbc;
import org.jooby.jdbi.Jdbi3;
import org.jooby.jdbi.TransactionalRequest;
import org.jooby.json.Jackson;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DataKecamatanA extends Jooby {

  {
	path("/api/datakecamatan", () -> {
		/**
		 * Menambahkan Poligon Surabaya dan me-return id-nya.
		 */
		post(req -> {
			DataKecamatanR db = require(DataKecamatanR.class);
			DataKecamatanO dataKecamatan = req.body(DataKecamatanO.class);
			int gid = db.insert(dataKecamatan);

			return gid;
		});
      
		/**
		 * Daftar Desa Surabaya dengan jumlah maksimal max data dan dimulai dari start.
		 */
		get(req -> {
			DataKecamatanR dataKecamatan = require(DataKecamatanR.class);

			int start = req.param("start").intValue(0);
			int max = req.param("max").intValue(165);

			return dataKecamatan.list(start,max);
		});
		
		/**
		 * Get Surabaya berdasarkan ID.
		 */
		get("/:gid", req -> {
			DataKecamatanR db = require(DataKecamatanR.class);

			int gid = req.param("gid").intValue();

			DataKecamatanO dataKecamatan = db.findById(gid);

			if(dataKecamatan == null) {
				throw new Err(Status.NOT_FOUND);
			}

			return dataKecamatan;
		});
		
		/**
		 * Update Jenis Kriminalitas berdasarkan ID.
		 */
		put(req -> {
			DataKecamatanR db = require(DataKecamatanR.class);
			DataKecamatanO dataKecamatan = req.body(DataKecamatanO.class);
			boolean status = false;
			
			if (!db.update(dataKecamatan)) {
				throw new Err(Status.NOT_FOUND);
			} else {
				status = true;
			}
			
			return status;
		});
		
		/**
		 * Delete Jenis Kriminalitas berdasarkan ID.
		 */
		delete("/:gid", req -> {
			DataKecamatanR db = require(DataKecamatanR.class);
			int gid = req.param("gid").intValue();
			boolean status = false;

			if (!db.delete(gid)) {
				throw new Err(Status.NOT_FOUND);
			} else {
				status = true;
			}

			return status;
		});
	});
  }
}
