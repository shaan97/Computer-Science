public class Chp2ex1{
	public static void main(String[] args){
		double s_intial = 5, s_final, v_intial = 10, time = 20, a = 9.8;
		s_final = s_intial + (v_intial * time) + (.5 * ( a * (time * time)));
		System.out.println(s_final);
	}
}