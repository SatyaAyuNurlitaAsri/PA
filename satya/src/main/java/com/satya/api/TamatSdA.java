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

public class TamatSdA extends Jooby {

  {
		path("/api/tamat_sd", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				TamatSdR db = require(TamatSdR.class);
				TamatSdO tamatSd = req.body(TamatSdO.class);
				int id = db.insert(tamatSd);

				return id;
			});
	      

			/*Pagination*/
			get(req -> {
		        TamatSdR db = require(TamatSdR.class);

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
				TamatSdR db = require(TamatSdR.class);

				int id = req.param("id").intValue();

				TamatSdO tamatSd = db.findById(id);

				if(tamatSd == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return tamatSd;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				TamatSdR db = require(TamatSdR.class);
				TamatSdO tamatSd = req.body(TamatSdO.class);
				boolean status = false;
				
				if (!db.update(tamatSd)) {
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
				TamatSdR db = require(TamatSdR.class);
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
		path("/api/max-hal/tamat_sd", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		TamatSdR db = require(TamatSdR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });

	    path("/api/detail/tamat_sd", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
			TamatSdDetailR tamatSd = require(TamatSdDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return tamatSd.list(start, max);
			});
		});

      }
}
