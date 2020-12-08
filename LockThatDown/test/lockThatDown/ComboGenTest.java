package lockThatDown;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ComboGenTest {
	LockThatDownImplementation lockdownTest = new LockThatDownImplementation();
	@Before public void setup() {
		
	}
	@Test
	void testDuplicate() {
		boolean dupBoolean = false;
		int numberCombos = 8;
		int bitingNumbers = 6;
		int[][] testCombos = new int[numberCombos][bitingNumbers];
		int[] testArr = new int[bitingNumbers];
		testCombos = lockdownTest.comboGenerator(numberCombos, bitingNumbers);
		for(int i = 0; i < numberCombos; i++) {
			testArr = testCombos[i];
			for(int n = 0; n < numberCombos; n++) {
				if(i != n && testArr == testCombos[n]) {
					dupBoolean = true;
				}
			}
		}
		if(dupBoolean == true) {
			fail("There is a duplicate array");
		}
	}
}
