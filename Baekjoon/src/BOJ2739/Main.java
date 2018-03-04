package BOJ2739;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int a = keyboard.nextInt();
		
        for(int i=1; i<=9; i++){
            System.out.println(a + " * " + i + " = " + a*i);
        }
	}
}
