/*
 * exercise 1.2.13
 *
 * using our implementation of Date as a model (page 91), develop an
 * implementation of Transation.
 *
 * Im not really sure what this means. im just going to make a simulation of a
 * receipt
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

	public String toString() {
		return name + " puchased " + item + " on " + date.toString() + " for $" + amount;
	}

	public static void main(String[] args)
	{
		// today's date
		SmartDate date = new SmartDate(7, 1, 2021);

		Transaction newShoes = new Transaction(95.99, "tennis shoes", date, "Taylor");
		System.out.println(newShoes.toString());
	}
}
