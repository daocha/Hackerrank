package hackerrank.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Convert int to English words
 * 
 * @author daocha
 *
 */
public class ToEnglish {

	public static void main(String[] args) {

		System.out.println(toEng(123));
		System.out.println(toEng(-123));
		System.out.println(toEng(456));
		System.out.println(toEng(4523236));
		System.out.println(toEng(4523000));
		System.out.println(toEng(452323926));
		System.out.println(toEng(1452323926));

	}

	private static String toEng(int num) {
		Map<Integer, String> dict = getDictionary();
		StringBuilder sb = new StringBuilder();
		if (num < 0) {
			sb.append("Negative");
			sb.append(" ");
		}

		num = Math.abs(num);

		if (num < 1000) {
			int hundreds = num / 100;
			if (hundreds > 0) {
				sb.append(dict.get(hundreds));
				sb.append(" ");
				sb.append(dict.get(100));
				sb.append(" ");
			}

			int tens = (num % 100) / 10 * 10;
			if (tens < 2) {
				sb.append(dict.get(num % 100));
				sb.append(" ");
			} else {
				int tens_remaining = num % 100 % 10;
				sb.append(dict.get(tens));
				sb.append(" ");
				sb.append(dict.get(tens_remaining));
				sb.append(" ");
			}
		} else {
			List<Integer> loopingnums = new ArrayList<>();
			loopingnums.add(1000000000);
			loopingnums.add(1000000);
			loopingnums.add(1000);

			int movingnum = num;
			for (Integer loopingnum : loopingnums) {
				int multiplier = movingnum / loopingnum;

				System.out.println("multiplier=" + multiplier);

				if (multiplier == 0) {
					continue;
				}

				if (dict.get(multiplier) == null) {
					sb.append(toEng(multiplier));
					sb.append(dict.get(loopingnum));
					sb.append(" ");
				} else {
					sb.append(dict.get(multiplier));
					sb.append(" ");
					sb.append(dict.get(loopingnum));
					sb.append(" ");
				}
				movingnum = movingnum % loopingnum;
			}

			if (movingnum > 0 && dict.get(movingnum) == null) {
				sb.append(toEng(movingnum));
			} else if (movingnum > 0) {
				sb.append(dict.get(movingnum));
			}
		}

		return sb.toString();

	}

	private static Map<Integer, String> getDictionary() {
		Map<Integer, String> dict = new HashMap<Integer, String>();
		dict.put(1, "One");
		dict.put(2, "Two");
		dict.put(3, "Three");
		dict.put(4, "Four");
		dict.put(5, "Five");
		dict.put(6, "Six");
		dict.put(7, "Seven");
		dict.put(8, "Eight");
		dict.put(9, "Nine");
		dict.put(10, "Ten");
		dict.put(11, "Eleven");
		dict.put(12, "Twelve");
		dict.put(13, "Thirteen");
		dict.put(14, "Fourteen");
		dict.put(15, "Fifteen");
		dict.put(16, "Sixteen");
		dict.put(17, "Seventeen");
		dict.put(18, "Eighteen");
		dict.put(19, "Nineteen");
		dict.put(20, "Twenty");
		dict.put(30, "Thirty");
		dict.put(40, "Forty");
		dict.put(50, "Fifty");
		dict.put(60, "Sixty");
		dict.put(70, "Seventy");
		dict.put(80, "Eighty");
		dict.put(90, "Ninty");
		dict.put(100, "Hundred");
		dict.put(1000, "Thousand");
		dict.put(1000000, "Million");
		dict.put(1000000000, "Billion");
		return dict;
	}

}
