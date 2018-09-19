package kr.itedu.board.common;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnector {
	
	public static Connection getConn() throws SQLException{
		Connection c = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/oracleDB");
			c = ds.getConnection();
		} catch (NamingException e) {
			//TODO:예외처리
		} catch (Exception e) {
			//TODO:예외처리
		}
		
		return c;
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try { rs.close(); } catch (Exception e) {}
		}
		if (ps != null) {
			try { ps.close(); } catch (Exception e) {}
		}
		if (conn != null) {
			try { conn.close(); } catch (Exception e) {}
		}
	}
}
