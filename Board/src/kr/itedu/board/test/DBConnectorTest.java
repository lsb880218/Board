package kr.itedu.board.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import kr.itedu.board.common.DBConnector;

class DBConnectorTest {

	@Test
	void testGetConn() throws SQLException {
		Connection conn = DBConnector.getConn();
		assertNotNull(conn);
	}

}
