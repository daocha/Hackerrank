package hackerrank.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * [Facebook Question]
 * 
 * Determine if any 3 integers in an array sum to 0. Example: given the array [
 * 6, -2, 5, -4, 9 ], answer is 6, -2, -4.
 * 
 * @author Ray LI
 * @date Nov 10, 2017
 * @contact ray@daocha.me
 */
public class ThreeSum {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(-2);
		list.add(5);
		list.add(-4);
		list.add(9);

		ArrayList<Integer> result = findSum(list);
		System.out.println(result);

		ArrayList<Integer> result2 = findSum2(list);
		System.out.println(result2);

	}

	public static ArrayList<Integer> findSum(ArrayList<Integer> inputlist) {

		ArrayList<Integer> list = new ArrayList<Integer>(inputlist);

		Collections.sort(list);

		if (list.size() < 3) {
			// invalid input
			return null;
		}

		ArrayList<Integer> result = null;

		for (int i = 0; i < list.size() - 2; i++) {
			int num1 = list.get(i);

			int left = i + 1;

			int right = list.size() - 1;

			while (left < right) {
				int num2 = list.get(left);
				int num3 = list.get(right);
				if (num1 + num2 + num3 == 0) {
					result = new ArrayList<Integer>();
					result.add(num1);
					result.add(num2);
					result.add(num3);
					return result;
				} else if (num1 + num2 + num3 < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}

	public static ArrayList<Integer> findSum2(ArrayList<Integer> list) {

		if (list.size() < 3) {
			// invalid input
			return null;
		}

		ArrayList<Integer> result = null;
		int expectedSum = 0;

		for (int i = 0; i < list.size() - 2; i++) {
			int num1 = list.get(i);

			int residual = expectedSum - num1;

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int k = i + 1; k < list.size(); k++) {
				int num2 = list.get(k);

				// means this number + previous number match the expected sum
				if (map.containsKey(num2)) {
					result = new ArrayList<Integer>();

					// the fixed number in the outer loop
					result.add(num1);

					// previous number
					result.add(map.get(num2));

					// current number
					result.add(num2);

					return result;
				} else {
					map.put(residual - num2, num2);
				}
			}

		}

		return result;
	}
}
