package learning.datastructures.recursion;

public class TheTriangle {

	public int getLength(int n){
		int result = 0;
		while (n > 0){
			result += n;
			--n;
		}
		return result;
	}
	
	public int getLengthRecursively(int n){
		if (n > 1)
			return n + getLengthRecursively(n - 1);
		else
			return n;
	}
	
	public static void main(String[] args){
		TheTriangle theTri = new TheTriangle();
		int j, k;
		for (int i = 0; i < 16; ++i){
			j = theTri.getLength(i);
			k = theTri.getLengthRecursively(i);
			if (j == k)
				System.out.println("Triangle side n = " + i + ", value = " + j);
			else
				System.out.println("Error! Triangle side n = " + i + ", value by recursion = " + k + "; by non-recursive method = " + j);
		}
			
	}
}
