package hackerrank.algorithm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Sherlock considers a string, , to be valid if either of the following
 * conditions are satisfied:
 * 
 * All characters in have the same exact frequency (i.e., occur the same number
 * of times). For example, is valid, but is not valid. Deleting exactly
 * character from will result in all its characters having the same frequency.
 * For example, and are valid because all their letters will have the same
 * frequency if we remove occurrence of c, but is not valid because we'd need to
 * remove characters. Given , can you determine if it's valid or not? If it's
 * valid, print YES on a new line; otherwise, print NO instead.
 * 
 * Input Format
 * 
 * A single string denoting .
 * 
 * Constraints
 * 
 * String consists of lowercase letters only (i.e., [a-z]). Output Format
 * 
 * Print YES if string is valid; otherwise, print NO instead.
 * 
 * Sample Input 0
 * 
 * aabbcd Sample Output 0
 * 
 * NO Explanation 0
 * 
 * We would need to remove two characters from to make it valid, because a and b
 * both have a frequency of and c and d both have a frequency of . This means is
 * invalid because we'd need to remove more than character to make all its
 * letters have the same frequency, so we print NO as our answer.
 * 
 * <p>
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * 
 * 
 * @author Ray
 * @date Jul 6, 2017
 * @contact ray@daocha.me
 *
 */
public class SherlockAndTheValidString {
	static int[] getMinMaxFreq(HashMap<Character, Integer> freqMap) {
		int min_freq = 0;
		int max_freq = 0;
		for (Character letter : freqMap.keySet()) {
			Integer freq = freqMap.get(letter);

			if (min_freq == 0) {
				min_freq = freq;
			}

			if (max_freq == 0) {
				max_freq = freq;
			}

			if (freq < min_freq) {
				min_freq = freq;
			} else if (freq > max_freq) {
				max_freq = freq;
			}
		}

		return new int[] { min_freq, max_freq };
	}

	static String isValid(String s) {
		// Complete this function

		HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer freq = freqMap.get(c);
			if (freq == null) {
				freq = 0;
			}
			freq++;
			freqMap.put(c, freq);
		}

		int[] minMaxFreq = getMinMaxFreq(freqMap);

		boolean isvalid = false;
		if (minMaxFreq[0] == minMaxFreq[1]) {
			isvalid = true;
		} else {

			// delete from max
			{
				HashMap<Character, Integer> cloneMap = (HashMap<Character, Integer>) freqMap.clone();
				for (Character letter : cloneMap.keySet()) {
					Integer _freq = cloneMap.get(letter);
					if (_freq == minMaxFreq[1]) {
						if (_freq - 1 == 0) {
							cloneMap.remove(letter);
						} else {
							cloneMap.put(letter, _freq - 1);
						}
						break;
					}
				}

				int[] minMaxFreq2 = getMinMaxFreq(cloneMap);

				if (minMaxFreq2[0] == minMaxFreq2[1]) {
					isvalid = true;
				} else {
					isvalid = false;
				}
			}

			// delete from min
			if (!isvalid) {
				HashMap<Character, Integer> cloneMap = (HashMap<Character, Integer>) freqMap.clone();
				for (Character letter : cloneMap.keySet()) {
					Integer _freq = cloneMap.get(letter);
					if (_freq == minMaxFreq[0]) {

						if (_freq - 1 == 0) {
							cloneMap.remove(letter);
						} else {
							cloneMap.put(letter, _freq - 1);
						}
						break;
					}
				}

				int[] minMaxFreq2 = getMinMaxFreq(cloneMap);

				if (minMaxFreq2[0] == minMaxFreq2[1]) {
					isvalid = true;
				} else {
					isvalid = false;
				}
			}

		}

		return isvalid ? "YES" : "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = isValid(s);
		System.out.println(result);
	}
}
