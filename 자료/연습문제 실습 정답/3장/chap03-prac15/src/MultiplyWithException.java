import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplyWithException {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("곱하고자 하는 정수 2개 입력>>");
			try {
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				System.out.println(n + "x" + m + "=" + n*m);
				break;
			} catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요!");
				scanner.nextLine(); // <Enter> 키를 포함하여 현재 입력된 것들을 모두 읽어 버퍼를 비운다.
				continue;
			}
		}
		scanner.close();
	}

}
