import static org.junit.Assert.*;

import org.junit.Test;

public class LCSTest {

	@Test
	public void testLCS() {
		assertEquals("LCS Legnth: 3	LCS: rat ear apple", LCS.lcs("rat apple cat ear cat apple rat", "cat rat ear apple mush"));
	}

}
