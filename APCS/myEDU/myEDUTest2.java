import java.util.*;

public class myEDUTest2{

	public static void main(String[] args){
		ArrayList<Major> majors = getListOfMajors();
		System.out.println(Arrays.toString(majors.toArray()));

		Scanner in = new Scanner(System.in);
		System.out.print("What's your major?\t");
		String userMajor = in.nextLine();

		selectCourses(userMajor, majors);

	}

	public static ArrayList<Major> getListOfMajors(){
		ArrayList<Major> majors = new ArrayList<Major>();

		String[] preReq = {"Precalculus", "Honors Precalculus"};
		Course[] courses = {new Course("AP Calc BC", preReq, null), new Course("Precalculus", null, null), new Course("Honors Precalculus", null, null)};
		Major math = new Major("Mathematics", courses);
		majors.add(math);

		String[] preReq3 = {"Precalculus", "Honors Precalculus"};
		Course[] courses3 = {new Course("AP Computer Science", preReq3, null)};
		majors.add(new Major("Computer Science", courses3, math));

		String[] preReq2 = {"Honors Biology", "Biology", "Honors Chemistry", "Chemistry"};
		Course[] courses2 = {new Course("Honors Physics", preReq2, null), new Course("Physics", preReq2, null)};
		majors.add(new Major("Physics", courses2));

		Collections.sort(majors);

		return majors;
	}

	public static void selectCourses(String userMajor, ArrayList<Major> majors){
		Major major = findMajor(userMajor, majors, 0, majors.size() - 1);
		System.out.println("Take the following courses:");

		while(major != null){
			for(int i = 0; i < major.getCourses().length; i++){
				System.out.print(major.getCourses()[i] + "\tPrerequisite(s):\t");
				try{
					for(int j = 0; j < major.getCourses()[i].getPreReq().length; j++){
						System.out.print(major.getCourses()[i].getPreReq()[j] + " ");
					}
				}catch(NullPointerException e){
					System.out.print("NONE");
				}

				System.out.print("\tCorequisite(s):\t");

				try{
					System.out.print(major.getCourses()[i].getCoReq());
					for(int h = 0; h < major.getCourses()[i].getCoReq().length; h++){
						System.out.print(major.getCourses()[i].getCoReq()[h] + " ");
					}
				}catch(NullPointerException e){
					System.out.print("NONE");
				}
				System.out.println();
			}
			major = major.getParent();
		}

	}

	private static Major findMajor(String userMajor, ArrayList<Major> majors, int low, int high){
		int mid = (low + high) / 2;
		String s1 = majors.get(mid).getMajor();
		if(s1.equals(userMajor))
			return majors.get(mid);
		else if(s1.compareTo(userMajor) > 0){
			return findMajor(userMajor, majors, 0, mid - 1);
		}
		else if(s1.compareTo(userMajor) < 0){
			return findMajor(userMajor, majors, mid + 1, high);
		}
		else{
			return null;
		}
	}



}