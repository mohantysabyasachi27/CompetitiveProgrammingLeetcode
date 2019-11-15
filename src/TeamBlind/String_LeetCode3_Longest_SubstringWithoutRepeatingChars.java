package TeamBlind;

import java.util.HashMap;
import java.util.Map;

public class String_LeetCode3_Longest_SubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		String_LeetCode3_Longest_SubstringWithoutRepeatingChars ob = new String_LeetCode3_Longest_SubstringWithoutRepeatingChars();
		// System.out.println(ob.lengthOfLongestSubstring("abcabcdecgha"));
		// System.out.println(ob.lengthOfLongestSubstring("tmmzuxt"));
		System.out.println(ob.lengthOfLongestSubstring("abcabcbb"));

	}

	/**
	 * @author sunny
	 * @param string
	 * @return
	 */

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}

		if (s.length() == 1) {
			return 1;
		}

		Map<Character, Integer> dict = new HashMap<>();
		dict.put(s.charAt(0), new Integer(0));
		int i = 0, len = 1, max = 1;
		for (int j = 1; i < s.length() && j < s.length(); j++) {
			char ch = s.charAt(j);
			if (!dict.containsKey(ch)) {
				dict.put(ch, j);
				len++;
				max = Math.max(len, max);
			} else {

				if (dict.get(ch) >= i) {
					i = dict.get(ch) + 1;
				}

				len = j - i + 1;
				max = Math.max(len, max);
				dict.put(ch, j);

			}
		}
		return max;
	}

}
