import java.util.Scanner;

public class CourseAndGrade {
	
	public static void main(String[] args) {
		String course [] = {"C", "C++", "Python", "Java", "HTML5" };
		String grade [] = {"A", "B+", "B", "A+", "D"};
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("과목>>");
			String searchCourse = scanner.next();
			if(searchCourse.equals("그만"))
				break; // while 루프 종료
			int index = 0;
			for(index=0; index<course.length; index++) {
				if(course[index].equals(searchCourse)) { // 발견
					System.out.println(searchCourse + " 학점은 " + grade[index]);
					break; // 검색 종료. for 문 벗어나기
				}
			}
			
			if(index == course.length) // 발견하지 못한 경우
				System.out.println(searchCourse + "는 없는 과목입니다.");
			
		}
		scanner.close();
	}

}
