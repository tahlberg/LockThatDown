package lockThatDown;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MasterKeyTest {

	@Test
	void test() {
		LockThatDownImplementation lockdownTest = new LockThatDownImplementation();
		int numCombos = 4;
		int numPins = 7;
		int[][] testCombos = new int[numCombos][numPins];
		int[][] testMaster = new int[numCombos+1][numPins];
		
		testCombos = lockdownTest.comboGenerator(numCombos, numPins);
		testMaster = lockdownTest.masterKey(testCombos);
		
		//Test master key
		for(int i = 0; i < numPins; i++) {
			for(int n = 0; n < numCombos; n++) {
				if(testCombos[n][i] < testMaster[0][i]) {
					fail("Master key does not have the smallest pins");
				}
			}
		}
		
		//Test master wafers via print
		for(int i = 0; i < testMaster.length; i++) {
			if(i == 0) {
				System.out.println("Master Key biting numbers:");
			}
			else {
				System.out.println("Master wafers for pin position " + i);
			}
			for(int n = 0; n < testMaster[i].length; n++) {
				if(testMaster[i][n] != 0) {
					System.out.println(testMaster[i][n]);
				}
			}
		}
	}

}
