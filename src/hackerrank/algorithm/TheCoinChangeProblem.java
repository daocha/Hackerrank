package hackerrank.algorithm;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * You have types of coins available in infinite quantities where the value of
 * each coin is given in the array . Can you determine the number of ways of
 * making change for units using the given types of coins? For example, if , and
 * , we can make change for units in three ways: , , and .
 * 
 * Given , , and , print the number of ways to make change for units using any
 * number of coins having the values given in .
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers describing the
 * respective values of and . The second line contains space-separated integers
 * describing the respective values of (the list of distinct coins available in
 * infinite amounts).
 * 
 * Constraints
 * 
 * Each is guaranteed to be distinct. Hints
 * 
 * Solve overlapping subproblems using Dynamic Programming (DP): You can solve
 * this problem recursively but will not pass all the test cases without
 * optimizing to eliminate the overlapping subproblems. Think of a way to store
 * and reference previously computed solutions to avoid solving the same
 * subproblem multiple times. Consider the degenerate cases: How many ways can
 * you make change for cents? How many ways can you make change for cents if you
 * have no coins? If you're having trouble defining your solutions store, then
 * think about it in terms of the base case . The answer may be larger than a
 * -bit integer. Output Format
 * 
 * Print a long integer denoting the number of ways we can get a sum of from the
 * given infinite supply of types of coins.
 * 
 * Sample Input 0
 * 
 * 4 3 1 2 3 Sample Output 0
 * 
 * 4 Explanation 0
 * 
 * There are four ways to make change for using coins with values given by :
 * 
 * Thus, we print as our answer.
 * 
 * Sample Input 1
 * 
 * 10 4 2 5 3 6 Sample Output 1
 * 
 * 5 Explanation 1
 * 
 * There are five ways to make change for units using coins with values given by
 * :
 * 
 * Thus, we print as our answer.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/coin-change/problem
 * 
 * @author Ray
 * @date Jul 6, 2017
 * @contact ray@daocha.me
 */
public class TheCoinChangeProblem {
	static int getWays(long n, long[] c) {
		// Complete this function
		TreeSet<TreeSet<Long>> ways = new TreeSet<TreeSet<Long>>();
		for (long val : c) {
			if (n % val == 0) {
				TreeSet<Long> group = new TreeSet<Long>();
				for (int i = 0; i < n / val; i++) {
					group.add(val);
				}
				ways.add(group);
			}
		}
		
		return ways.size();
	}

	static

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[] c = new long[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextLong();
		}
		// Print the number of ways of making change for 'n' units using coins
		// having the values given by 'c'
		int ways = getWays(n, c);
	}
}
