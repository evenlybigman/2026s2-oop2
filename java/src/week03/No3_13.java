package week03;

import java.util.Scanner;

public class No3_13 {
	public static void main(String[] args) {
		System.out.println("제출자:김주혁\n");
		
		String course[] = { "C", "C++", "Python", "Java", "HTML5" };
		String grade[] = { "A", "B+", "B", "A+", "D" };
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("과목>>");
			String searchCourse = scanner.next();
			
			if (searchCourse.equals("그만")) {
				break;
			}
			
			int index = 0;
			for (index = 0; index < course.length; index++) {
				if (searchCourse.equals(course[index])) {
					System.out.println(course[index] + " 학점은 " + grade[index]);
					break;
				}
			}
			
			if (index == course.length) {
				System.out.println(searchCourse + "는 없는 과목입니다.");
			}		
		}
		
		scanner.close();
	}
}
