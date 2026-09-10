// 노래 한 곡을 나타내는 클래스
public class Song {
	private String title; // 제목
	private String singer; // 가수
	private int year; // 발표 년도
	private String country; // 나라
	
	public Song(String title, String singer, int year, String country) {
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.country = country;
	}
	
	public void show() {
		System.out.println(year+"년 " + country + "의 " + singer + "가 부른 " + title);
	}
	
	public static void main(String[] args) {
		Song song = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국");
		song.show();
	}

}
