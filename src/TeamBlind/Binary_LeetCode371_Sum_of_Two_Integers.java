package TeamBlind;

public class Binary_LeetCode371_Sum_of_Two_Integers {

	/**
	 * @author sunny
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	int getSum(int a, int b) {
		return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
	}
}
