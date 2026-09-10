import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClockFrame extends JFrame {
	public DigitalClockFrame() {
		setTitle("디지탈 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(new MyLabel()); // 컨텐트팬의 CENTER에 붙임
		setSize(300,200);
		setVisible(true);
	}
	
	class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		
		public String makeClockText() {
			Calendar c = Calendar.getInstance(); // 현재 시간을 가진 캘린더 객체 생성
			int hour = c.get(Calendar.HOUR_OF_DAY); // 현재 시간
			int min = c.get(Calendar.MINUTE); // 현재 분
			int second = c.get(Calendar.SECOND); // 현재 초
			
			// 시:분:초로 구성되는 문자열 만들기
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			return clockText;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					// 1초 간격으로 시간 문자열을 만들어  JLabel에 텍스트로 출력
					Thread.sleep(1000);
					setText(makeClockText());
				}
				catch(InterruptedException e){return;}
			}
		}
	}
	
	public static void main(String [] args) {
		new DigitalClockFrame();
	}
} 
