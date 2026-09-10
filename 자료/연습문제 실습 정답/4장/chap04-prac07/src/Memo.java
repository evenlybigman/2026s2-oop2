public class Memo {
	private String name; // 작성자 이름
	private String time; // 메모를 작성한 시간
	private String content; // 메모 내용

	public boolean isSameName(Memo b) { // 메모 내용 출력
		if(name.equals(b.getName())) return true;
		else return false;
	}

	public String getName() { // 메모 작성자 이름 리턴
		return name;
	}
	
	public int length() { // 메모 텍스트의 길이
		return content.length();
	}

	public void show() { // 메모 내용 출력
		System.out.println(name + ", " + time + " " + content);
	}
	
	public Memo(String name, String time, String content) { // 생성자. 멤버 필드 초기화
		this.name = name;
		this.time = time;
		this.content = content;
	}

	public static void main(String[] args) {
		Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
		Memo b = new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
		Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");

		a.show();
		if(a.isSameName(b)) System.out.println("동일한 사람입니다.");
		else System.out.println("다른 사람입니다.");
		System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
	}

}