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

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TidakSekolahA extends Jooby {

  {
		path("/api/tidak_sekolah", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				TidakSekolahO tidakSekolah = req.body(TidakSekolahO.class);
				TidakSekolahR db = require(TidakSekolahR.class);
				int id = db.insert(tidakSekolah);

				return id;
			});
	      
			/**
			 * Daftar DB Surabaya dengan jumlah maksimal max data dan dimulai dari start.
			 */

			/*Pagination*/
			get(req -> {
		        TidakSekolahR db = require(TidakSekolahR.class);

		        int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;

		        return db.list(start, max);
		      });
			
			/**
			 * Get Kasus berdasarkan ID.
			 */
			get("/:id", req -> {
				TidakSekolahR db = require(TidakSekolahR.class);

				int id = req.param("id").intValue();

				TidakSekolahO tidakSekolah = db.findById(id);

				if(tidakSekolah == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return tidakSekolah;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				TidakSekolahR db = require(TidakSekolahR.class);
				TidakSekolahO tidakSekolah = req.body(TidakSekolahO.class);
				boolean status = false;
				
				if (!db.update(tidakSekolah)) {
					throw new Err(Status.NOT_FOUND);
				} else {
					status = true;
				}
				
				return status;
			});
			
			/**
			 * Delete KasusDb berdasarkan ID.
			 */
			delete("/:id", req -> {
				TidakSekolahR db = require(TidakSekolahR.class);
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
		
		/**/
		path("/api/max-hal/tidak_sekolah", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		TidakSekolahR db = require(TidakSekolahR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });


		path("/api/detail/tidak_sekolah", () -> {
	    	/**
	    	* Mendapatkan nama detail kecamatan Tidak Sekolah
	    	*/
	    	get(req -> {
			TidakSekolahDetailR tidakSekolah = require(TidakSekolahDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return tidakSekolah.list(start, max);
			});
		});

      }

}
