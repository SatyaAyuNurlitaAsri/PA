package com.satya;

import org.jooby.Err;
import org.jooby.FlashScope;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Status;
import org.jooby.Session;
import org.jooby.jdbc.Jdbc;
import org.jooby.jdbi.Jdbi3;
import org.jooby.jdbi.TransactionalRequest;
import org.jooby.json.Jackson;

//import org.mindrot.jbcrypt.BCrypt;

public class ProsesLogin extends Jooby {
	{
		cookieSession();
		use(new FlashScope()); //notifikasi login

		// login
		post("/login/do", req -> {
			ObjLogin login = req.form(ObjLogin.class);

			String username = login.getUsername();
			String password = login.getPassword();

			//return password.equals("12345");
			//uname = admin
			//passwd = 12345
			if (password.equals("12345") && username.equals("admin")){
				Session session = req.session();

				session.set("nama", login.getUsername());
				return Results.html("/AdminPage");

				// return "ytrtyhuji";
			} else {
				req.flash("gagal", "true");
				return Results.redirect("/login");
			}
			
		});

		// logout
		get("/logout/do", req -> {
			Session session = req.session();

			if (session.isSet("nama")) {
				session.unset();
			}

			return Results.redirect("/login");
		});
	}
}