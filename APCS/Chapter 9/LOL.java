public class LOL{
	public static void main(String[] args){
		System.out.println(foo(1));
	}

	public static int foo(int n){
		if(n == 0)
			return 1;
		else if(n == 1)
			return 0;
		else
			return n * (foo(foo(n-1)));

	}


}