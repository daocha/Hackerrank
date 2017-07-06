package hackerrank.algorithm;

import java.util.Scanner;

/**
 * 
 * Array A contains the elements, A1,A2...AN. And array B contains the elements,
 * B1,B2...BN. There is a relationship between Ai and Bi, ∀ 1 ≤ i ≤ N, i.e., any
 * element Ai lies between 1 and Bi.
 * 
 * Let the cost S of an array A be defined as:
 * 
 * You have to print the largest possible value of S = sum(|Ai - Ai-1|)
 * 
 * Input Format
 * 
 * The first line contains, T, the number of test cases. Each test case contains
 * an integer, N, in first line. The second line of each test case contains N
 * integers that denote the array B.
 * 
 * Constraints
 * 
 * 1 ≤ T ≤ 20 1 ≤ N ≤ 105 1 ≤ Bi ≤ 100
 * 
 * Output Format
 * 
 * For each test case, print the required answer in one line.
 * 
 * Sample Input
 * 
 * 1 5 10 1 10 1 10 Sample Output
 * 
 * 36 Explanation
 * 
 * The maximum value occurs when A1=A3=A5=10 and A2=A4=1.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-cost/problem
 * 
 * @author Ray
 * @date Jul 6, 2017
 * @contact ray@daocha.me
 *
 */
public class SherlockAndCost {
	/**
	 * Complexity: : O(N)
	 **/
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int T = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(scan.nextLine());

			long[] b = new long[N];
			String[] s = scan.nextLine().split(" ");
			for (int j = 0; j < N; j++) {
				b[j] = Long.parseLong(s[j]);
			}

			/**
			 * Ai has two possibilities : Bi or 1 <br>
			 * assume:<br>
			 * A[0][0] is B0 <br>
			 * A[1][0] is 1
			 */

			long[][] sumA = new long[2][N];
			sumA[0][0] = 0L;
			sumA[1][0] = 0L;
			for (int j = 1; j < N; j++) {
				long sum1 = sumA[0][j - 1] + Math.abs(b[j] - b[j - 1]);
				long sum2 = sumA[0][j - 1] + Math.abs(1 - b[j - 1]);

				long sum3 = sumA[1][j - 1] + Math.abs(b[j] - 1);
				long sum4 = sumA[1][j - 1] + Math.abs(1 - 1);

				sumA[0][j] = Math.max(sum1, sum3);

				sumA[1][j] = Math.max(sum2, sum4);

			}

			System.out.println(Math.max(sumA[0][N - 1], sumA[1][N - 1]));

		}

		scan.close();

	}
}
