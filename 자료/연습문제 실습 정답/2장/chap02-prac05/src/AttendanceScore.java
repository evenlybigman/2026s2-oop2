import java.util.Scanner;

public class AttendanceScore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생1>>");
		String name1 = scanner.next(); // 이름 입력
		int tardyCount1 =  scanner.nextInt(); // 지각 횟수 입력
		int absentCount1 =  scanner.nextInt(); // 결석 횟수 입력
		int deductionScore1 = tardyCount1*3 + absentCount1*8; // 감점 계산
		int attendanceScore1 = 100 - deductionScore1; // 출석 점수 계산
		
		System.out.print("학생2>>");
		String name2 = scanner.next(); // 이름 입력
		int tardyCount2 =  scanner.nextInt(); // 지각 횟수 입력
		int absentCount2 =  scanner.nextInt(); // 결석 횟수 입력
		int deductionScore2 = tardyCount2*3 + absentCount2*8; // 감점 계산
		int attendanceScore2 = 100 - deductionScore2; // 출석 점수 계산

		System.out.print(name1 + "의 감점은 "  + deductionScore1 + ", ");
		System.out.println(name2 + "의 감점은 "  + deductionScore2);
		
		if(attendanceScore1 == attendanceScore2) // 출석 점수가 동일한 경우
			System.out.println("점수 동일");
		else if(attendanceScore1 > attendanceScore2) // 학생1의 출석 점수가 높은 경우
			System.out.println(name1 + "의 출석 점수가 더 높음. " + name1 + " 출석 점수는 "  + attendanceScore1);
		else // 학생2의 출석 점수가 높은 경우
			System.out.println(name2 + "의 출석 점수가 더 높음. " + name2 + " 출석 점수는 "  + attendanceScore2);
		
		scanner.close();
	}

}
