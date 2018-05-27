package BOJ10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		int num=0;
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Person p = new Person(age,name,num++);
			list.add(p);
		}

		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age > o2.age ) return 1;
				else if( o1.age == o2.age) {
					return o1.num < o2.num ? -1 : 1;
				}
				return -1;
			}
		});
		
	
	
	for( Person p : list) {
		sb.append(p.age).append(" ").append(p.name).append("\n");
	}
	System.out.println(sb.toString());
}

}

class Person {
	int age;
	int num;
	String name;

	Person(int age, String name, int num) {
		this.age = age;
		this.num = num;
		this.name = name;
	}
}
