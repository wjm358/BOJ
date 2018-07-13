package BOJ10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String command = st.nextToken();

			switch (command) {
			case "push_front":
				int x = Integer.parseInt(st.nextToken());
				deque.addFirst(x);
				break;
			case "push_back":
				int x1 = Integer.parseInt(st.nextToken());
				deque.addLast(x1);
				break;
			case "pop_front":
				if (deque.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(deque.removeFirst()).append("\n");
				break;
			case "pop_back":
				if (deque.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(deque.removeLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if (deque.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if (deque.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(deque.getFirst()).append("\n");
				break;
			case "back":
				if (deque.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(deque.getLast()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());

	}

}
