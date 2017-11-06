package ad02;

public class main {

	public static void main(String[] args) {
		main main = new main();
		main.problem_rekursiv(4);
		System.out.println(main.counter);
	}
	private int counter = 0;
	
	
	
	
	public void problem_rekursiv(int n){
	if ( n <= 1 ) return; // kein Rechenschritt
	counter ++;
	problem_rekursiv(n/2);
	problem_rekursiv(n/2);
	}

}
