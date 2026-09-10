import java.util.Scanner;

public class TwoDArrayRandom {

	public static void main(String[] args) {
		int n[][] = new int [4][4];
		
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<n.length; i++) {
			for(int j=0; j<n[i].length; j++) 
				n[i][j] = (int)(Math.random()*256);
		}
		
		System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
		
		for(int i=0; i<n.length; i++) {
			for(int j=0; j<n[i].length; j++) 
				System.out.print(n[i][j] + "\t");
			System.out.println();			
		}
		
		scanner.close();
	}

}
