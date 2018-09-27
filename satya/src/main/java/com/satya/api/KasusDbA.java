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

public class KasusDbA extends Jooby {

  {
		path("/api/kasus_db", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				KasusDbO kasusDb = req.body(KasusDbO.class);
				KasusDbR db = require(KasusDbR.class);
				int id = db.insert(kasusDb);

				return id;
			});
	      
			/**
			 * Daftar DB Surabaya dengan jumlah maksimal max data dan dimulai dari start.
			 */

			/*Pagination*/
			get(req -> {
		        KasusDbR db = require(KasusDbR.class);

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
				KasusDbR db = require(KasusDbR.class);

				int id = req.param("id").intValue();

				KasusDbO kasusDb = db.findById(id);

				if(kasusDb == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return kasusDb;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				KasusDbR db = require(KasusDbR.class);
				KasusDbO kasusDb = req.body(KasusDbO.class);
				boolean status = false;
				
				if (!db.update(kasusDb)) {
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
				KasusDbR db = require(KasusDbR.class);
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
		path("/api/max-hal/kasus_db", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		KasusDbR db = require(KasusDbR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });


		path("/api/tampildata/kasus_db", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
			TampilDataR kasusDb = require(TampilDataR.class);
			String tahun = "%" + req.param("tahun").value(" ") + "%";
			return kasusDb.list(tahun);
			});
		});

		path("/api/rincian/kasus_db", () -> {
	    	/**
	    	* Mendapatkan data kasus DB berdasarkan tahun dan ID kecamatan
	    	*/
	    	get(req -> {
				KasusDbR kasusDb = require(KasusDbR.class);
				int idKecamatan = req.param("idKecamatan").intValue(1);
				String tahun = req.param("tahun").value("2012");
				
				return kasusDb.findForInfoWindow(idKecamatan, tahun);
			});
		});

		path("/api/detail/kasusdb", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
			KasusDetailR kasusDb = require(KasusDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return kasusDb.list(start, max);
			});
		});

      }

}
