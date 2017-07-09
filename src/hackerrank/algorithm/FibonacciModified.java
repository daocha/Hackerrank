package hackerrank.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * We define a modified Fibonacci sequence using the following definition:
 * 
 * Given terms and where , term is computed using the following relation: For
 * example, if term and , term , term , term , and so on.
 * 
 * Given three integers, , , and , compute and print term of a modified
 * Fibonacci sequence.
 * 
 * Note: The value of may far exceed the range of a -bit integer. Many
 * submission languages have libraries that can handle such large results but,
 * for those that don't (e.g., C++), you will need to be more creative in your
 * solution to compensate for the limitations of your chosen submission
 * language.
 * 
 * Input Format
 * 
 * A single line of three space-separated integers describing the respective
 * values of , , and .
 * 
 * Constraints
 * 
 * may far exceed the range of a -bit integer. Output Format
 * 
 * Print a single integer denoting the value of term in the modified Fibonacci
 * sequence where the first two terms are and .
 * 
 * Sample Input
 * 
 * 0 1 5 Sample Output
 * 
 * 5 Explanation
 * 
 * The first two terms of the sequence are and , which gives us a modified
 * Fibonacci sequence of . Because , we print term , which is .
 * 
 * <p>
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 * 
 * @author Ray LI
 * @date 9 Jul 2017
 * @contact ray@daocha.me
 */
public class FibonacciModified {
	static int t1;
	static int t2;

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner scan = new Scanner(System.in);
		t1 = scan.nextInt();
		t2 = scan.nextInt();
		int n = scan.nextInt();
		scan.close();
		System.out.println(fib(n));
	}

	static BigInteger fib(int i) {
		if (i == 1) {
			return BigInteger.valueOf(t1);
		} else if (i == 2) {
			return BigInteger.valueOf(t2);
		}

		return fib(i - 2).add(fib(i - 1).pow(2));
	}

	private void privatgeMethod() {

	}

	protected void protectedMethod() {

	}

	void nomodifier() {

	}

	public static void staticMethod() {

	}
}
