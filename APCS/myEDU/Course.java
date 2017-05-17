public class Course implements Comparable{

	private String courseName;
	private String[] preReq;
	private String[] coReq;

	public Course(String courseName, String[] preReq, String[] coReq){
		setCourseName(courseName);
		setPreReq(preReq);
		setCoReq(coReq);
	}

	public void setCourseName(String courseName){
		this.courseName = courseName;
	}

	public void setPreReq(String[] preReq){
		this.preReq = preReq;
	}

	public void setCoReq(String[] coReq){
		this.coReq = coReq;
	}

	public String getCourseName(){
		return this.courseName;
	}

	public String[] getPreReq(){
		if(hasPreReq()){
			return this.preReq;
		}else
			return null;
	}

	public String[] getCoReq(){
		if(hasCoReq())
			return this.coReq;
		else
			return null;
	}

	public boolean hasPreReq(){
		for(int i = 0; i < this.preReq.length; i++){
			if(this.preReq[i] != null)
				return true;
		}
		return false;
	}

	public boolean hasCoReq(){
		for(int i = 0; i < this.coReq.length; i++){
			if(this.coReq[i] != null)
				return true;
		}
		return false;
	}

	public String toString(){
		return this.courseName;
	}

	public int compareTo(Object o){
		return this.getCourseName().compareTo(((Course) o).getCourseName());
	}
}