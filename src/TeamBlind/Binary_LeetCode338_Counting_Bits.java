package TeamBlind;

public class Binary_LeetCode338_Counting_Bits {

	public static void main(String[] args) {

	}

	/**
	 * @author sunny
	 * @param num
	 * @return
	 */
	public int[] countBits(int num) {
		int result[] = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			result[i] = countOnes(i);
		}
		return result;
	}

	int countOnes(int num) {
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

}
