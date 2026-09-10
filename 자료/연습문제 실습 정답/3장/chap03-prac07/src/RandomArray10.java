public class RandomArray10 {

	public static void main(String[] args) {
		int n [] = new int [10]; // 일차원 배열 생성
		
		 // 배열에 11~19범위의 랜덤한 정수 10개를 생성하여 저장 
		for(int i=0; i<n.length; i++) {
			n[i] = (int)(Math.random()*9) + 11;// 11~19까지의 랜덤한 정수 발생
		}

		int sum = 0;
		System.out.print("랜덤한 정수들...");
		for(int i=0; i<n.length; i++) {
			System.out.print(n[i] + " ");
			sum += n[i];
		}
		
		/* 앞의 for 문은 다음과 같이 작성해도 됨
		for(int m : n) {
			System.out.print(m + " ");
			sum += m;
		}
		*/
		
		System.out.println();
		System.out.println("평균은 " + (double)sum/n.length);
		
	}

}
