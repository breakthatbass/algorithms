/*
 * exercise 1.2.16
 *
 * rational numbers
 * implement an immutable data type Rational for rational numbers that supports
 * addition, subtraction, multiplication, and division.
 *  
 */

public class Rational
{
	private int numerator;
	private int denominator;

	public Rational(int numerator, int denominator)
	{
		if (denominator == 0)
			throw new IllegalArgumentException("deoninator cannot be 0");

		this.numerator = numerator;
		this.denominator = denominator;

		int gcd = gcd(numerator, denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;

	}

	private int gcd(int numerator, int denominator)
	{
		if (denominator == 0)
			return numerator;
		else return gcd(denominator, numerator % denominator);
	}


	public int numerator()
	{
		return numerator;
	}


	public int denominator()
	{
		return denominator;
	}



	public static void main(String[] args)
	{
		Rational n = new Rational(4, 1);

		Rational p = new Rational(8, 4);

		System.out.println(p.denominator());
	}
}
