public class GroceryTime{
	public static void main(String[] args){
		GroceryItemOrder i1 = new GroceryItemOrder("chicken", 1, 4.00);
		GroceryItemOrder i2 = new GroceryItemOrder("beets", 2, 2.00);
		GroceryItemOrder i3 = new GroceryItemOrder("curry", 22, 3.50);
		GroceryItemOrder i4 = new GroceryItemOrder("eggs", 22, 3.50);
		GroceryItemOrder i5 = new GroceryItemOrder("top ramen", 22, 3.50);
		GroceryItemOrder i6 = new GroceryItemOrder("marshmellows", 22, 3.50);
		GroceryItemOrder i7 = new GroceryItemOrder("bread", 22, 3.50);
		GroceryItemOrder i8 = new GroceryItemOrder("coca cola", 22, 3.50);
		GroceryItemOrder i9 = new GroceryItemOrder("nutella", 22, 3.50);
		GroceryItemOrder i10 = new GroceryItemOrder("cupcakes", 22, 3.79790);


		GroceryList list1 = new GroceryList();
		list1.add(i1);
		list1.add(i2);
		list1.add(i3);
		list1.add(i4);
		list1.add(i5);
		list1.add(i6);
		list1.add(i7);
		list1.add(i8);
		list1.add(i9);
		list1.add(i10);

		System.out.println(list1.getTotalCost());

	}

}


class GroceryList{

	GroceryItemOrder[] list;
	private int numItems = 0;
	public static double price = 0;

	public GroceryList(){
		list = new GroceryItemOrder[10];
	}

	public void add(GroceryItemOrder item){
		list[numItems] = item;
		numItems++;
		price += item.getCost();
	}

	public String getTotalCost(){
		return "$" + ((int)(price*100))/100.0;

	}
}

class GroceryItemOrder{

	private int quantity;
	private double pricePerUnit;
	String name;

	public GroceryItemOrder(String name, int quantity, double pricePerUnit){
		this.name = name;
		this.quantity = quantity;
		this. pricePerUnit = pricePerUnit;
	}

	public double getCost(){
		return pricePerUnit*quantity;

	}

	public void setQuantity(int quantity){
		this.quantity = quantity;

	}
}