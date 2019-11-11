package TeamBlind;

import java.util.HashMap;
import java.util.Map;

public class Tree_LeetCode208_Design_Trie_PrefixTree {
	/**
	 * @author sunny
	 */

	public static void main(String[] args) {

		Trie obj = new Trie();
		obj.insert("abcdghi");
		System.out.println(obj);
		obj.insert("abcdef");
		System.out.println(obj);
		boolean param_2 = obj.search("abcdghi");
		boolean param_3 = obj.startsWith("abcde");

		System.out.println(param_2);
		System.out.println(param_3);

	}

	static class Trie {
		@Override
		public String toString() {
			return "Trie [isWord=" + isWord + ", map=" + map + "]";
		}

		boolean isWord;
		Map<Character, Trie> map = new HashMap<Character, Trie>();

		public Trie() {
			isWord = false;
		}

		public Trie(boolean isWord) {
			this.isWord = isWord;
		}

		public void insert(String word) {
			if (word != null && word.trim().length() != 0) {
				Trie ptr = this;
				word = word.trim();
				int i = 0;
				for (i = 0; i < word.length(); i++) {
					char ch = word.charAt(i);
					if (i == word.length() - 1)
						ptr.map.putIfAbsent(ch, new Trie(true));
					else
						ptr.map.putIfAbsent(ch, new Trie());
					ptr = ptr.map.get(ch);

				}
				ptr.isWord = true;
			}
		}

		public boolean search(String word) {
			Trie ptr = this;
			if (word == null || word.trim().length() == 0)
				return false;
			word = word.trim();
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (!ptr.map.containsKey(ch)) {
					return false;
				}
				ptr = ptr.map.get(ch);
				if (i == word.length() - 1 && ptr.isWord) {
					return true;
				}
			}
			return false;
		}

		public boolean startsWith(String prefix) {
			Trie ptr = this;
			if (prefix == null || prefix.trim().length() == 0)
				return false;
			prefix = prefix.trim();
			for (int i = 0; i < prefix.length(); i++) {
				char ch = prefix.charAt(i);
				if (!ptr.map.containsKey(ch)) {
					return false;
				}
				ptr = ptr.map.get(ch);
			}
			return true;

		}
	}
}
