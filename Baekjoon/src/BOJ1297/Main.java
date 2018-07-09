package BOJ1297;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		StringTokenizer st = new StringTokenizer(in.readLine());
		int len = Integer.parseInt(st.nextToken());
		double h = Integer.parseInt(st.nextToken());
		double w = Integer.parseInt(st.nextToken());

		double t = Math.sqrt(Math.pow(h, 2) + Math.pow(w, 2));
		
		//³Êºñ
		double a = (len*w)/t;
		double b = (len*h)/t;
		
		System.out.println((int)b + " " + (int)a);
		}
	}
}
