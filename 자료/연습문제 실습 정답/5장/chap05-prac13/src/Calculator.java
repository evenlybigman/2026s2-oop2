import java.util.Scanner;

abstract class Calc { // 추상 클래스
	public String errorMsg;
	protected int a, b; // 계산에 사용된 2개의 피연산자
	public void setValue(int a, int b) { // 2개의 피연산자에 값 설정
		this.a = a;
		this.b = b;
	}
	public abstract int calculate(); // 계산하는 추상 메소드. 서브 클래스에서 연산자에 따라 구현	
}

// 덧셈기 구현
class Add extends Calc {
	@Override
	public int calculate() {
		errorMsg = null;
		return a+b; 
	}
}

// 뺄셈기 구현
class Sub extends Calc {
	@Override
	public int calculate() {
		errorMsg = null;
		return a-b; 
	}
}

// 곱셈기 구현
class Mul extends Calc {
	@Override
	public int calculate() {
		errorMsg = null;
		return a*b;
	}
}

// 나눗셈기 구현
class Div extends Calc {
	@Override
	public int calculate() {
		if(b == 0) {
			errorMsg = "0으로 나눌 수 없음.";
			return 0;
		}
		else {
			errorMsg = null;			
			return a/b;
		}
	}
}

// 계산기 클래스 구현
public class Calculator {
	public Calculator() { }
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("두 정수와 연산자를 입력하시오>>");
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			String operator = scanner.next();
			Calc obj;
			switch (operator) {
				case "+": obj = new Add(); break;
				case "-": obj = new Sub(); break; 
				case "*": obj = new Mul(); break;
				case "/": obj = new Div(); break;
				default:
					System.out.println("잘못된 연산자입니다.");
					scanner.close();
					return;
			}
			obj.setValue(a, b); // 피연산자 a와 b 값 전달
			int res = obj.calculate();
			if(obj.errorMsg == null) { // 오류 없음
				 System.out.println("계산 결과 " + res);				
			}
			else { // 오류 발생
				 System.out.print(obj.errorMsg);
				 System.out.println(" 프로그램 종료");
				 break;
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		Calculator mycal = new Calculator();
		mycal.run();
	}

}
