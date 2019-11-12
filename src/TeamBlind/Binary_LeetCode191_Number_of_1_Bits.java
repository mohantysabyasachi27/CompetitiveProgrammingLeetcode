package TeamBlind;

public class Binary_LeetCode191_Number_of_1_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author sunny
	 * @param args
	 */

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int ones = 0;
		while (n != 0) {
			n = n & (n - 1);
			ones++;
		}
		return ones;
	}

}
