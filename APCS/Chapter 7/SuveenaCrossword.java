public class SuveenaCrossword{
	public static void main(String[] args){
		int count = 0;
		for(double i = 2; i < 100; i++){
			for(double j = 2; j < i; j++){
				for(double x = 2; x < i; x++){
					if(((Math.round(x*j)*100.0)/100) != i){
						count++;
					}

				}
			}
			if(count == ()){
									System.out.println(i + " is not");
									count = 0;
								}else{
									count = 0;
					}
		}
	}
}