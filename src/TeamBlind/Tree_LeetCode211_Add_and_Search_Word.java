package TeamBlind;

import java.util.HashMap;
import java.util.Map;

public class Tree_LeetCode211_Add_and_Search_Word {

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("at");
		obj.addWord("add");
		obj.addWord("and");
		obj.addWord("an");
		System.out.println(obj.search("a"));
		System.out.println(obj.search(".at"));
		obj.addWord("bat");
		System.out.println(obj.search(".at"));
		System.out.println(obj);
		System.out.println(obj.search(".an."));
		System.out.println(obj.search("a.d."));
		System.out.println(obj.search("b."));
		System.out.println(obj.search("a.d"));
		System.out.println(obj.search("."));
	}

	static class Trie {
		boolean isWord;
		Map<Character, Trie> map = new HashMap<Character, Trie>();

		public Trie(boolean isWord) {
			this.isWord = isWord;
		}

		@Override
		public String toString() {
			return "Trie [isWord=" + isWord + ", map=" + map + "]";
		}

	}

	/**
	 * @author sunny
	 */

	static class WordDictionary {

		@Override
		public String toString() {
			return "WordDictionary [root=" + root + "]";
		}

		Trie root = null;

		/** Initialize your data structure here. */
		public WordDictionary() {
			root = new Trie(false);
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {

			if (word != null && word.trim().length() != 0) {
				Trie ptr = root;
				word = word.trim();
				int i = 0;
				for (i = 0; i < word.length(); i++) {
					char ch = word.charAt(i);
					if (i == word.length() - 1) {
						ptr.map.putIfAbsent(ch, new Trie(true));
						ptr.map.get(ch).isWord = true;
					} else
						ptr.map.putIfAbsent(ch, new Trie(false));

					ptr = ptr.map.get(ch);

				}
			}

		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */
		public boolean search(String word) {
			if (word == null || word.trim().length() == 0)
				return false;

			return searchUtil(word, 0, root);
		}

		public boolean searchUtil(String word, int idx, Trie t) {
			if (word.length() == idx && t.isWord)
				return true;

			if (word.length() == idx && !t.isWord)
				return false;

			if (t == null) {
				return false;
			}

			char ch = word.charAt(idx);
			if (ch == '.') {
				boolean f = false;
				for (Trie n : t.map.values()) {
					f = f || searchUtil(word, idx + 1, n);
				}
				return f;
			}

			return t.map.containsKey(ch) ? searchUtil(word, idx + 1, t.map.get(ch)) : false;

		}

	}

}
