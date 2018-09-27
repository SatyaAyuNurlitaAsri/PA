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

public class KemiskinanA extends Jooby {

  {
		path("/api/kemiskinan", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				KemiskinanO kemiskinan = req.body(KemiskinanO.class);
				KemiskinanR db = require(KemiskinanR.class);
				int id = db.insert(kemiskinan);

				return id;
			});
	      
			/**
			 * Daftar DB Surabaya dengan jumlah maksimal max data dan dimulai dari start.
			 */

			/*Pagination*/
			get(req -> {
		        KemiskinanR db = require(KemiskinanR.class);

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
				KemiskinanR db = require(KemiskinanR.class);

				int id = req.param("id").intValue();

				KemiskinanO kemiskinan = db.findById(id);

				if(kemiskinan == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return kemiskinan;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				KemiskinanR db = require(KemiskinanR.class);
				KemiskinanO kemiskinan = req.body(KemiskinanO.class);
				boolean status = false;
				
				if (!db.update(kemiskinan)) {
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
				KemiskinanR db = require(KemiskinanR.class);
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

		path("/api/max-hal/kemiskinan", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		KemiskinanR db = require(KemiskinanR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });

		path("/api/detail/kemiskinan", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
			KemiskinanDetailR kemiskinan = require(KemiskinanDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return kemiskinan.list(start, max);
			});
		});


      }
}