package TeamBlind;

public class String_LeetCode424_Longest_RepeatingChar_Replacement {

	public static void main(String[] args) {
		String_LeetCode424_Longest_RepeatingChar_Replacement ob = new String_LeetCode424_Longest_RepeatingChar_Replacement();
		
		ob.characterReplacement("AABABBA", 1);
	}

	/**
	 * @author sunny
	 * @param string
	 * @param k max chars to be replaced
	 * @return
	 */

    public int characterReplacement(String s, int k) {
        int[] cArr = new int[26];
        int maxCount = 0, start = 0, maxSize = 0;
        
        for(int end = 0; end < s.length(); end ++){
            cArr[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, cArr[s.charAt(end) - 'A']);
            if(end - start + 1 - maxCount > k){
                cArr[s.charAt(start) - 'A']--;
                start ++;
            }
            maxSize = Math.max(maxSize, end - start + 1);
        }
        return maxSize;
    }

	

}
