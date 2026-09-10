import java.util.Scanner;

public class MultiplesOf3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n[] = new int [10]; // 배열 생성
		
		// 10개의 양의 정수를 배열에 저장
		System.out.print("양의 정수 10개 입력>>");
		for(int i=0; i<n.length; i++) { // 배열 개수 만큼 루프
			n[i] = scanner.nextInt();
		}
		
		// 배열에서 3의 배수 출력
		int count = 0;
		System.out.print("3의 배수는...");
		for(int i=0; i<n.length; i++) { // 배열 개수 만큼 루프
			if(n[i]%3 == 0) { // n[i]가 3의 배수라면
				System.out.print(n[i] + " "); // n[i] 출력
				count++;
			}
		}
		if(count == 0)
			System.out.println("없습니다.");
		else
			System.out.println();
	
		scanner.close();
	}

}
