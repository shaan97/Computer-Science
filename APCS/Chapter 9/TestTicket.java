abstract class Ticket{
	protected int number;

	public Ticket(int number){
		this.number = number;
	}

	abstract double getPrice();
}

class WalkUp extends Ticket{

	public WalkUp(int number){
		super(number);
	}

	public double getPrice(){
		return (this.number * 50);
	}

	public String toString(){
		return ("Number of tickets: " + this.number + "\ntotal cost: " + getPrice());
	}
}

class AdvanceTicket extends Ticket{
	private int days;

	public AdvanceTicket(int number, int days){
		super(number);
		this.days = days;
	}

	public double getPrice(){
		if(this.days >= 10)	{
			return (this.number * 30);
		}
		else{
			return (this.number * 40);
		}
	}

	public void setDays(int days){
		this.days = days;
	}

	public int getDays(){
		return this.days;
	}

	public String toString(){
		return ("Number of tickets: " + this.number + "\ntotal cost: " + getPrice());
	}
}

class AdvanceTicketStudent extends AdvanceTicket{

	public AdvanceTicketStudent(int number, int days){
		super(number, days);							//If I didn't call super(number,days), the compiler would have automatically called super(); However,
	}													//the class AdvancedTicket only has a constructor with two parameters. It doesn't have a default constructor.

	public double getPrice(){
		if(getDays() >= 10)	{
			return (this.number * 15);
		}
		else{
			return (this.number * 20);
		}
	}

	public String toString(){
		return ("Number of tickets: " + this.number + "\ntotal cost: " + getPrice() + "\nID Required");
	}
}

public class TestTicket{
	public static void main(String [] args){
		Ticket a = new WalkUp(12);
		a.getPrice();
		System.out.println(a);

		Ticket b = new AdvanceTicket(12, 5);
		b.getPrice();
		System.out.println(b);

		Ticket c = new AdvanceTicketStudent(12, 13);
		c.getPrice();
		System.out.println(c);
	}
}

