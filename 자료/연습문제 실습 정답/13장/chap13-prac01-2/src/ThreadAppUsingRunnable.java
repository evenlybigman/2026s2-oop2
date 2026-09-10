import java.util.Scanner;

public class ThreadAppUsingRunnable {

	static public void main(String [] args) {
		// go 문자열 입력
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("시작하려면 go를 입력하세요>>");
			String input = scanner.next();
			if(input.equals("go"))
				break;
		}
		scanner.close();
		
		// 스레드 생성 및 스레드 실행 시작
		Thread th = new Thread(new CountingThread());	
		th.start();
		
		/* 다음 코드를 삽입하면 더 온전한 코드가 됨. 
		 지름 main()은 종료하지만, 스레드 th는 살아 있음
		 아래는 main()이 스레드 th가 종료되기를 기다렸다가 종료함
		try {
			th.join(); // 스레드 th가 종료되기를 기다림
			System.out.println("카운팅 스레드가 종료되어 프로그램을 종료합니다.");
		}
		catch(InterruptedException e) {	} 
		*/
		
	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
