class TV {
	private int size;
	public TV(int size) { this.size = size; }
	protected int getSize() { return size; }
}

public class ColorTV extends TV {
	private int colors;
	public ColorTV(int size, int colors) {
		super(size);
		this.colors = colors;
	}
	
	public void printProperty() {
		System.out.println(getSize() + "인치 " + colors + "컬러");
	}
	
	public static void main(String[] args) {
		ColorTV myTv = new ColorTV(65, 65536);
		myTv.printProperty();
	}
}
