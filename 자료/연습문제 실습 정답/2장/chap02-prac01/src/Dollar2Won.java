import java.util.Scanner;

public class Dollar2Won {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("$1=1200원입니다. 달러를 입력하세요>>");
		int dollar = scanner.nextInt();
		int won = dollar*1200; // 원화로 계산
		
		System.out.println("$" + dollar + "는 " + won + "원입니다.");
		
		scanner.close();
	}
}
