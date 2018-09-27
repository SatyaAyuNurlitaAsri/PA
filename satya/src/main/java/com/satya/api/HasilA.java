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

public class HasilA extends Jooby {

  {
		path("/api/hasil", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				HasilO hasil = req.body(HasilO.class);
				HasilR db = require(HasilR.class);
				int id = db.insert(hasil);

				return id;
			});
	      
			/**
			 * Daftar DB Surabaya dengan jumlah maksimal max data dan dimulai dari start.
			 */

			/*Pagination*/
			get(req -> {
		        HasilR db = require(HasilR.class);
		        int tahun = req.param("tahun").intValue();

		        return db.listByTahun(tahun);
		    });
			
			/**
			 * Get Kasus berdasarkan ID.
			 */
			get("/:id", req -> {
				HasilR db = require(HasilR.class);

				int id = req.param("id").intValue();

				HasilO hasil = db.findById(id);

				if(hasil == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return hasil;
			});
			
			/**
			 * Update Kasus DB berdasarkan ID.
			 */
			put(req -> {
				HasilR db = require(HasilR.class);
				HasilO hasil = req.body(HasilO.class);
				boolean status = false;
				
				if (!db.update(hasil)) {
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
				HasilR db = require(HasilR.class);
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

		path("/api/max-hal/hasil", () -> {
	    	/**
	    	* Mendapatkan halaman maks Data Sensor
	    	*/
	    	get(req -> {
	    		HasilR db = require(HasilR.class);
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