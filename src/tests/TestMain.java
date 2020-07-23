package tests;

import org.junit.jupiter.api.Test;

import application.Main;

class TestMain {
	
	Main mymain;

	@SuppressWarnings("static-access")
	@Test
	void test() {
		mymain.main(null);
		assert(!mymain.myIntegratedSensorSuite.equals(null));
		assert(mymain.FILE_NAME.equals("data.txt"));
	}

}
