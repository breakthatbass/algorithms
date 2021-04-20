/*
 * dice simulation
 *
 * the following code computes the exact probability distribution for the sum of
 * two dice:
 *
 * the value probabilities[k] is the probability that the dice sum to k. run
 * experiments to validate this calculation simulating n dice throws, keeping
 * track of the frequencies of occurance of each value when you compute the sum
 * of two random integers between 1 and 6. how large does n ahev to be before
 * you empiracal results match the exact results to three decimal places?
 *
 * n has to be about 5,000,000 or higher to match the simulation exactly
*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;


public class ex35 
{

	public static double[] random_dice(int n)
	{
		int SIDES = 6;
		double[] dice_throws = new double[2*SIDES+1];

		int d1 = 0;
		int d2 = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			d1 = StdRandom.uniform(1, 7);
			d2 = StdRandom.uniform(1, 7);
			sum = d1+d2;

			dice_throws[sum]++;
		}

		for (int i = 2; i <= (2*SIDES); i++) {
			dice_throws[i] /= n;
		}
		return dice_throws;
	}


	public static double[] dice_sim()
	{
		int SIDES = 6;
		int[] frequencies = new int[2*SIDES+1];
		for (int i = 1; i <= SIDES; i++)
			for (int j= 1; j <= SIDES; j++)
				frequencies[i+j]++;


		double[] probabilities = new double[2*SIDES+1];
		for (int k = 2; k <= 2*SIDES; k++)
			probabilities[k] = frequencies[k]/36.0;

		return probabilities;
	}

	public static void main(String[] args)
	{
		double[] d_sim = dice_sim();
		double[] d_exp = random_dice(5000000);

		for (int i = 1; i < d_sim.length; i++) {
			StdOut.printf("dice sim %d: %.3f\n", i, d_sim[i]);
			StdOut.printf("dice exp %d: %.3f\n", i, d_exp[i]);
			StdOut.printf("\n");
		}
	}
}
