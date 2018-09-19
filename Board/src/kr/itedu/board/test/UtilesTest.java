package kr.itedu.board.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.itedu.board.common.Utils;

class UtilesTest {

	@Test
	void testGetParamInt() {
		String str = "1";
		int i = Utils.getParamInt(str);
		assertEquals(1, i);
	}

}
