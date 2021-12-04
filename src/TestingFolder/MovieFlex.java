package TestingFolder;

import java.util.Scanner;

class MovieHT{
	
	class MovieList{
		
		class MovieNode{
			String movieName;
			MovieNode next;
			MovieNode(){

			}
			MovieNode(String name,MovieNode pointer){
				movieName=name;
				next=pointer;
			}
			
		}//end of MovieNode class
		
		MovieNode head=null;
		MovieNode tail=null;
		
		public void AddToStart(String name) {
			if(head==null) {
				MovieNode head = new MovieNode(name,null);
				return;
			}
			MovieNode n = new MovieNode(name,head);
			head=n;
			n=null;	
			return;
		}
		
		public void AddAtEnd(String name) {
			if(head==null) {
				MovieNode head= new MovieNode(name,null);
				return;
			}
			MovieNode temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			MovieNode n = new MovieNode(name,null);
			temp.next=n;
			n=null;
			return;
		}
		
		public void displayContents() {
			if(head==null) {
				System.out.println("empty");
				return;
			}
			else {
				MovieNode temp = head;
				while(temp!=null) {
					System.out.print(temp.movieName+",");
					temp=temp.next;
				}
			}
			return;
		}
		public int size() {
			if(head==null) {
				return 0;
			}
			else {
				int ctr=0;
				MovieNode temp=head;
				while(temp!=null) {
					ctr++;
					temp=temp.next;
				}
				return ctr;
			}
		}
		public boolean contains(String name) {
			if(head==null) {
				return false;
			}
			else {
				MovieNode temp=head;
				while(temp!=null && !temp.movieName.equals(name)) {
					temp=temp.next;
				}
				if(temp==null) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		
	}//end of MovieList class
	
	MovieList[] movieArr = new MovieList[13];
	
	/*for(int i=0;i<13;i++) {
		movieArr[i]= new MovieList();
	}*/
	
	public int ComputeHashValue(String name) {
		int length=name.length();
		String six_ltr="";
		if(length>=6) {
			six_ltr=name.substring(0,6);
		}
		else if(length<6) {
			six_ltr=name.substring(0,length);
			}		
		 int hashCode=0;
		 int z=3;
		int i=six_ltr.length();
		int j=0;
		 while(j<i) {
			 hashCode+= (int)(six_ltr.charAt(j))*Math.pow(z,j);
			 j++;
		 }
		 return hashCode%13;	 
		
	}
	 
	public void insertMovie(String name) {
		int hv=ComputeHashValue(name);
		//System.out.println(hv);
		int i=hv;
		if(movieArr[i]==null) {
			MovieList ml = new MovieList();
			ml.AddToStart(name);
			movieArr[hv]=ml;
			//movieArr[i].head=ml.head;
			return;
			}

		else {
				if(!movieArr[i].contains(name)) {
					movieArr[i].AddToStart(name);
				}
				else {
					System.out.println("movie already exists");
				}
				return;
		}
	}
	
	public void showHashTableContents() {
		for(int i=0;i<13;i++) {
			System.out.println("index "+i+" has");
			//if(movieArr[i]
			movieArr[i].displayContents();
			int size=movieArr[i].size();
			System.out.println(size+" collisions");
		}
	}
	
}// end of MovieHT class

public class MovieFlex {
	public static void main(String args[]) {
	MovieHT mht1 = new MovieHT();
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Add movies to MovieFlex, enter \"DONE!\" to terminate");
	
	String s = sc.next();
	
	while(!s.equals("DONE!")) {
		mht1.insertMovie(s);
		s=sc.next();
	}
	System.out.println("==========");
	mht1.showHashTableContents();
	
	sc.close();
	}

}
