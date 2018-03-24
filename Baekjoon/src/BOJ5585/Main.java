package BOJ5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int coin[] = {500,100,50,10,5,1};
		
		int change = 1000 - n;
		int index =0, count=0;
		
		while(change > 0) {
			if(change >= coin[index]) {
				count = count + (change / coin[index]);
				change %= coin[index];
			}
			index++;
		}
		
		System.out.println(count);
		
	}
}
