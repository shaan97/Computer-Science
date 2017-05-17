import java.util.*;

public class Schedule{
	private ArrayList<Course> schedule;

	public Schedule(){
		schedule = new ArrayList<Course>();
	}

	public void addCourse(Course c){
		schedule.add(c);
	}

	public void addSchedule(ArrayList<Course> s){
		schedule.clear();
		schedule.addAll(s);
	}

	public ArrayList<Course> getSchedule(){
		return this.schedule;
	}

}