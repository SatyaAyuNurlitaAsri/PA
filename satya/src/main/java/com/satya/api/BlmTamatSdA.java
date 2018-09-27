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

public class BlmTamatSdA extends Jooby {

  {
		path("/api/blm_tamat_sd", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				BlmTamatSdR db = require(BlmTamatSdR.class);
				BlmTamatSdO blmTamatSd = req.body(BlmTamatSdO.class);
				int id = db.insert(blmTamatSd);

				return id;
			});
	      

			/*Pagination*/
			get(req -> {
		        BlmTamatSdR db = require(BlmTamatSdR.class);

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
				BlmTamatSdR db = require(BlmTamatSdR.class);

				int id = req.param("id").intValue();

				BlmTamatSdO blmTamatSd = db.findById(id);

				if(blmTamatSd == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return blmTamatSd;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				BlmTamatSdR db = require(BlmTamatSdR.class);
				BlmTamatSdO blmTamatSd = req.body(BlmTamatSdO.class);
				boolean status = false;
				
				if (!db.update(blmTamatSd)) {
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
				BlmTamatSdR db = require(BlmTamatSdR.class);
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
		path("/api/max-hal/blm_tamat_sd", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		BlmTamatSdR db = require(BlmTamatSdR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });

		path("/api/detail/blm_tamat_sd", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
			BlmTamatSdDetailR blmTamatSd = require(BlmTamatSdDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return blmTamatSd.list(start, max);
			});
		});


      }
}
