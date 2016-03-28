package learning.datastructures.recursion;

import java.util.Arrays;

public class Anagrams {
	
	char [] anaWord;
	int nSize;
	
	public Anagrams(int n){
		anaWord = new char[n];
		nSize = n;
	}
	
	private void displayAnagram(){
		for (int i = 0; i < nSize; ++i)
			System.out.print(anaWord[i]);
		System.out.println();
	}
	
	public void doAnagram(String anaStr){
		char[] chLetters = anaStr.toCharArray();
		doAnagram(nSize, chLetters);
	}
	
	private void doAnagram(int n, char[] letters){
		if (n == 1){
			anaWord[nSize-n] = letters[0];
			displayAnagram();
		}else{
			char[] newLetters = new char[n - 1];
			for (int i = 0; i < n; ++i){
				anaWord[nSize-n] = letters[i];
				int j = 0;
				while (j < i){
					newLetters[j] = letters[j];
					++j;
				}
				++j;
				while (j < n){
					newLetters[j-1] = letters[j];
					++j;
				}
				doAnagram(n-1, newLetters);
			}
		}
	}
	
	public void doAnagram2(String anaStr){
		char[] chLetters = anaStr.toCharArray();
		Arrays.sort(chLetters);
		doAnagram2(nSize, chLetters);
	}
	
	private void doAnagram2(int n, char[] letters){
		if (n == 1){
			anaWord[nSize-n] = letters[0];
			displayAnagram();
		}else{
			char[] newLetters = new char[n - 1];
			for (int i = 0; i < n; ++i){
				if (i > 0 && letters[i] == letters[i - 1])
					continue;
				anaWord[nSize-n] = letters[i];
				int j = 0;
				while (j < i){
					newLetters[j] = letters[j];
					++j;
				}
				++j;
				while (j < n){
					newLetters[j-1] = letters[j];
					++j;
				}
				doAnagram2(n-1, newLetters);
			}
		}
	}
	
	public static void main(String[] args){
		Anagrams ana = new Anagrams(7);
		ana.doAnagram2("teacher");
	}

}
