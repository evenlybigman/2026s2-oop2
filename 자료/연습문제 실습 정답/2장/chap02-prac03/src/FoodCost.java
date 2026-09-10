import java.util.Scanner;

public class FoodCost {
	// 의도적으로 한글 이름을 상수를 사용해 보았습니다.
	public static final int 떡복기 = 2000;
	public static final int 김말이 = 1000;
	public static final int 쫄면 = 3000;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*** 자바 분식입니다. 주문하면 금액을 알려드립니다.****");
		System.out.print("떡볶이 몇 인분>>");
		int a = scanner.nextInt();
		
		System.out.print("김말이 몇 인분>>");
		int b = scanner.nextInt();
		
		System.out.print("쫄면 몇 인분>>");
		int c = scanner.nextInt();

		int price = a*떡복기 + b*김말이 + c*쫄면;
		System.out.println("전체 금액은 " + price + "원입니다.");
		
		scanner.close();
	}

}
