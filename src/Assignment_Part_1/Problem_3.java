package Assignment_Part_1;

public class Problem_3 {

	public static void main(String[] args) {
		int arr[]= { 20, 52, 400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 20 };
		int smallestValue = Integer.MAX_VALUE, bigValue = Integer.MIN_VALUE, smallStartIndex=0, smallEndIndex=0, bigStartIndex=0, bigEndIndex=0;		
		for(int i=0;i<arr.length-1;i++) {
			if(Math.abs(arr[i]-arr[i+1])<smallestValue) {
				smallestValue = Math.abs(arr[i]-arr[i+1]);
				smallStartIndex = i;
				smallEndIndex = i+1;
			} 
			if(Math.abs(arr[i]-arr[i+1])>bigValue) {
				bigValue = Math.abs(arr[i]-arr[i+1]);
				bigStartIndex = i;
				bigEndIndex = i+1;
			}
		}
		System.out.println("The two conductive indices with smallest difference between their values are: index " + smallStartIndex + 
				" and index "+smallEndIndex+", storing values "+arr[smallStartIndex]+" and "+arr[smallEndIndex]+". ");
		System.out.println("The two conductive indices with largest difference between their values are: index " + bigStartIndex + 
				" and index "+bigEndIndex+", storing values "+arr[bigStartIndex]+" and "+arr[bigEndIndex]+". ");
	}

}
