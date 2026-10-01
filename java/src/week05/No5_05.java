package week05;

class Shape { // 슈퍼 클래스
	public Shape next; // 그림 5-22의 코드를 위해 필요한 부분
	public Shape() { next = null; } // 그림 5-22의 코드를 위해 필요한 부분
	
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	@Override
	public void draw() { // 메소드 오버라이딩
		System.out.println("Line");
	}
}

class Rect extends Shape {
	@Override
	public void draw() { // 메소드 오버라이딩
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	@Override
	public void draw() { // 메소드 오버라이딩
		System.out.println("Circle");
	}
}

public class No5_05 {
	public static void main(String [] args) {
		System.out.println("제출자:김주혁\n");
		
		Shape start, last, obj;
		
		start = new Line();
		last = start;
		obj = new Rect();
		last.next = obj;
		last = obj;
		obj = new Line();
		last.next = obj;
		last = obj;
		obj = new Circle();
		last.next = obj;
		
		Shape p = start;
		while(p != null) {
			p.draw();
			p = p.next;
		}
	}
}
