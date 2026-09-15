package week03;

import java.util.Scanner;

public class No3_03 {
	public static void main(String[] args) {
		System.out.println("제출자:김주혁\n");
		
		int input = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(input < 1) {
			System.out.print("양의 정수 입력>>");
			input = scanner.nextInt();
		}
		
		for (int i = 0; i < input; i++) {
			for (int j = i; j < input; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		scanner.close();
	}
}
