package lockThatDown;
import java.util.*;

public class LockThatDownImplementation {
	
	/*
	Creates a random combination
	Returns:
	comboNums - an array of random Biting Numbers
	Given: 
	randomGen - number of biting numbers to generate
	*/
	public int[] randomGen(int numbers) {
		int[] comboNums = new int[numbers];
		Random randVal = new Random();
		
		//Create biting numbers
		for(int i = 0; i < numbers; i++) {
			comboNums[i] = randVal.nextInt(6)+1;
		}
		
		//Return combination
		return comboNums;
	}
	
	/*
	Creates a set of random combinations with no duplicates
	Returns:
	comboArr - an 2D array of combinations with random biting numbers
	Given: 
	numCombos - number of combinations to generate
	numBiting - number of biting numbers in each combination
	*/
	public int[][] comboGenerator(int numCombos, int numBiting){
		int[][] comboArr = new int[numCombos][numBiting];
		int[] tempArr = new int[numBiting];
		boolean isDup = false;
		
		//Create the combinations
		for(int i = 0; i < numCombos; i++) {
			tempArr = randomGen(numBiting);
			
			//Test for duplicates
			for(int n = 0; n < numCombos; n++) {
				if(comboArr[n] == tempArr) {
					isDup = true;
					i--;
				}
			}
			
			//Add combination if unique
			if(isDup == false) {
				comboArr[i] = tempArr;
			}
			isDup = false;
		}
		
		//Return combinations
		return comboArr;
	}
}
