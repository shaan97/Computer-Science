import java.util.*;

public class myEDUTest{

	public static void main(String[] args){
		ArrayList<Course> list = classList();
		Collections.sort(list);



	}

	public static ArrayList<Course> classList(){
		Scanner in = new Scanner(System.in);

		System.out.print("How many courses would you like to enter?\t");
		ArrayList<Course> classList = new ArrayList<Course>();
		int numCourses = in.nextInt();

		for(int i = 0; i < numCourses; i++){
			System.out.print("Course name:\t");
			String name = in.next();

			System.out.print("Has prerequisite course? Enter y or n:\t");
			String response1 = in.next();
			String preReq = null;
			if(response1.toUpperCase().equals("Y")){
				System.out.print("Name of prerequisite course:\t");
				preReq = in.next();
			}

			System.out.print("Has corequisite course? Enter y or n:\t");
			String response2 = in.next();
			String coReq = null;
			if(response2.toUpperCase().equals("Y")){
				System.out.print("Name of corequisite course? Enter y or n:\t");
				coReq = in.next();
			}

			classList.add(new Course(name, preReq, coReq));

		}

		return classList;
	}

}