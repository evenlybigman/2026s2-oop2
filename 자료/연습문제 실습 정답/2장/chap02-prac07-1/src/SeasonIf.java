import java.util.Scanner;

public class SeasonIf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("월을 입력하세요(1~12)>>");
		int month = scanner.nextInt();
		if(month >= 3 && month <= 5)
			System.out.println("따뜻한 봄");
		else if(month >= 6 && month <= 8)
			System.out.println("즐거운 여름");
		else if(month >= 9 && month <= 11)
			System.out.println("낙엽지는 아름다운 가을");
		else if(month == 12 || month == 1 || month == 2)
			System.out.println("눈 내리는 하얀 겨울");
		else
			System.out.println("잘못입력");
		scanner.close();
	}
}
