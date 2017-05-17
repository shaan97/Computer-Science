public class RecursTest{
	public static void main(String[] args){
		System.out.println(mystery(348));


	}

	public static int mystery(int n){
		if(n < 10)
			return (10 * n) + n;
		else{
			int a = mystery(n / 10);
			int b = mystery(n % 10);
			return (100 * a) + b;
		}
	}


}