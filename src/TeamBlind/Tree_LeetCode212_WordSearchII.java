package TeamBlind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tree_LeetCode212_WordSearchII {

	/**
	 * @author sunny
	 * @param args
	 */
	public static void main(String[] args) {
		char board[][] = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String words[] = new String[] { "oath", "pea", "eat", "rain" };
		Tree_LeetCode212_WordSearchII ob = new Tree_LeetCode212_WordSearchII();
		//System.out.println(ob.findWords(board, words));
		
		
		board = new char[][] { {'a', 'b'},{'a','a'} };
		words = new String[] {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		System.out.println(ob.findWords(board, words));
		

	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		Set<Character> firstChars = new HashSet<>();
		for (String word : words) {
			root.insert(word);
			firstChars.add(word.charAt(0));
		}
		Set<String> results = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (firstChars.contains(board[i][j])) {
					boolean visited[][] = new boolean[board.length][board[0].length];
					dfs(board,String.valueOf(board[i][j]), i, j, root, results, visited);
				}

			}
		}
		return new ArrayList<String>(results);

	}

	int dir[][] = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static class Node {
		String word;
		int i;
		int j;

		public Node(String word, int i, int j) {
			this.word = word;
			this.i = i;
			this.j = j;
		}
	}
		
	void dfs(char[][] board, String temp, int x, int y, Trie tra, Set<String> results,
			boolean[][] visited) {
		char ch  = board[x][y];
		if (null != tra && tra.map.containsKey(ch)) {
			if (tra.map.get(ch).isWord)
				results.add(temp.toString());
			for (int p = 0; p < dir.length; p++) {
				int newX = x + dir[p][0];
				int newY = y + dir[p][1];
				if (isSafe(newX, newY, visited)) {
					visited[x][y] = true;
					dfs(board, temp + board[newX][newY], newX, newY, tra.map.get(ch), results, visited);
					visited[x][y] = false;
				}
			}
		}
		else {
			return;
		}
	}
	

	private boolean isSafe( int i, int j, boolean visited[][]) {
		if (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && !visited[i][j]) {
			return true;
		}
		return false;
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
