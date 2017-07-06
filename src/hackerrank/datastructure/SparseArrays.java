package hackerrank.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * There is a collection of strings ( There can be multiple occurences of a
 * particular string ). Each string's length is no more than characters. There
 * are also queries. For each query, you are given a string, and you need to
 * find out how many times this string occurs in the given collection of
 * strings.
 * 
 * Input Format
 * 
 * The first line contains , the number of strings. The next lines each contain
 * a string. The nd line contains , the number of queries. The following lines
 * each contain a query string.
 * 
 * Constraints
 * 
 * 
 * 
 * 
 * 
 * Sample Input
 * 
 * 4 aba baba aba xzxb 3 aba xzxb ab Sample Output
 * 
 * 2 1 0 Explanation
 * 
 * Here, "aba" occurs twice, in the first and third string. The string "xzxb"
 * occurs once in the fourth string, and "ab" does not occur at all.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 * 
 * 
 * @author Ray
 * @date 2017-07-06
 *
 */
public class SparseArrays {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int strings = Integer.parseInt(scan.nextLine());
		HashMap<String, Integer> strCount = new HashMap<String, Integer>();
		for (int i = 0; i < strings; i++) {
			String string = scan.nextLine();
			Integer count = strCount.get(string);
			if (count == null) {
				count = 0;
			}
			count++;
			strCount.put(string, count);
		}

		int queries = Integer.parseInt(scan.nextLine());
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < queries; i++) {
			String query = scan.nextLine();
			if (strCount.get(query) != null) {
				result.add(strCount.get(query));
			} else {
				result.add(0);
			}
		}
		for (Integer res : result) {
			System.out.println(res);
		}
	}
}
