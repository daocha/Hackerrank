package hackerrank.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of elements, find the maximum possible sum of a
 * 
 * Contiguous subarray Non-contiguous (not necessarily contiguous) subarray.
 * Empty subarrays/subsequences should not be considered.
 * 
 * Input Format
 * 
 * First line of the input has an integer . cases follow. Each test case begins
 * with an integer . In the next line, integers follow representing the elements
 * of array .
 * 
 * Constraints
 * 
 * The subarray and subsequences you consider should have at least one element.
 * 
 * Output Format
 * 
 * Two, space separated, integers denoting the maximum contiguous and
 * non-contiguous subarray. At least one integer should be selected and put into
 * the subarrays (this may be required in cases where all elements are
 * negative).
 * 
 * Sample Input
 * 
 * 2 4 1 2 3 4 6 2 -1 2 3 4 -5 Sample Output
 * 
 * 10 10 10 11 Explanation
 * 
 * In the first case: The max sum for both contiguous and non-contiguous
 * elements is the sum of ALL the elements (as they are all positive).
 * 
 * In the second case: [2 -1 2 3 4] --> This forms the contiguous sub-array with
 * the maximum sum. For the max sum of a not-necessarily-contiguous group of
 * elements, simply add all the positive elements.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/maxsubarray/problem
 *
 * 
 * @author Ray LI
 * @date 9 Jul 2017
 * @contact ray@daocha.me
 */
public class TheMaximumSubarray {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		while (cases-- > 0) {
			int n = scan.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scan.nextInt();
			}
			scan.close();

			// find continous subarray
			int sum1 = 0;
			int max = 0;
			for (int i = 0; i < n; i++) {
				sum1 += array[i];
				if (sum1 < 0) {
					sum1 = 0;
				}

				if (sum1 > max) {
					max = sum1;
				}
			}

			Arrays.sort(array);
			if (array[n - 1] < 0) {
				System.out.print(array[n - 1]);
			} else {
				System.out.print(max);
			}

			// non-continus subarray
			int sum2 = array[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				if (array[i] > 0) {
					sum2 += array[i];
				}
			}
			System.out.print(" " + sum2 + "\n");
		}
	}
}
