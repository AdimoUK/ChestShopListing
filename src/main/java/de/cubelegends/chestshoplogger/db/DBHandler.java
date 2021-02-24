package de.cubelegends.chestshoplogger.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
	
	private String host;
	private int port;
	private String user;
	private String password;
	private String database;
        private String ssl;
	
	public DBHandler(String host, int port, String user, String password, String database, boolean ssl) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
                this.ssl = String.valueOf(ssl);
	}

	public Connection open() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true" + "&useSSL=" + ssl, user, password);
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		return con;
	}

}