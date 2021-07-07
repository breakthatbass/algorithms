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

	/***** plus, minus, times, dividedBy, equals, toString  *****/

	public Rational plus(Rational that)
	{
		int numer1 = this.numerator() * that.denominator();
		int numer2 = this.denominator() * that.numerator();

		return new Rational(numer1+numer2, this.denominator()*that.denominator());
	}

	public Rational minus(Rational that)
	{
		int numer1 = this.numerator() * that.denominator();
		int numer2 = this.denominator() * that.numerator();

		return new Rational(numer1-numer2, this.denominator()*that.denominator());
	}

	public Rational times(Rational that)
	{
		int num = this.numerator() * that.numerator();
		int denom = this.denominator() * that.denominator();

		return new Rational(num, denom);
	}

	public Rational dividedBy(Rational that)
	{
		Rational tmp = new Rational(that.denominator(), that.numerator());
		return times(tmp);
	}

	public boolean equals(Object x)
	{
		if (this == x) return true;
		if (x == null) return false;

		if (this.getClass() != x.getClass()) return false;

		Rational that = (Rational) x;

		if (this.denominator() != that.denominator()) return false;
		if (this.numerator() != that.numerator()) return false;

		return true;
	}


	public static void main(String[] args)
	{
		Rational n = new Rational(4, 1);

		Rational p = new Rational(8, 4);
		Rational same = new Rational(8, 4);

		Rational test = n.plus(p);

		if (p.equals(same))
			System.out.println("same");
		else
			System.out.println("not the same");

		System.out.println("numer: " + test.numerator());
		System.out.println("denom: " + test.denominator());
	}
}
