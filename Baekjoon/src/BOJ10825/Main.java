package BOJ10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuffer sb =new StringBuffer();
		Student[] student = new Student[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			student[i] = new Student(name, kor, eng, math);
		}
		Arrays.sort(student);

		for (Student t : student) {
			sb.append(t.name).append("\n");
		}
		System.out.println(sb.toString());
	}
}

class Student implements Comparable<Student> {
	String name;
	int kor;
	int eng;
	int math;

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		if (this.kor > o.kor) {
			return -1;
		} else if (this.kor == o.kor) {
			if (this.eng == o.eng) {
				if (this.math > o.math)
					return -1;
				else if (this.math == o.math)
					return this.name.compareTo(o.name);
			} else if (this.eng < o.eng)
				return -1;
		}
		return 1;
	}

}
