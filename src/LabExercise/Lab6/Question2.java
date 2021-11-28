package LabExercise.Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * Question 2 
 * 
 * @author W_STALIN
 * 
 * Time Complexity = O(n^2) 
 * 		This ArrayList for searching .contains() and to get the .indexOf() method takes O(n) complexity whereas the regular iteration also takes O(n). 
 * 		Together it takes O(n^2).
 * Space Complexity = O(1)
 * 		Here we didn't take any extra space such as an array to store. So, the space complexity is O(1).
 * 
 */

public class Question2 { 

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		List<Integer> arrList = new ArrayList<>();
		int input = 0;
		while((input=ob.nextInt())!=-1) {
			arrList.add(input);
		}
		int target = ob.nextInt();
		for(int i=0;i<arrList.size();i++) {
			int temp = arrList.get(i);			
			if(arrList.contains(target-temp)) {
				int j =arrList.indexOf(target-temp);
				if(i>j)
					continue;
				int temp2 = arrList.remove(j);
				arrList.add(i+1,temp2);
				i++;
			}
		}
		for(int i=0;i<arrList.size();i++) {
			System.out.print(arrList.get(i)+" ");
		}
		ob.close();
	}

}

//for(int j=i+1;j<arrList.size();j++) {
//if(arrList.get(j)+temp==target) {
//	int temp2 = arrList.remove(j);
//	arrList.add(i+1,temp2);
//	i++;
//	break;
//}
//}
