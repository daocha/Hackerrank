package hackerrank.algorithm;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Lauren has a chart of distinct projected prices for a house over the next
 * years, where the price of the house in the year is . She wants to purchase
 * and resell the house at a minimal loss according to the following rules:
 * 
 * The house cannot be sold at a price greater than or equal to the price it was
 * purchased at (i.e., it must be resold at a loss). The house cannot be resold
 * within the same year it was purchased. Find and print the minimum amount of
 * money Lauren must lose if she buys the house and resells it within the next
 * years.
 * 
 * Note: It's guaranteed that a valid answer exists.
 * 
 * Input Format
 * 
 * The first line contains an integer, , denoting the number of years of house
 * data. The second line contains space-separated long integers describing the
 * respective values of .
 * 
 * Constraints
 * 
 * All the prices are distinct. It's guaranteed that a valid answer exists.
 * Subtasks
 * 
 * for of the maximum score. Output Format
 * 
 * Print a single integer denoting the minimum amount of money Lauren must lose
 * if she buys and resells the house within the next years.
 * 
 * Sample Input 0
 * 
 * 3 5 10 3 Sample Output 0
 * 
 * 2 Explanation 0
 * 
 * Lauren buys the house in year at price and sells it in year at for a minimal
 * loss of .
 * 
 * Sample Input 1
 * 
 * 5 20 7 8 2 5 Sample Output 1
 * 
 * 2 Explanation 1
 * 
 * Lauren buys the house in year at price and sells it in year at for a minimal
 * loss of .
 * 
 * <p>
 * https://www.hackerrank.com/challenges/minimum-loss/problem
 * 
 * @author Ray
 * @date 2017-07-06
 *
 */

public class MinimumLoss {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] prices = new long[n];
		TreeMap<Long, Integer> pricesMap = new TreeMap<Long, Integer>();
		for (int i = 0; i < n; i++) {
			pricesMap.put(scan.nextLong(), i + 1);
		}

		TreeSet<Long> diffMap = new TreeSet<Long>();

		Iterator<Long> iterator = pricesMap.keySet().iterator();
		Long minPrice = iterator.next();
		Integer minYr = pricesMap.get(minPrice);
		while (iterator.hasNext()) {
			Long price = iterator.next();
			Integer yr = pricesMap.get(price);
			if (yr < minYr) {
				Long diff = price - minPrice;
				diffMap.add(diff);
			}

			minPrice = price;
			minYr = yr;
		}

		System.out.println(diffMap.first());
	}
}