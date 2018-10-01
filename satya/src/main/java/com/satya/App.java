package com.satya;

//import com.satya.object.*;
import com.satya.repository.*;
import com.satya.api.*;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Status;
import org.jooby.jdbc.Jdbc;
import org.jooby.jdbi.Jdbi3;
import org.jooby.jdbi.TransactionalRequest;
import org.jooby.json.Jackson;
import org.jooby.apitool.ApiTool;
import org.jooby.handlers.CorsHandler;
import org.jooby.Session;
import org.jooby.hbs.Hbs;

import java.util.List;
import java.util.ArrayList;

/**
 * @author jooby generator
 */

public class App extends Jooby {
  {
    use("*", new CorsHandler());
    use(new Jackson());
    use(new Jdbc());
    use(new Hbs());

    use(new Jdbi3()
      /** Install SqlObjectPlugin */
      .doWith(jdbi -> {
        jdbi.installPlugin(new SqlObjectPlugin());
      })
      /** Creates a transaction per request */
      .transactionPerRequest(
        new TransactionalRequest()
          //.attach(SurabayaR.class)
          .attach(SbyR.class)
          .attach(KasusDbR.class)
          .attach(MelekHurufR.class)
          .attach(KemiskinanR.class)
          .attach(KepadatanPendudukR.class)
          .attach(TidakSekolahR.class)
          .attach(BlmTamatSdR.class)
          .attach(TamatSdR.class)
          .attach(TamatSmpR.class)
          .attach(TamatSmaR.class)
          .attach(TamatPtR.class)
          .attach(KasusDetailR.class)
          .attach(PendudukDetailR.class)
          .attach(KemiskinanDetailR.class)
          .attach(TidakSekolahDetailR.class)
          .attach(BlmTamatSdDetailR.class)
          .attach(TamatSdDetailR.class)
          .attach(TamatSmpDetailR.class)
          .attach(TamatSmaDetailR.class)
          .attach(TamatPtDetailR.class)
          .attach(HasilR.class)
          .attach(TahunR.class)
          //.attach(PendapatanR.class)
          //.attach(DataKecamatanR.class)
          .attach(OptionKecamatanR.class)
          .attach(TampilDataR.class)
      )
    );
    
    use(new ApiTool()
      .swagger("/swagger")
    );
    
    //~ Asset script
    assets("/assets/**");

    //Halaman yang dibuka
    assets("/dashboard", "dashboard.html");
    assets("/View", "View.html");
    assets("/Bantuan", "Bantuan.html");
    assets("/Bantuan1", "Bantuan1.html");
    assets("/Bantuanlogin", "Bantuanlogin.html");
    assets("/Bantuanloginadmin", "Bantuanloginadmin.html");
    assets("/Bantuanadmin", "Bantuanadmin.html");
    //assets("/index3", "index3.html");
    //assets("/index4", "index4.html");
    assets("/PadatPenduduk", "PadatPenduduk.html");
    assets("/Kemiskinan", "Kemiskinan.html");
    assets("/MelekHuruf", "MelekHuruf.html");
    assets("/BelumSekolah", "BelumSekolah.html");
    assets("/BlmTamatSd", "BlmTamatSd.html");
    assets("/TamatSd", "TamatSd.html");
    assets("/TamatSmp", "TamatSmp.html");
    assets("/TamatSma", "TamatSma.html");
    assets("/TamatPt", "TamatPt.html");
    assets("/DataKecamatan", "DataKecamatan.html");
    assets("/AdminPage", "AdminPage.html");
    //assets("/ViewBaru", "ViewBaru.html");
    //assets("/View1", "View1.html");
    //assets("/View2", "View2.html");
    //assets("/ViewParameter", "ViewParameter.html");
    //assets("/ViewLawas", "ViewLawas.html");

    //Gambar
    assets("/img/sil.jpg", "sil.jpg");
    assets("/img/Niece.png", "Niece.png");
    assets("/img/N1.jpg", "N1.jpg");
    assets("/img/N2.jpg", "N2.jpg");
    assets("/img/Parameter.png", "Parameter.png");
    assets("/img/Loginasadmin.png", "Loginasadmin.png");
    assets("/img/Loginasguest.png", "Loginasguest.png");
    assets("/img/loginadmin.png", "loginadmin.png");
    assets("/img/LihatDataParameter.png", "LihatDataParameter.png");
    assets("/img/TambahData.png", "TambahData.png");
    assets("/img/Edit.png", "Edit.png");
    assets("/img/Hapus.png", "Hapus.png");
    assets("/img/logout.png", "logout.png");
    assets("/img/DaftarParameter.png", "DaftarParameter.png");
    assets("/img/Regresi.png", "Regresi.png");
    assets("/img/Potensi.png", "Potensi.png");

    //Rute Login admin
    use(new ProsesLogin());
    get("/login", req -> Results.html("login"));
    get("/admin", req -> {
      return Results.html("AdminPage");
    });

    //APIs
    //use(new SurabayaA());
    use(new SbyA());
    use(new KasusDbA());
    use(new MelekHurufA());
    use(new KemiskinanA());
    use(new KepadatanPendudukA());
    use(new PendapatanA());
    use(new TidakSekolahA());
    use(new BlmTamatSdA());
    use(new TamatSdA());
    use(new TamatSmpA());
    use(new TamatSmaA());
    use(new TamatPtA());
    use(new HasilA());
    use(new MetodeA());
    //use(new PengangguranA());

  }
  
  public static void main(final String[] args) {
    run(App::new, args);
  }

}
