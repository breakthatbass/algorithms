/*
 * binomial distribution. estimate the number of recursive calls that would be
 * used bby the code below to compute binomial(100, 50, 0.25). develop a better
 * implementation that is based on saving computed values in an array.
*/
public class ex27 
{
	static double cache[][];
	static int count = 0;

	public static double binomial(int n, int k, double p)
	{
		count++;
		System.out.println(count);
		if ((n == 0) && (k == 0)) return 1.0;
		if ((n < 0) || (k < 0)) return  0.0;
		if (cache[n][k] == -1) {
			cache[n][k] = (1 - p)*binomial(n-1, k, p) + p*binomial(n-1, k-1, p);
		}

		return cache[n][k];
	}

	public static void main(String[] args)
	{
		cache = new double[101][51];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				cache[i][j] = -1;
			}
		}
		double n = binomial(100, 50, 0.25);
		System.out.println(n);
	}
}
