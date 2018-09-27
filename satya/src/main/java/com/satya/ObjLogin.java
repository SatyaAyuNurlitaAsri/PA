package com.satya;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjLogin{
	public static class Mapper implements RowMapper<ObjLogin> {
		@Override public ObjLogin map(final ResultSet rs, final StatementContext ctx) throws SQLException {
			return new ObjLogin(rs.getString("username"), rs.getString("password"));
		}
	}

	private String username;
	private String password;

	public ObjLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}
}