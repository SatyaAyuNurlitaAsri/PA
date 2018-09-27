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

public class KepadatanPendudukA extends Jooby {

  {
		path("/api/kepadatan_penduduk", () -> {
			/**
			 * Menambahkan Kasus DB dan me-return id-nya.
			 */
			post(req -> {
				KepadatanPendudukR db = require(KepadatanPendudukR.class);
				KepadatanPendudukO kepadatanPenduduk = req.body(KepadatanPendudukO.class);
				int id = db.insert(kepadatanPenduduk);

				return id;
			});
	      

			/*Pagination*/
			get(req -> {
		        KepadatanPendudukR db = require(KepadatanPendudukR.class);

		        int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;

		        return db.list(start, max);
		      });
			
			
			/**
			 * Get Kepadatan Penduduk berdasarkan ID.
			 */
			get("/:id", req -> {
				KepadatanPendudukR db = require(KepadatanPendudukR.class);

				int id = req.param("id").intValue();

				KepadatanPendudukO kepadatanPenduduk = db.findById(id);

				if(kepadatanPenduduk == null) {
					throw new Err(Status.NOT_FOUND);
				}

				return kepadatanPenduduk;
			});
			
			/**
			 * Update Kepadatan Penduduk berdasarkan ID.
			 */
			put(req -> {
				KepadatanPendudukR db = require(KepadatanPendudukR.class);
				KepadatanPendudukO kepadatanPenduduk = req.body(KepadatanPendudukO.class);
				boolean status = false;
				
				if (!db.update(kepadatanPenduduk)) {
					throw new Err(Status.NOT_FOUND);
				} else {
					status = true;
				}
				
				return status;
			});
			
			/**
			 * Delete Kepadatan Penduduk berdasarkan ID.
			 */
			delete("/:id", req -> {
				KepadatanPendudukR db = require(KepadatanPendudukR.class);
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
		path("/api/max-hal/kepadatan_penduduk", () -> {
	    	/**
	    	* Mendapatkan halaman maks Kepadatan Penduduk
	    	*/
	    	get(req -> {
	    		KepadatanPendudukR db = require(KepadatanPendudukR.class);
	        	double jmlTotal;

	        	jmlTotal = (double) db.total();

	        	double halTotal = jmlTotal/31;
	        	if ((halTotal%1) > 0) {
	        		halTotal = halTotal - (halTotal%1) + 1;
	        	}

	        	return (int) halTotal;
	    	});
	    });

		path("/api/detail/kepadatanpenduduk", () -> {
	    	/**
	    	* Mendapatkan nama detail kecamatan Kepadatan Penduduk
	    	*/
	    	get(req -> {
			PendudukDetailR kepadatanPenduduk = require(PendudukDetailR.class);
			//String tahun = "%" + req.param("tahun").value(" ") + "%";
			int hal = req.param("hal").intValue();

		        if (hal < 1) {
		        	hal = 1;
		        }

		        int start = (hal-1)*31;
		        int max = 31;
				return kepadatanPenduduk.list(start, max);
			});
		});



      }
}
