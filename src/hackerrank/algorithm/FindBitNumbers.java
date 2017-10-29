package hackerrank.algorithm;

/**
 * [Facebook Question]
 * 
 * Write a function that takes an unsigned integer and returns the number of 1
 * bits it has.
 * 
 * Example:
 * 
 * The 32-bit integer 11 has binary representation
 * 
 * 00000000000000000000000000001011 
 * 
 * so the function should return 3.
 * 
 * Note that since Java does not have unsigned int, use long for Java
 * 
 * 
 * @author Ray LI
 * @date Oct 29, 2017
 * @contact ray@daocha.me
 */
public class FindBitNumbers {

	public static void main(String[] args) {
		System.out.println("Input: " + 11 + ", num of bits: " + getBitNumber(11));
		System.out.println("Input: " + 17 + ", num of bits: " + getBitNumber(17));
		System.out.println("Input: " + 32 + ", num of bits: " + getBitNumber(32));
		System.out.println("Input: " + 0 + ", num of bits: " + getBitNumber(0));
	}
	
	private static int getBitNumber(long n) {
		int count  = 0;
		while(n >= 2) {
			if(n%2 > 0) {
				count++;
				n -= n%2;
			}else {
				n /= 2;
			}
		}
		if(n > 0) {
			count++;
		}
		return count;
	}
	
}
