package com.satya.api;

import com.satya.repository.KasusDbR;
import com.satya.repository.KepadatanPendudukR;
import com.satya.repository.KemiskinanR;
import com.satya.repository.TidakSekolahR;
import com.satya.repository.BlmTamatSdR;
import com.satya.repository.TamatSdR;
import com.satya.repository.TamatSmpR;
import com.satya.repository.TamatSmaR;
import com.satya.repository.TamatPtR;
import com.satya.repository.TahunR;
import com.satya.repository.SbyR;

import com.satya.object.AllVarO;
import com.satya.object.SbyO;
import com.satya.object.TahunO;

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

public class MetodeA extends Jooby {
	{
		/**/
		path("/api/metode", () -> {
	    	/**
	    	* Menghitung menggunakan regresi multivariat
	    	*/
	    	get(req -> {

	    		KasusDbR databaseKasusDB = require(KasusDbR.class);
	    		KepadatanPendudukR databaseKepadatanPenduduk = require(KepadatanPendudukR.class);
	    		KemiskinanR databaseKemiskinan = require(KemiskinanR.class);
	    		TidakSekolahR databaseTidakSekolah = require(TidakSekolahR.class);
	    		BlmTamatSdR databaseBlmTamatSd  = require(BlmTamatSdR.class);
	    		TamatSdR databaseTamatSd = require(TamatSdR.class);
	    		TamatSmpR databaseTamatSmp = require(TamatSmpR.class);
	    		TamatSmaR databaseTamatSma = require(TamatSmaR.class);
	    		TamatPtR databaseTamatPt = require(TamatPtR.class);
	    		SbyR databaseSby = require(SbyR.class);
	    		TahunR databaseTahun = require(TahunR.class);

	    		//Ambil data kecamatan dari database
				List<String> kecamatanSby = databaseSby.getAllSby();

				//Ambil data tahun dari database
				List<String> tahun = databaseTahun.getAllTahun();

				//Variabel untuk menyimpan yang akan di-return
				List<AllVarO> toReturn = new ArrayList<AllVarO>();

				//Loop Sebanyak Kecamatan yang ada di Surabaya
				for(int i=0; i<kecamatanSby.size(); i++){
					int idKec = Integer.parseInt(kecamatanSby.get(i));

					for(int j=0; j<tahun.size(); j++){
						String t = tahun.get(j);

						//ambil data kasus db, kepadatan penduduk, kemiskinan, dan jenjang pendidikan
						double kasusDB = Double.parseDouble(
							databaseKasusDB.getJumlahKasusByIdKec(idKec, t)
						);
						double kepadatanPenduduk = Double.parseDouble(
							databaseKepadatanPenduduk.getKepadatanPendudukByIdKec(idKec, t)
						);
						double kemiskinan = Double.parseDouble(
							databaseKemiskinan.getKemiskinanByIdKec(idKec, t)
						);
						double tidakSekolah = Double.parseDouble(
							databaseTidakSekolah.getTidakSekolahByIdKec(idKec, t)
						);
						double blmTamatSd = Double.parseDouble(
							databaseBlmTamatSd.getBlmTamatSdByIdKec(idKec, t)
						);
						double tamatSd = Double.parseDouble(
							databaseTamatSd.getTamatSdByIdKec(idKec, t)
						);
						double tamatSmp = Double.parseDouble(
							databaseTamatSmp.getTamatSmpByIdKec(idKec, t)
						);
						double tamatSma = Double.parseDouble(
							databaseTamatSma.getTamatSmaByIdKec(idKec, t)
						);
						double tamatPt = Double.parseDouble(
							databaseTamatPt.getTamatPtByIdKec(idKec, t)
						);

			 			toReturn.add(new AllVarO(
			 				idKec,
			 				t,
			 				kasusDB,
			 				kepadatanPenduduk,
			 				kemiskinan,
			 				tidakSekolah,
			 				blmTamatSd,
			 				tamatSd,
			 				tamatSmp,
			 				tamatSma,
			 				tamatPt
			 			));
					}
				}
		        return toReturn;
	    		
	    	});
	    });
    }
}
