package BOJ10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String b = sc.nextLine();
		Stack<Character> s = new Stack<>();
		int sum = 0;

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '(')
				s.add(b.charAt(i));
			else {
				s.pop();

				if (b.charAt(i - 1) == '(')
					sum += s.size();
				else
					sum += 1;
			}
		}

		System.out.println(sum);
	}
}