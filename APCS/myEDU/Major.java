public class Major implements Comparable{

	private String majorName;
	private Course[] courses;
	private Major parent;

	public Major(String majorName, Course[] courses, Major parent){
		this(majorName, courses);
		setParent(parent);
	}

	public Major(String majorName, Course[] courses){
		setMajor(majorName);
		setCourses(courses);
	}

	public void setMajor(String newMajor){
		this.majorName = newMajor;
	}

	public void setCourses(Course[] courses){
		this.courses = courses;
	}

	public void setParent(Major parent){
		this.parent = parent;
	}

	public String getMajor(){
		return this.majorName;
	}

	public Course[] getCourses(){
		return this.courses;
	}

	public Major getParent(){
		return this.parent;
	}

	public String toString(){
		return getMajor();
	}
	public int compareTo(Object o){
		return this.getMajor().compareTo( ((Major) o).getMajor());
	}
}