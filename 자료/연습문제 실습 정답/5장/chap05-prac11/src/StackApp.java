import java.util.Scanner;

interface IStack {
	int capacity(); // 스택에 저장 가능한 개수 리턴
	int length(); // 스택에 현재 저장된 개수 리턴
	boolean push(String val); // 스택의 톱(top)에 문자열 저장하고 true 리턴. 
							// 꽉 차서 넣을 수 없으면 false 리턴
	String pop(); // 스택의 톱(top)에 저장된 문자열 리턴. 스택이 비어 있으면 null 리턴
}

class StringStack implements IStack {
	private int top = 0; // 삽입할 위치(mem [] 배열에 대한 인덱스)
	private String [] mem = null;
	
	public StringStack(int capacity) {
		mem = new String [capacity];
	}
	
	@Override
	public int capacity() {
		return mem.length;
	}

	@Override
	public int length() {
		return top;
	}

	@Override
	public boolean push(String val) {
		if(top == mem.length)
			return false;
		
		mem[top] = val;
		top++;
		return true;
	}

	@Override
	public String pop() {
		if(top == 0)
			return null;
		
		top--;
		String str = mem[top];
		return str;
	}
}

public class StackApp { 
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("스택 용량>>");
		int cap = scanner.nextInt();
		StringStack sStack = new StringStack(cap);
		
		while(true) {
			System.out.print("문자열 입력>>");
			String str = scanner.next();
			if(str.equals("그만"))
				break;
			
			if(sStack.push(str) == false) {
				System.out.println("스택이 꽉 차서 " + str + " 저장 불가");
			}
		}

		System.out.print("스택에 저장된 문자열 팝 : ");
		while(true) {
			String str = sStack.pop();
			if(str == null) {
				break; // 스택이 비어 있음
			}
			System.out.print(str + " ");
		}
		System.out.println();
		scanner.close();
	}
	
}
