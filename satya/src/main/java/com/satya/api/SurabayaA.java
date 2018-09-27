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

public class SurabayaA extends Jooby {

  {
	path("/api/sby_desa", () -> {
		/**
		 * Menambahkan Poligon Surabaya dan me-return id-nya.
		 */
		post(req -> {
			SurabayaR db = require(SurabayaR.class);
			SurabayaO surabaya = req.body(SurabayaO.class);
			int id;
			boolean toReturn = false;

			id = db.insert(surabaya);

			if(id > 0) {
				toReturn = true;
			}

			return toReturn;
		});
      
		/**
		 * Daftar Desa Surabaya dengan jumlah maksimal max data dan dimulai dari start.
		 */
		get(req -> {
			SurabayaR surabaya = require(SurabayaR.class);

			int start = req.param("start").intValue(0);
			int max = req.param("max").intValue(165);

			return surabaya.list(start,max);
		});
		
		/**
		 * Get Surabaya berdasarkan ID.
		 */
		get("/:id", req -> {
			SurabayaR db = require(SurabayaR.class);

			int id = req.param("id").intValue();

			SurabayaO surabaya = db.findById(id);

			if(surabaya == null) {
				throw new Err(Status.NOT_FOUND);
			}

			return surabaya;
		});
		
		/**
		 * Update Jenis Kriminalitas berdasarkan ID.
		 */
		put(req -> {
			SurabayaR db = require(SurabayaR.class);
			SurabayaO surabaya = req.body(SurabayaO.class);
			boolean status = false;
			
			if (!db.update(surabaya)) {
				throw new Err(Status.NOT_FOUND);
			} else {
				status = true;
			}
			
			return status;
		});
		
		/**
		 * Delete Jenis Kriminalitas berdasarkan ID.
		 */
		delete("/:id", req -> {
			SurabayaR db = require(SurabayaR.class);
			int id = req.param("id").intValue();
			boolean status = false;

			if (!db.delete(id)) {
				throw new Err(Status.NOT_FOUND);
			} else {
				status = true;
			}

			return status;
		});
	});
      }
}
