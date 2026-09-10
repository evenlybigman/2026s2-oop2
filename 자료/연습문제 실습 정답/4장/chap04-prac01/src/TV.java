public class TV {
	private String maker; // 제조사
	private int size; // 크기(단위: 인치)
	private int price; // 가격(단위: 만원)
	
	public TV(String maker, int size, int price) {
		this.maker = maker;
		this.size = size;
		this.price = price;
	}
	
	public void show() {
		System.out.println(maker +"에서 만든 " + price + "만원짜리의 " + size + "인치 TV");
	}
	
	public static void main(String[] args) {
		TV tv = new TV("Samsung", 50, 300); // 300만원짜리 Samsung에서 만든 50인치 TV
		tv.show();		
	}
}
