package BOJ1924;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int month = keyboard.nextInt();
		int day = keyboard.nextInt();
		int[] dayNum = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int sum = 0;

		if (month != 1) {
			for (int i = 0; i < month - 1; i++) {
				sum += dayNum[i];
			}
		}
		sum += day;
		System.out.println(week[sum % 7]);
	}
}
