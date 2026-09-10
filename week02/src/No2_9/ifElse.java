package No2_9;
import java.util.Scanner;

public class ifElse {
	public static void main(String args[]) {
		System.out.println("제출자:김주혁\n");
		
		System.out.print("점 (x, y)의 좌표 입력>>");
		
		Scanner scanner = new Scanner(System.in);
		int x,y;
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		if ((x > 10 && x < 200) && (y > 10 && y < 300)) {
			System.out.println("(" + x + "," + y + ")는 사각형 안에 있습니다.");
		}
		else if (((x > 10 && x < 200) && (y == 10 || y ==300)) || ((y > 10 && y < 300) && (x == 10 || x == 200))) {
			System.out.println("(" + x + "," + y + ")는 사각형 선 상에 있습니다.");
		}
		else {
			System.out.println("(" + x + "," + y + ")는 사각형 선 밖에 있습니다.");
		}
	}
}

