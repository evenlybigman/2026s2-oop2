package week05;

import java.util.Scanner;

interface Istack {
	int capacity();
	int length();
	boolean push(String val);
	
	String pop();
}

class StringStack implements Istack {
	private String[] arr;
	private int top = 0;
	
	public StringStack(int size) {
		arr = new String[size];
	}
	
	@Override
	public int capacity() { return arr.length; }
	
	@Override
	public int length() { return top; }
	
	@Override
	public boolean push(String val) {
		if (top == arr.length) return false;
		
		else {
			arr[top++] = val;
			return true;
		}
	}
	
	@Override
	public String pop() {
		return arr[--top];
	}
}

public class No5_11 {
	public static void main(String [] args) {
		System.out.println("제출자:김주혁\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("스택 용량>>");
		int size = scanner.nextInt();
		Istack stack = new StringStack(size);
		
		while(true) {
			System.out.print("문자열 입력>>");
			String s = scanner.next();

			if (s.equals("그만"))
				break;

			if (!stack.push(s)) {
				System.out.println("스택이 꽉 차서 " + s + "저장 불가");
			}
		}
		
		System.out.print("스택에 저장된 문자열 팝: ");
		int n = stack.length();
		for (int i = 0; i < n; i++)
			System.out.print(stack.pop() + " ");
		System.out.println();

		scanner.close();
	}
}
