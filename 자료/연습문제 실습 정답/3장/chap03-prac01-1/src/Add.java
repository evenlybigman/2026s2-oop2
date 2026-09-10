/* 
  (1)의 정답 : 1부터 50까지의 정수 중 3으로 나누어 나머지가 1인 수들의 합을 구하는 코드
  실행 결과 425 출력
*/ 
public class Add {

	public static void main(String[] args) {
		int sum=0, i=1;
		while (true) {
			if(i > 50)
				break;
			sum = sum + i;
			i += 3;
		}
		System.out.println(sum);
	}

}
