package tower_of_hanoi;

import java.util.Scanner;
import java.util.Stack;

public class Towers {	
	static public Stack<Integer> A = new Stack<Integer>();
	static public Stack<Integer> B = new Stack<Integer>();
	static public Stack<Integer> C = new Stack<Integer>();

	public static void solve2DiscsTOH(Stack<Integer> source,
									Stack<Integer> temp,
									Stack<Integer> dest) {            
		temp.push(source.pop());
		printStacks();
		dest.push(source.pop());
		printStacks();
		dest.push(temp.pop());
		printStacks();
	}

	static public int solveTOH(int nDiscs, Stack<Integer> source,
										Stack<Integer> temp,
										Stack<Integer> dest) {
		if (nDiscs <= 4) {
			if ((nDiscs % 2) == 0) { //if pair number of disks
				solve2DiscsTOH(source, temp, dest);
				nDiscs = nDiscs - 1;
				if (nDiscs == 1)
					return 1;

				temp.push(source.pop());
				printStacks();
				//new source is dest, new temp is source, new dest is temp;
				solve2DiscsTOH(dest, source, temp);
				dest.push(source.pop());
				printStacks();
				//new source is temp, new temp is source, new dest is dest;
				solveTOH(nDiscs, temp, source, dest);
			}
			else {// if impair number of disks
				if (nDiscs == 1)
					return -1;
				solve2DiscsTOH(source, dest, temp);
				nDiscs = nDiscs - 1;
				dest.push(source.pop());
				printStacks();
				solve2DiscsTOH(temp, source, dest);
			}
			return 1;
		}
		else if (nDiscs >= 5) {
			solveTOH(nDiscs - 2, source, temp, dest);
			temp.push(source.pop());
			printStacks();
			solveTOH(nDiscs - 2, dest, source, temp);
			dest.push(source.pop());
			printStacks();
			solveTOH(nDiscs - 1, temp, source, dest);
		}
		return 1;
	}

	static public void printStacks(){
		System.out.println();
		printStack(A);
		System.out.print(" , ");
		printStack(B);
		System.out.print(" , ");
		printStack(C);

	}

	public static void printStack(Stack<Integer> s) {
		System.out.print(s.toString());
	}

	public static void main(String[] args) {
		Scanner input= new Scanner (System.in);
		System.out.print("\nEnter the number of discs: ");

		int discs = input.nextInt();
		if (discs <= 1 || discs >= 10) {
			System.out.println("Please enter between 2 - 12");
		}
		input.close();
		
		for (int i = discs; i >= 1; i--) {
			A.push(i);
		}

		printStacks();
		solveTOH(discs, A, B, C);
		while (C.size() > 0){
			C.pop();
		}
	}
}
