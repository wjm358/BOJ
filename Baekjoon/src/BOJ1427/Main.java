package BOJ1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String num = reader.readLine();
		int arr[] =new int[num.length()];
		
		for(int i=0; i< num.length();i++) {
			arr[i] = num.charAt(i)-'0';
		}
		
		Arrays.sort(arr);
		
		for(int i=arr.length-1; i>=0;i--)
			sb.append(arr[i]);
		
		System.out.println(sb.toString());
	}
}
