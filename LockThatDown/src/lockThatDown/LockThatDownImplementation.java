package lockThatDown;
import java.lang.reflect.Array;
import java.util.*;

public class LockThatDownImplementation {
	
	/*
	randomGen
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
	comboGenerator
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
	
	/*
	masterKey
	Creates a master key and set of master wafers
	Returns:
	mPins - 2D array of master wafers with the master key as first array
	Given: 
	combos - the set of combinations that we are making a master key for
	*/
	public int[][] masterKey(int[][] combos) {
		int[] mKey = new int[combos[0].length];
		int[][] mPins = new int[combos[0].length+1][combos.length];
		int[] tempArr = new int[combos.length];
		
		//Iterate through each pin position
		for(int n = 0; n < combos[0].length; n++) {
			
			//Add the column to the a temporary array for use.
			for(int i = 0; i < combos.length; i++) {
				tempArr[i] = combos[i][n];
			}
			
			//Sort the array of biting pins in ascending order
			Arrays.sort(tempArr);
			
			//Reverse array in place to make it descending
			for(int i = 0; i < tempArr.length/2; i++) {
				int temp = tempArr[i];
				tempArr[i] = tempArr[tempArr.length - 1 - i];
				tempArr[tempArr.length - 1 - i] = temp;
			}
			
			//Set our temporary pin to the highest biting number in the array
			int tempPin = tempArr[0];
			
			//Set the master key and master wafers
			for(int i = 0; i < tempArr.length; i++) {
				
				//Add the difference in pins to our set of master wafers.
				mPins[n+1][i] = tempPin - tempArr[i];
				
				//Save the new lowest pin
				if(tempArr[i] < tempPin) {
					tempPin = tempArr[i];
				}
			}
			
			//Add the lowest pin to our master key
			mKey[n] = tempPin;
		}
		
		//Make the master key the first array in our 2D array
		mPins[0] = mKey;
		
		//Return the 2D array
		return mPins;
	}
}
