package BOJ7785;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		HashSet<String> employee = new HashSet<>();
		int n = Integer.parseInt(in.readLine());

		while (n > 0) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String log = st.nextToken();

			if (log.equals("enter")) {
				employee.add(name);
			} else {
				employee.remove(name);
			}
			n--;
		}

		ArrayList<String> list = new ArrayList<>(employee);
		Collections.sort(list, Collections.reverseOrder());

		for (String name : list) {
			sb.append(name).append("\n");
		}
		System.out.println(sb.toString());
	}
}
