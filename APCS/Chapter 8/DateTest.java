import java.util.Scanner;

class Date{
	private int year;
	private int month;
	private int days;

	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.days = day;
	}

	public void addDays(int days){
		this.days+=days;
		int x = daysInMonth(this.month, this.year);
		if(this.days > x){
			while(this.days > daysInMonth(this.month, this.year)){
				this.days-=daysInMonth(this.month, this.year);
				this.month++;
				if(this.month > 12){
					this.year++;
					this.month = 1;
				}
			}
		}


	}

	public void addWeeks(int weeks){
		int sendDays = weeks*7;
		addDays(sendDays);
	}

	public int daysTo(Date other){
		if(other.year < this.year){
			throw new IllegalArgumentException();
		}
		int daysLeft = other.days - this.days;

		for(int i = this.month; i < other.month; i++){
			int add = daysInMonth(i, this.year);
			daysLeft += add;



		}


		for(int i = other.month; i < this.month; i++){
			int add = daysInMonth(i,other.year);

			daysLeft -= add;

		}


		for(int i = this.year; i < other.year; i++){
			if(checkLeap(i)){

				daysLeft += 366;
			}else{
				daysLeft += 365;

			}
		}



		return daysLeft;
	}

	public int getDay(){
		return this.days;

	}

	public int getMonth(){
		return this.month;

	}

	public int getYear(){
		return this.year;

	}

	public boolean isLeapYear(){
		return (this.year % 4 == 0) && (this.year % 100 != 0 || this.year % 400 == 0) || this.year == 1;

	}

	private boolean checkLeap(int year){
		return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0) || ((year) == 1);

	}

	public int daysInMonth(int month, int year){
		switch(month){

			case 1:	return 31;

			case 2:	if(checkLeap(year)){
						return 29;
					}else{
						return 28;
					}

			case 3: return 31;

			case 4: return 30;

			case 5: return 31;

			case 6: return 30;

			case 7: return 31;

			case 8: return 31;

			case 9: return 30;

			case 10: return 31;

			case 11: return 30;

			case 12: return 31;
		}
			return 0;
	}

	public String toString(){
		return ""+this.month+"/"+this.days+"/"+this.year;

	}
}


public class DateTest{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Date. Enter as integers (Year, Month, Day):\t");
		int y1 = in.nextInt();
		int m1 = in.nextInt();
		int day1 = in.nextInt();
		System.out.print("Repeat for Date 2:\t");
		int y2 = in.nextInt();
		int m2 = in.nextInt();
		int day2 = in.nextInt();



		Date d1 = new Date(y1,m1,day1);
		Date d2 = new Date(y2,m2,day2);

		System.out.println("What function? daysTo, addDays");
		String s1 = in.next();
		s1 = s1.toUpperCase();
		if(s1.equals("DAYSTO"))
			System.out.println(d1.daysTo(d2));
		if(s1.equals("ADDDAYS")){

			System.out.print("How many days?\t");
			int x = in.nextInt();
			d1.addDays(x);
			System.out.println(d1);

		}



	}
}