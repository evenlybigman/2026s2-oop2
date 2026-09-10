package No2_2;

import java.util.Scanner;

// 생년월일 숫자 8자를 입력받아 구분하는 프로그램
public class nextInt {
	public static void main(String args[]) {
		System.out.println("제출자:김주혁\n");
		
		System.out.print("생년원일 8자를 입력하세요>>");
		
		Scanner scanner = new Scanner(System.in);
		
		int birth = 0, year = 0, month = 0, day = 0;
		
		birth = scanner.nextInt();
		
		//20040914
		year = birth / 10000;
		month = (birth % 10000) / 100;
		day = (birth % 100);
		
		System.out.print(year + "년 " + month + "월 " + day + "일");
		
		scanner.close();
	}
}
