package lockThatDown;
import java.util.*;

public class LockThatDownLowerpins {
	
	/*
	Uses random combination generation used to make lower pin values 1-4
	Returns:
	LowerPincomboNums - an array of random Biting Numbers 1-4
	Given: 
	LowerPinrandomGen - number of biting numbers to generate
	*/
	public int[] LowerPinrandomGen(int LowerPinnumbers) {
		int[] LowerPincomboNums = new int[LowerPinnumbers];
		Random randVal = new Random();
		
		//Create biting numbers
		for(int i = 0; i < LowerPinnumbers; i++) {
			LowerPincomboNums[i] = randVal.nextInt(3)+1;
		}
		
		//Return combination
		return LowerPincomboNums;
	}
	
	/*
	Creates a set of random combinations with no duplicates
	Returns:
	LowerPincomboArr - an 2D array of combinations with random biting numbers used for LowerPins
	Given: 
	LowerPinnumCombos - number of combinations to generate for LowerPins
	LowerPinnumBiting - number of biting numbers in each LowerPin combination 
	*/
	public int[][] LowerPincomboGenerator(int LowerPinnumCombos, int LowerPinnumBiting){
		int[][] LowerPincomboArr = new int[LowerPinnumCombos][LowerPinnumBiting];
		int[] tempArr = new int[LowerPinnumBiting];
		boolean isDup = false;
		
		//Create the LowerPin combinations
		for(int i = 0; i < LowerPinnumCombos; i++) {
			tempArr = LowerPinrandomGen(LowerPinnumBiting);
			
			//Test for duplicates
			for(int n = 0; n < LowerPinnumCombos; n++) {
				if(LowerPincomboArr[n] == tempArr) {
					isDup = true;
					i--;
				}
			}
			
			//Add LowerPin combination if unique
			if(isDup == false) {
				LowerPincomboArr[i] = tempArr;
			}
			isDup = false;
		}
		
		//Return LowerPin combinations
		return LowerPincomboArr;
	}
}
