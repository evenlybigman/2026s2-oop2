package week02;
import java.util.Scanner;

public class No2_1 {
	public static void main(String args[]) {
		System.out.println("제출자:김주혁\n");
		
		int currentExchangeRates = 1200;
		int dollars = 0;
		System.out.print("$1=" + currentExchangeRates + "원입니다. 달러를 입력하세요>>");
		
		Scanner scanner = new Scanner(System.in);
		
		dollars = scanner.nextInt();
		
		System.out.print("$" + dollars + "는 " + (dollars * currentExchangeRates) + "원입니다.");;
		
		scanner.close();
	}
}