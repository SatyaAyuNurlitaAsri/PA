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

public class PendapatanA extends Jooby {

  {
		path("/api/pendapatan", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				PendapatanO pendapatan = req.body(PendapatanO.class);
				PendapatanR db = require(PendapatanR.class);
				int id = db.insert(pendapatan);

				return id;
			});
	      
			/**
			 * Daftar DB Surabaya dengan jumlah maksimal max data dan dimulai dari start.
			 */

			/*Pagination*/
			get(req -> {
		        PendapatanR db = require(PendapatanR.class);

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
				PendapatanR db = require(PendapatanR.class);

				int id = req.param("id").intValue();

				PendapatanO pendapatan = db.findById(id);

				if(pendapatan == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return pendapatan;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				PendapatanR db = require(PendapatanR.class);
				PendapatanO pendapatan = req.body(PendapatanO.class);
				boolean status = false;
				
				if (!db.update(pendapatan)) {
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
				PendapatanR db = require(PendapatanR.class);
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

		path("/api/max-hal/pendapatan", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		PendapatanR db = require(PendapatanR.class);
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