package Assignment_Part_1;

public class Problem_2 {

	public static void main(String[] args) {
		String str = "gggN@@@@@KKeeeeggjjjjjdsmmu";
		String output = "";
		int count = 1;
		char strChar = str.charAt(0);
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)==strChar) {
				count++;
			} else {
				output+=strChar+""+(count>1?count:"");
				strChar = str.charAt(i);
				count = 1;
			}
		}
		output+=strChar+""+(count>1?count:"");
		System.out.println(str);
		System.out.println(output);
	}

}
