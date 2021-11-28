package LabExercise.Lab8;

import java.util.Scanner;

class MovieHT {

	class MovieList {

		class MovieNode {
			String movieName;
			MovieNode next;

			public MovieNode() {
				this.movieName = null;
				this.next = null;
			}

			public MovieNode(String movieName) {
				this.movieName = movieName;
				this.next = null;
			}

			public MovieNode(String movieName, MovieNode next) {
				this.movieName = movieName;
				this.next = next;
			}
		}

		MovieNode head;
		MovieNode tail;
		int listSize;

		public MovieList() {
			this.head = this.tail = null;
			this.listSize = 0;
		}

		public void AddToStart(String movieName) {
			if (head == null) {
				head = new MovieNode(movieName);
				tail = head;
			} else {
				head = new MovieNode(movieName, head);
			}
			this.listSize++;
		}

		public void AddAtEnd(String movieName) {
			if (head == null) {
				head = new MovieNode(movieName);
				tail = head;
			} else {
				MovieNode temp = new MovieNode(movieName);
				tail.next = temp;
				tail = temp;
			}
			this.listSize++;
		}

		public void displayContent() {
			MovieNode nodeI = head;
			while (nodeI != null) {
				System.out.print(nodeI.next == null ? nodeI.movieName : nodeI.movieName + ",");
				nodeI = nodeI.next;
			}
			System.out.println();
		}

		public int size() {
			return listSize;
		}

		public boolean contains(String movieName) {
			MovieNode nodeI = head;
			while (nodeI != null) {
				if (nodeI.movieName.equals(movieName)) {
					return true;
				}
				nodeI = nodeI.next;
			}
			return false;
		}
	}

	MovieList movieArr[];
	int Z;

	public MovieHT() {
		movieArr = new MovieList[13];
		Z = 3;
		for (int i = 0; i < movieArr.length; i++) {
			movieArr[i] = new MovieList();
		}
	}

	public int computeHashValue(String movieName) {
		int value = 0;
		for (int i = 0; i < movieName.length() && i < 6; i++) {
			value += movieName.charAt(i) * (Math.pow(Z, i));
		}
		return value %= movieArr.length;
	}

	public boolean checkIfAlreadyPresent(String movieName, int i) {
		if (movieArr[i].head != null) {
			MovieList.MovieNode temp = movieArr[i].head;
			while (temp != null) {
				if (temp.movieName.equalsIgnoreCase(movieName)) {
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}

	public void insertMovie(String movieName) {
		int index = computeHashValue(movieName);
		if (!checkIfAlreadyPresent(movieName, index)) {
			movieArr[index].AddToStart(movieName);
		} else {
			System.out.println("movie already exists");
		}
	}

	public void showHashTableContents() {
		for (int i = 0; i < movieArr.length; i++) {
			System.out.println("index " + i + " has");
			int movieSize = movieArr[i].size();

			if (movieSize != 0) {
				movieArr[i].displayContent();
			} else {
				System.out.println("empty");
			}
			System.out.println(movieSize > 1 ? movieSize + " collisions" : 0 + " collisions");
			System.out.println();
		}
	}
}

public class MovieFlex {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		MovieHT mht1 = new MovieHT();
		System.out.println("Add movies to MovieFlex, enter \"DONE!\" to terminate");
		String input = ob.nextLine();
		while (!input.equals("DONE!")) {
			mht1.insertMovie(input);
			input = ob.nextLine();
		}
		System.out.println("==========");
		mht1.showHashTableContents();
		ob.close();
	}

}
