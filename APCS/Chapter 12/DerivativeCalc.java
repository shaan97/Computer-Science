import java.util.ArrayList;
import java.util.Scanner;

class Function{

	private ArrayList<Term> terms = new ArrayList<Term>();

	public Function(String funct){
		findTerms(funct);
	}

	public void findTerms(String funct){
		int index = 0;

		for(int i = 0; i < funct.length(); i++){
			if(funct.charAt(i) == '-' || funct.charAt(i) == '+'){
				this.terms.add( new Term( funct.substring(index, i) ) );
				index = i;
			}
		}
		this.terms.add( new Term( funct.substring(index) ) );
	}

	public ArrayList<Term> getTerms(){
		return this.terms;
	}

	public void deriveAll(){
		for(int i = 0; i < terms.size(); i++){
			terms.get(i).noSpaces();
			terms.get(i).derive();
		}
	}
	public void addTerms(Term t){
		this.terms.add(t);
	}

	public String toString(){
		String newFunct = "";
		for(int i = 0; i < terms.size(); i++){
			newFunct = newFunct + terms.get(i).toString() + " ";
		}
		return newFunct;
	}
}

class Term{
	private String t;

	public Term(String t){
		changeTerm(t);
	}

	public void changeTerm(String t){
		this.t = t;
	}

	public String toString(){
		return this.t;
	}

	public void derive(){
		String temp = "";
		if(this.t.charAt(0) == '-' || this.t.charAt(0) == '+'){
			temp = "" + this.t.charAt(0);
			this.t = this.t.substring(1);
		}
		this.t = temp + " " + Derivative.derive(this.t);
	}

	public void noSpaces(){
		this.t = this.t.replaceAll("\\s","");
	}
}

public class DerivativeCalc{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.print("Input function.\tf(x) = \t");
		Function f = new Function(in.nextLine());

		f.deriveAll();
		System.out.println("f'(x) = " + f);


	}
}