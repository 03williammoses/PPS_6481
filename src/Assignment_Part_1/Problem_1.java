package Assignment_Part_1;
import java.util.Arrays;

public class Problem_1 {
	
	public static void main(String ar[]) {
		int arr[]= {1, 2, 3, 4};
		
		System.out.println(Arrays.toString(arr)); 
		if(arr.length>3) {
			
			int mid = (arr.length/2)%2==0?arr.length/2:arr.length/2+1;

			int midPlusOne = (arr.length-mid)%2==0?mid:mid+1;
			
			for(int i=0;i<mid;i+=2) {
				arr[i]=arr[i]+arr[i+1]-(arr[i+1]=arr[i]);
			}
			
			for(int i= midPlusOne;i<arr.length;i+=2) {
				arr[i+1]+=arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
