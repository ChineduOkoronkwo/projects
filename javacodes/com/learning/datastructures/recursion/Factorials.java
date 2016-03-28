package learning.datastructures.recursion;

public class Factorials {
	
	public static long computeFactorial(long n){
		long result = 1;
		
		for (long i = 1; i <= n; ++ i)
			result *= i;
		return result;
	}
	
	public static long computeFactorialRecursively(long n){
		if (n > 1)
			return n * computeFactorialRecursively(n - 1);
		else
			return 1;
					
	}
	
	public static void main(String[] args){
		long j, k;	
		for (int i = 0; i < 21; ++i){
			j = computeFactorial(i);
			k = computeFactorialRecursively(i);
			if (j == k)
				System.out.println("The factorial of " + i + " is " + j);
			else
				System.out.println("Error! The factorial of " + i + " is " + j + " by non-recursive method and " + k + " by recursive method.");				
		}
	}

}
