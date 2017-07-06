package hackerrank.algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Hackerland is a one-dimensional city with houses, where each house is located
 * at some on the -axis. The Mayor wants to install radio transmitters on the
 * roofs of the city's houses. Each transmitter has a range, , meaning it can
 * transmit a signal to all houses units of distance away.
 * 
 * Given a map of Hackerland and the value of , can you find and print the
 * minimum number of transmitters needed to cover every house in the city?
 * (Every house must be covered by at least one transmitter) Each transmitter
 * must be installed on top of an existing house.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers describing the
 * respective values of (the number of houses in Hackerland) and (the range of
 * each transmitter). The second line contains space-separated integers
 * describing the respective locations of each house (i.e., ).
 * 
 * Constraints
 * 
 * There may be more than one house at the same location. Subtasks
 * 
 * for of the maximum score. Output Format
 * 
 * Print a single integer denoting the minimum number of transmitters needed to
 * cover all the houses.
 * 
 * Sample Input 0
 * 
 * 5 1 1 2 3 4 5 Sample Output 0
 * 
 * 2 Explanation 0
 * 
 * The diagram below depicts our map of Hackerland:
 * 
 * k-nearest(2).png
 * 
 * We can cover the entire city by installing transmitters on houses at
 * locations and . Thus, we print on a new line.
 * 
 * Sample Input 1
 * 
 * 8 2 7 2 4 6 5 9 12 11 Sample Output 1
 * 
 * 3 Explanation 1
 * 
 * The diagram below depicts our map of Hackerland:
 * 
 * k-nearest2(2).png
 * 
 * We can cover the entire city by installing transmitters on houses at
 * locations , , and . Thus, we print on a new line.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
 * 
 * @author Ray
 * @date Jul 6, 2017
 * @contact ray@daocha.me
 *
 */
public class HackerlandRadioTransmitters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		TreeSet<Integer> houses = new TreeSet<Integer>();
		for (int x_i = 0; x_i < n; x_i++) {
			houses.add(in.nextInt());
		}

		Integer[] x = houses.toArray(new Integer[] {});

		ArrayList<Integer> transmitterIdx = new ArrayList<Integer>();

		int firstOutOfRangeIdx = 0;

		for (int i = 0; i < x.length; i++) {

			int lastTransmitter = transmitterIdx.size() > 0 ? transmitterIdx.get(transmitterIdx.size() - 1) : -1;

			boolean noNext = i == x.length - 1;

			if (lastTransmitter > 0) {
				if (x[i] - x[lastTransmitter] > k && i > 0 && x[i - 1] - x[lastTransmitter] <= k) {
					firstOutOfRangeIdx = i;
				}
				boolean nextHouseCanNotCoverPre = !noNext && x[i + 1] - x[firstOutOfRangeIdx] > k;
				if (x[i] - x[lastTransmitter] > k && (noNext || nextHouseCanNotCoverPre)) {
					transmitterIdx.add(i);
				}
			} else {
				boolean nextHouseCanNotCoverPre = !noNext && x[i + 1] - x[firstOutOfRangeIdx] > k;
				if (noNext || nextHouseCanNotCoverPre) {
					transmitterIdx.add(i);
				}
			}

		}

		System.out.println(houses);

		for (int idx : transmitterIdx) {
			System.out.println(x[idx]);
		}
		System.out.println(transmitterIdx.size());

	}
}
