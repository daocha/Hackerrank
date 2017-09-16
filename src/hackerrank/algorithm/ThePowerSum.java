package hackerrank.algorithm;

import java.util.Scanner;

/**
 * Find the number of ways that a given integer, , can be expressed as the sum
 * of the power of unique, natural numbers.
 * 
 * Input Format
 * 
 * The first line contains an integer . The second line contains an integer .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Output a single integer, the answer to the problem explained above.
 * 
 * Sample Input 0
 * 
 * 10 2 Sample Output 0
 * 
 * 1 Explanation 0
 * 
 * If and , we need to find the number of ways that can be represented as the
 * sum of squares of unique numbers.
 * 
 * 
 * This is the only way in which can be expressed as the sum of unique squares.
 * 
 * Sample Input 1
 * 
 * 100 2 Sample Output 1
 * 
 * 3 Explanation 1
 * 
 * 
 * Sample Input 2
 * 
 * 100 3 Sample Output 2
 * 
 * 1 Explanation 2
 * 
 * can be expressed as the sum of the cubes of . . There is no other way to
 * express as the sum of cubes.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 * 
 * 
 * @author Ray LI
 * @date 9 Jul 2017
 * @contact ray@daocha.me
 */
public class ThePowerSum {
	static int count = 0;
	static int rounds = 0;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int i, j, k, x, n;
		x = sc.nextInt();
		n = sc.nextInt();

		sc.close();

		int max_val = (int) (Math.round(Math.pow(x, 1.0 / n) * 100000000) / 100000000.0);

		countsum(max_val, max_val, 0, x, n);

		System.out.println(count);
		System.out.println("rounds=" + rounds);
	}

	public static void countsum(int max_val, int i, int curr_sum, int x, int power) {

		rounds++;
		if (curr_sum == x) {
			count++;
			return;
		} else if (curr_sum > x || i <= 0) {
			return;
		}
		// System.out.println(i);
		countsum(max_val, i - 1, curr_sum, x, power);
		curr_sum = curr_sum + (int) Math.pow(i, power);
		if (curr_sum == x) {
			count++;
			return;
		} else if (curr_sum > x || i - 1 <= 0) {
			return;
		} else {
			countsum(max_val, i - 1, curr_sum, x, power);
		}

	}
}
