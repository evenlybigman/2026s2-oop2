import java.util.Scanner;

public class QuizGugudan {

	public static void main(String[] args) {
		System.out.println("***** 구구단 퀴즈입니다. *****");
		Scanner scanner = new Scanner(System.in);
		
		int failCount = 0; // 틀린 횟수 카운트
		while(true) {
			int n = (int)(Math.random()*9 + 1); // 1~9 사이의 랜덤 정수
			int m = (int)(Math.random()*9 + 1); // 1~9 사이의 랜덤 정수
			int answer = n*m;
			
			System.out.print(n + "x" + m + "=");
			int user = scanner.nextInt();
			if(user == answer) // 사용자가 정답을 입력한 경우
				System.out.println("정답입니다. 잘했습니다.");
			else {
				failCount++;
				if(failCount == 3) { // 3번 틀린 경우
					System.out.println(failCount + "번 틀렸습니다. 퀴즈 종료합니다.");
					break; // while 문을 벗어난다.
				}
				else  // 3번 미만 틀린 경우
					System.out.println(failCount + "번 틀렸습니다. 분발하세요.");					
			}
		}
		scanner.close();
	}

}
