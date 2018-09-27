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

public class SbyA extends Jooby {

  {
	path("/api/sby_kecamatan", () -> {
		/**
		 * Menambahkan Poligon Surabaya dan me-return id-nya.
		 */
		post(req -> {
			SbyR db = require(SbyR.class);
			SbyO sbyO = req.body(SbyO.class);
			int gid = db.insert(sbyO);

			return gid;
		});
      
		/**
		 * Daftar Kecamatan Surabaya dengan jumlah maksimal max data dan dimulai dari start.
		 */
		get(req -> {
			SbyR sby = require(SbyR.class);
			HasilR hasil = require(HasilR.class);
			int start = req.param("start").intValue(0);
			int max = req.param("max").intValue(31);
			int tahun = req.param("tahun").intValue();
			List<SbyO> sbyO = sby.list(start,max);
			List<HasilO> hasilO = hasil.listByTahun(tahun);

			for(int i=0; i<sbyO.size(); i++) {
				for(int j=0; j<hasilO.size(); j++) {
					if(sbyO.get(i).getGid() == hasilO.get(j).getIdKec()) {
						sbyO.get(i).setHasil(Double.parseDouble(hasilO.get(j).getHasil()));
						break;
					}
				}
			}

			return sbyO;
		});
		
		/**
		 * Get Surabaya berdasarkan ID.
		 */
		get("/:gid", req -> {
			SbyR db = require(SbyR.class);

			int gid = req.param("gid").intValue();

			SbyO sby = db.findById(gid);

			if(sby == null) {
				throw new Err(Status.NOT_FOUND);
			}

			return sby;
		});
		
		/**
		 * Update Jenis Kriminalitas berdasarkan ID.
		 */
		put(req -> {
			SbyR db = require(SbyR.class);
			SbyO sby = req.body(SbyO.class);
			boolean status = false;
			
			if (!db.update(sby)) {
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
			SbyR db = require(SbyR.class);
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


	/*Path option id_kec*/
	path("/api/option/kecamatan", () -> { 
		/** 
		* Mendapatkan Detail dari Kecamatan 
		*/ 

		get(req -> { 
			OptionKecamatanR db = require(OptionKecamatanR.class); 

			String keyword = "%" + req.param("keyword").value("") + "%"; 

			if(keyword == ""){ 
				return db.option(); 
			}else{ 
				return db.optionByName(keyword); 
			} 
		}); 
	});
  }
}
