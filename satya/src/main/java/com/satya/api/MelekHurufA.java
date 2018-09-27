package com.satya.api;

import com.satya.repository.MelekHurufR;
import com.satya.object.MelekHurufO;


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

public class MelekHurufA extends Jooby {

  {
		path("/api/melek_huruf", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				MelekHurufO melekHuruf = req.body(MelekHurufO.class);
				MelekHurufR db = require(MelekHurufR.class);
				int id = db.insert(melekHuruf);

				return id;
			});
	      
			/**
			 * Daftar DB Surabaya dengan jumlah maksimal max data dan dimulai dari start.
			 */

			/*Pagination*/
			get(req -> {
		        MelekHurufR db = require(MelekHurufR.class);

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
				MelekHurufR db = require(MelekHurufR.class);

				int id = req.param("id").intValue();

				MelekHurufO melekHuruf = db.findById(id);

				if(melekHuruf == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return melekHuruf;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				MelekHurufR db = require(MelekHurufR.class);
				MelekHurufO melekHuruf = req.body(MelekHurufO.class);
				boolean status = false;
				
				if (!db.update(melekHuruf)) {
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
				MelekHurufR db = require(MelekHurufR.class);
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
		path("/api/max-hal/melek_huruf", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		MelekHurufR db = require(MelekHurufR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });
      }
}
