class ParkedCar{
	private String make;
	private String model;
	private String color;
	private String license;
	private int minutes;

	public ParkedCar(String make, String model, String color, String license, int minutes){
		this.make = make;
		this.model = model;
		this.color = color;
		this.license = license;
		this.minutes = minutes;
	}
	public String getMake(){
		return this.make;
	}
	public String getModel(){
		return this.model;
	}
	public String getColor(){
		return this.color;
	}
	public String getLicense(){
		return this.license;
	}
	public int getMinutes(){
		return this.minutes;
	}
	public String toString(){
		return this.color + " " + this.make + " " + this.model;
	}
}

class ParkingMeter{
	private int meterMinutes;

	public ParkingMeter(int meterMinutes){
		this.meterMinutes = meterMinutes;
	}

	public int getMeterMinutes(){
		return this.meterMinutes;
	}

	public String toString(){
		return ""+ this.meterMinutes;
	}
}

class ParkingTicket{
	private ParkedCar car;
	private ParkingMeter meter;
	private PoliceOfficer p1;
	private double fine;
	public ParkingTicket(ParkedCar car, ParkingMeter meter, PoliceOfficer p1){
		if(car.getMinutes() <= meter.getMeterMinutes())
			throw new IllegalArgumentException();
		else{
			this.car = car;
			this.meter = meter;
			this.p1 = p1;
			this.fine = getFine();
		}
	}
	public String getMake(){
		return car.getMake();
	}
	public String getModel(){
		return car.getModel();
	}
	public String getColor(){
		return car.getColor();
	}
	public String getLicense(){
		return car.getLicense();
	}
	private double calcFine(){
		int illegal = car.getMinutes() - meter.getMeterMinutes();
		int fine = 0;
		if(illegal > 0){
			fine = 25 + (10 * (illegal / 60));
		}
		return fine;
	}
	public double getFine(){
		return fine;
	}
	public String getOfficerName(){
		return p1.getName();
	}
	public int getOfficerBadge(){
		return p1.getBadge();
	}
	public String toString(){
		return "CAR: " + car.toString() + " MINUTES BREACHED: " + (car.getMinutes() - meter.getMeterMinutes()) + " OFFICER NAME: " + p1.toString();
	}
}

class PoliceOfficer{
	String officerName;
	int badge;

	public PoliceOfficer(String officerName, int badge){
		this.officerName = officerName;
		this.badge = badge;
	}
	public String getName(){
		return this.officerName;
	}
	public int getBadge(){
		return this.badge;
	}

	public boolean didExpire(ParkedCar car, ParkingMeter meter){
		return car.getMinutes() > meter.getMeterMinutes();
	}
	public ParkingTicket issueTicket(ParkedCar car, ParkingMeter meter){
		ParkingTicket ticket = null;
		if(didExpire(car, meter)){
			ticket = new ParkingTicket(car, meter, this);
			return ticket;
		}
		return null;

	}
	public String toString(){
		return this.officerName + " #" + this.badge;
	}


}

public class ParkingTicketSimulator{
	public static void main(String[] args){
		ParkedCar car = new ParkedCar("Ford", "Focus", "Blue", "1234ABC", 125);
		ParkingMeter meter = new ParkingMeter(60);
		PoliceOfficer police = new PoliceOfficer("Bill Cop", 1234);
		ParkingTicket t1 = police.issueTicket(car, meter);
		if(t1 == null)
			System.out.println("No ticket.");
		else
			System.out.println(t1);

	}


}