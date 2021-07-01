/*
 * exercise 1.2.13
 *
 * using our implementation of Date as a model (page 91), develop an
 * implementation of Transation.
 *
 * Im not really sure what this means. im just going to make a simulation of a
 * receipt
 *
 * exercise 1.2.14
 *
 * using our implementation of equals() in Date as a model (page 103), develop
 * an implementation of equals() for Transaction.
 */
public class Transaction
{
	private double amount;
	private String item;
	private SmartDate date;
	private String name;

	public Transaction(double amount, String item, SmartDate date, String name) {
		this.amount = amount;
		this.item = item;
		this.date = date;
		this.name = name;
	}

	public double cost() {
		return amount;
	}

	public String itemPurchased() {
		return item;
	}

	public SmartDate datePurchased() {
		return date;
	}

	public String getName() {
		return name;
	}


	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;

		if (this.getClass() != x.getClass()) return false;

		// cast Object x to Transaction
		Transaction that = (Transaction) x;

		if (this.amount != that.amount) return false;
		if (this.item != that.item) return false;
		if (this.date != that.date) return false;
		if (this.name != that.name) return false;

		return true;
	}


	public String toString() {
		return name + " puchased " + item + " on " + date.toString() + " for $" + amount;
	}

	
	/******** MAIN **********/
	
	public static void main(String[] args)
	{
		// today's date
		SmartDate date = new SmartDate(7, 1, 2021);

		Transaction newShoes = new Transaction(95.99, "tennis shoes", date, "Taylor");
		System.out.println(newShoes.toString());

		// tests for equals()
		// identical obejcts
		Transaction newCar1 = new Transaction(45200.00, "volkswagen", date, "Taylor");
		Transaction newCar2 = new Transaction(45200.00, "volkswagen", date, "Taylor");

		// the tests below should print:
		// same transaction
		// different transaction

		if (newCar1.equals(newCar2))
			System.out.println("same transactions");
		else
			System.out.println("different transactions");


		if (newCar1.equals(newShoes))
			System.out.println("same transactions");
		else
			System.out.println("different transactions");
	}
}
