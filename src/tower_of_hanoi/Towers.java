package tower_of_hanoi;

import java.util.Scanner;
import java.util.Stack;

public class Towers {	
	static public Stack<Integer> A = new Stack<Integer>();
	static public Stack<Integer> B = new Stack<Integer>();
	static public Stack<Integer> C = new Stack<Integer>();
	static int count = -1;

	public static void solveTOH(int nums, Stack<Integer> source,
	 									Stack<Integer> temp,
	 									Stack<Integer> dest) {
		if(nums >= 1) {
			solveTOH(nums - 1, source, dest, temp);
			moveDisk(source, dest);
			printStacks();
			solveTOH(nums - 1, temp, source, dest);
		}
	}

	public static void moveDisk(Stack<Integer> source, Stack<Integer> dest) {
		dest.push(source.pop());
	}

	static public void printStacks(){
		printStack(A);
		System.out.print(" , ");
		printStack(B);
		System.out.print(" , ");
		printStack(C);
		count ++;
		System.out.println();
	}

	public static void printStack(Stack<Integer> s) {
		System.out.print(s.toString());
	}

	public static void main(String[] args) {
		Scanner input= new Scanner (System.in);
		System.out.print("\nEnter the number of discs: ");

		int discs = input.nextInt();
		if (discs < 1 || discs > 10) {
			System.out.println("Please enter between 1 - 10");
		}
		input.close();
		
		for (int i = discs; i >= 1; i--) {
			A.push(i);
		}

		printStacks();
		solveTOH(discs, A, B, C);
		System.out.println("Nums of move " + count);
	}
}
