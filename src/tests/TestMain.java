package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Main;

class TestMain {
	
	Main mymain;

	@Test
	void test() {
		mymain.main(null);
		assert(!mymain.myIntegratedSensorSuite.equals(null));
		assert(mymain.FILE_NAME.equals("data.txt"));
	}

}
