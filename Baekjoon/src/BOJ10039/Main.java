package BOJ10039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		
		for(int i=0; i<5;i++) { 
			int num = Integer.parseInt(reader.readLine());
			if( num < 40) num = 40;
			sum += num;
			
		}
		
		System.out.println(sum/5 );
	}

}
