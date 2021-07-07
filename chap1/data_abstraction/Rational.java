/*
 * exercise 1.2.16
 *
 * rational numbers
 * implement an immutable data type Rational for rational numbers that supports
 * addition, subtraction, multiplication, and division.
 * 
 * exercise 1.2.17
 *
 * robust rational: use assertions to develop an implmentation of rational that
 * is immune to overflow 
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

	private boolean test_for_overflow(int a)
	{
		if (a > Integer.MAX_VALUE) return true;
		if (a < Integer.MIN_VALUE) return true;

		return false;
	}

	/***** plus, minus, times, dividedBy, equals, toString  *****/

	public Rational plus(Rational that)
	{
		
		int numer1 = this.numerator() * that.denominator();
		int numer2 = this.denominator() * that.numerator();
		
		if (test_for_overflow(numer1) || test_for_overflow(numer2)) {
			throw new IllegalArgumentException("too big or too small");
		}

		return new Rational(numer1+numer2, this.denominator()*that.denominator());
	}

	public Rational minus(Rational that)
	{
		int numer1 = this.numerator() * that.denominator();
		int numer2 = this.denominator() * that.numerator();
		
		if (test_for_overflow(numer1) || test_for_overflow(numer2)) {
			throw new IllegalArgumentException("too big or too small");
		}

		return new Rational(numer1-numer2, this.denominator()*that.denominator());
	}

	public Rational times(Rational that)
	{
		int num = this.numerator() * that.numerator();
		int denom = this.denominator() * that.denominator();
		
		if (test_for_overflow(num) || test_for_overflow(denom)) {
			throw new IllegalArgumentException("too big or too small");
		}

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

		System.out.println("testing for overflow...");
		int too_big = Integer.MAX_VALUE + 1;
		int too_small = Integer.MIN_VALUE - 1;

		Rational too_big_rational = new Rational(too_big, 1);
		Rational too_small_rational = new Rational(too_small, 1);
		
		Rational junk = new Rational(too_big, 1);

		Rational poo = junk.times(too_big_rational);

	}
}
