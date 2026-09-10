import java.util.Scanner;

class Player {
	private String name;
	private int winnerCount;
	private int lastGuessNumber;
	
	public Player(String name) {
		this.name = name;
		this.winnerCount = 0;
	}
	
	public String getName() { return name; }
	public int getWinnerCount() { return winnerCount; }
	public void addWinnerCount() { winnerCount++; }
	
	public int getGuessNumber() { return lastGuessNumber; }
	public void setGuessNumber(int n) { lastGuessNumber = n; }
	
	public void show() {
		System.out.print(name + ":" + winnerCount);
	}
}

public class GuessGame {
	private String name; // 게임 이름
	private Player [] players = null; // 게임이 참여하는 선수들의 레퍼런스 배열
	private Scanner scanner = new Scanner(System.in);
	
	public GuessGame(String name) { // 생성자에서 게임 이름 전달 받아 저장
		this.name = name;
	}
	
	private void createPlayers() { // 선수들 Player 객체 배열 및 Player 객체들 생성
		System.out.print("게임에 참여할 선수 수>>");
		int n = scanner.nextInt();
		players = new Player [n]; // Player [] 배열 생성
		for(int i=0; i<n; i++) {
			System.out.print("선수 이름>>");
			String name = scanner.next();
			players[i] = new Player(name); // n 명의 선수 객체 생성
		}
		// Players [] 배열 생성 완료
	}
	
	private void doGame() {
		while(true) {
			int hiddenAnswer = (int)(Math.random()*100 + 1);
			System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");
			
			// 각 선들로 부터 예측 수 입력 받기
			for(int i=0; i<players.length; i++) {
				String playerName = players[i].getName();
				System.out.print(playerName + ">>");
				int guessNumber = scanner.nextInt();
				if(guessNumber <= 0 || guessNumber > 100) {
					System.out.println("1~100사이의 숫자만 입력하세요!!");
					i--;
					continue;
				}
				players[i].setGuessNumber(guessNumber);
			}
			
			// 가장 가까운 수를 맞춘 선수 결정
			Player nearestPlayer = decideNearestPlayer(hiddenAnswer);
			
			// 이긴 선수에게 점수 부여
			nearestPlayer.addWinnerCount();
			
			System.out.println("정답은 " + hiddenAnswer + ". " + nearestPlayer.getName() + "이 이겼습니다. 승점 1점 확보!");
			System.out.print("계속하려면 yes 입력>>");
			String res = scanner.next();
			if(res.equals("yes"))
				continue;
			else { // 게임 끝. 누적된 승리 횟수가 많은 사람이 최종 승자
				Player winner = decideWinner();
				printAllWinnerCount(); // 선수별 승리 횟수 모두 출력
				System.out.print(winner.getName() + "이 최종 승리하였습니다.");
				break; // 프로그램 종료
			}
		}
			
	}
	
	// 가장 가까운 수를 맞춘 선수를 결정하여 리턴하는 메소드
	private Player decideNearestPlayer(int hiddenAnswer) {
		Player nearestPlayer = players[0]; // 선수 0 번이 답에 가장 가까운 것으로 초기화
		int nearestDiff = Math.abs(hiddenAnswer -  nearestPlayer.getGuessNumber()); // 선수0번의 답과 정답과의 차이
		for(int i=0; i<players.length; i++) {
			int diff = Math.abs(hiddenAnswer -  players[i].getGuessNumber()); // 선수 i 번의 답과 정답과의 차이
			if(diff < nearestDiff) { // 선수 i 번의 답과 정답과의 차이가 가장 작은 차이보다 더 작을 때
				nearestDiff = diff; // 정답에 가장 가까운 답 사이의 차이를 선수 i 의 차이로 수정
				nearestPlayer = players[i]; // 선수 i가 가장 가까운 답을 제시한 것으로 수정
			}				
		}
		
		return nearestPlayer;
	}
	
	// 최종 승자를 결정하여 리턴하는 메소드
	private Player decideWinner() {
		Player winner = players[0]; // 선수 0 번을 최종 승자로 초기화
		for(int i=0; i<players.length; i++) {
			if(winner.getWinnerCount() < players[i].getWinnerCount())
				winner = players[i];
		}
		
		return winner;
	}
	
	private void printAllWinnerCount() {
		for(int i=0; i<players.length; i++) {
			players[i].show();
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void run() {
		System.out.println("*** " + name + "을 시작합니다. ***");
		createPlayers();
		doGame();
	}
	
	public static void main(String[] args) {
		GuessGame game = new GuessGame("예측 게임");
		game.run();
	}

}
