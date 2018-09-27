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

public class TamatSmpA extends Jooby {

  {
		path("/api/tamat_smp", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				TamatSmpR db = require(TamatSmpR.class);
				TamatSmpO tamatSmp = req.body(TamatSmpO.class);
				int id = db.insert(tamatSmp);

				return id;
			});
	      

			/*Pagination*/
			get(req -> {
		        TamatSmpR db = require(TamatSmpR.class);

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
				TamatSmpR db = require(TamatSmpR.class);

				int id = req.param("id").intValue();

				TamatSmpO tamatSmp = db.findById(id);

				if(tamatSmp == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return tamatSmp;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				TamatSmpR db = require(TamatSmpR.class);
				TamatSmpO tamatSmp = req.body(TamatSmpO.class);
				boolean status = false;
				
				if (!db.update(tamatSmp)) {
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
				TamatSmpR db = require(TamatSmpR.class);
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
		path("/api/max-hal/tamat_smp", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		TamatSmpR db = require(TamatSmpR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });

	    path("/api/detail/tamat_smp", () -> {
	    	/**
	    	* Mendapatkan halaman maks tamat smp
	    	*/
	    	get(req -> {
			TamatSmpDetailR tamatSmp = require(TamatSmpDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return tamatSmp.list(start, max);
			});
		});
      }
}
