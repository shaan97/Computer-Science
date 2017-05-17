class PersonData{
	private String lastName;
	private String firstName;
	private int address;
	private String city;
	private String state;
	private int zip;
	private long phone;

	public PersonData(String lastName, String firstName, int address, String city, String state, int zip, long phone){
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public String getName(){
		return lastName + ", " + firstName;
	}

	public String getAddress(){
		return "" + this.address + " " + this.city + " " + this.state + " " + this.zip;
	}

	public int getZip(){
		return this.zip;
	}

	public long getPhone(){
		return this.phone;
	}

	public void setName(String lastName, String firstName){
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public void setAddress(int address){
		this.address = address;
	}

	public void setCity(String city){
		this.city = city;
	}

	public void setState(String state){
		this.state = state;
	}

	public void setZip(int zip){
		this.zip = zip;
	}

	public void setPhone(long phone){
		this.phone = phone;
	}

	public String toString(){
		return this.lastName + ", " + this.firstName + " Address: " + this.address + " City: " + this.city + " State: " + this.state + " Zip: " + this.zip + " Phone: " + this.phone;

	}
}

class CustomerData extends PersonData{
	private int customerNumber;
	private boolean mailingList;

	public CustomerData(String lastName, String firstName, int address, String city, String state, int zip, long phone, int customerNumber, boolean mailingList){
		super(lastName, firstName, address, city, state, zip, phone);
		this.customerNumber = customerNumber;
		this.mailingList = mailingList;
	}

	public int getCustomerNumber(){
		return this.customerNumber;
	}

	public boolean onMailingList(){
		return this.mailingList;
	}

	public void setCustomerNumber(int y){
		this.customerNumber = y;
	}

	public void setMailingList(boolean y){
		this.mailingList = y;
	}
	public String toString(){
		return super.toString() + " Customer Number: " + this.customerNumber + " Mailing List: " + this.mailingList;
	}
}

public class CustomerTest{
	public static void main(String[] args){
		CustomerData c1 = new CustomerData("Roberts", "John", 1776, "Washington D.C.", "District of Columbia", 54321, 5551776, 1, true);
		PersonData p1 = new PersonData("Connor", "John", 2222, "Earth City", "California", 94555, 5555555);
		PersonData poly = new CustomerData("BooBoo", "DooDoo", 2191, "Lala City", "Georgia", 12341, 5551234, 2, false);

		System.out.println(c1);
		System.out.println(p1);
		System.out.println(poly);

		System.out.println("\nGet c1 address:\t" + c1.getAddress());
		c1.setAddress(78787);
		System.out.println("\nGet p1 Name:\t" + p1.getName());
		p1.setName("NOPE", "LOL");
		System.out.println("\nGet poly zip:\t" + poly.getZip());
		poly.setZip(94536);

		System.out.println(c1);
		System.out.println(p1);
		System.out.println(poly);

	}
}