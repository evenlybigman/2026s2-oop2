import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThreadWaitNotifyForOval extends JFrame{
	public ThreadWaitNotifyForOval() {
		setTitle("스레드를 이용한 타원 그리기"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new DrawingPanel()); // DrawingPanel 패널을 컨텐트팬으로 사용한다. 
		setSize(300,300);
		setVisible(true);
	}
	
	// 타원이 그려질 패널
	class DrawingPanel extends JPanel {
		private DrawingThread th = new DrawingThread(this); // 스레드 생성		
		private Rectangle r = new Rectangle(0,0,0,0);
		
		public DrawingPanel() {
			this.addMouseListener(new MouseHandler());
			th.start();
		}
		
		public void setObj(int x, int y, int w, int h) {
			r.x = x;
			r.y = y;
			r.width = w;
			r.height = h;
		}
		
		// 패널 내부를 그린다. 패널에 최근에 만든 타원 하나만 그린다.
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // 이전에 그린 타원을 모두 지원다.
			if(r.width == 0 || r.height == 0) return;
			g.setColor(Color.MAGENTA);
			g.fillOval(r.x, r.y, r.width, r.height); // 스레드가 새로 생성한 타원을 그린다.
		}
		
		// 마우스 리스너. 
		// 마우스가 패널에 올라오면 스레드를 깨워고 마우스가 패널에서 내려가면 스레드를 일시 중지시킨다.
		class MouseHandler extends MouseAdapter {
			public void mouseEntered(MouseEvent e) {
				setTitle("타원 그리기 실행 중"); // 프레임 타이틀 변경
				//th.wakeup(); // 스레드를 깨워 타원을 생성하도록 한다.
				wakeup(); // 스레드를 깨워 타원을 생성하도록 한다.
			}
			public void mouseExited(MouseEvent e) {
				setTitle("타원 그리기 중단"); // 프레임 타이틀 변경				
				//th.pause(); // 스레드를 중지 시켜 타원 생성을 중지하도록 한다.
				pause(); // 스레드를 중지 시켜 타원 생성을 중지하도록 한다.
			}			
		}
		
		
		// 이벤트 분배 스레드와 DrawingThread 사이의 wait-notify 동기화를 위한 멤버들
		// 메소드는 모두 synchronized를 붙여 일단 실행되면 중단없이 실행되도록 하였음
		private boolean stopFlag = false; // 스레드에게 타원 이동을 멈추라는 지시를 나타내는 멤버 변수
		
		synchronized public void pause() { // 스레드에게 타원 이동을 멈추라는 지시
			stopFlag = true;
		}
		
		synchronized public void wakeup() { // 멈춘 스레드 깨우기
			stopFlag = false; // 지금부터 멈추지 않도록 표시
			this.notify(); // wait() 상태의 스레드를 깨운다.
			// 여기서 this는 필요하지 않지만, DrawingPanel 객체를 동기화 객체로 사용하고 있음을 분명히 하기 위해 this를 사용하였음
		}
		
		synchronized public void checkStop() { // 멈춘 지시가 있었으면 멈추고, 아니면 바로 리턴
			if(stopFlag == true) { // 멈추라는 지시가 있었으면
				try {
					this.wait(); // notify()를 불러 깨워줄 때까지 대기
					// 여기서 this는 필요하지 않지만, DrawingPanel 객체를 동기화 객체로 사용하고 있음을 분명히 하기 위해 this를 사용하였음					
				} catch (InterruptedException e) {
					return;
				}
			}			
			// 멈추라는 지시가 없었으면 그냥 리턴
		}
		
		// 300ms 간격으로 타원을 생성하는 스레드
		class DrawingThread extends Thread {	
			private DrawingPanel p; // 타원을 그릴 패널 주소
			public DrawingThread(DrawingPanel p) {
				this.p = p;
			}

			// 300ms 간격으로 타원을 생성하는 스레드 코드
			public void run() {
				// 300 ms 간격으로 타원을 이동시킨다.
				while(true) {
					if(p.isValid()) { // 패널이 만들어져서 사용가능하다면
						checkStop(); // 멈춤 상태 즉 stopFlag가 true이면 wait()를 호출하여 notify()가 호출될 때까지 무한 대기한다.
						
						int x = (int)(Math.random()*p.getWidth());
						int y = (int)(Math.random()*p.getHeight());
						int w = (int)(Math.random()*100) + 1;
						int h = (int)(Math.random()*100) + 1;			
					
						p.setObj(x,y,w,h); // 패널에 그릴 타원 정보 전달
						
						// 패널로 하여금 이전에 그린 타원을 지우고 새로운 타원으로 다시 그리기 지시
						// 결과적으로 패널의 paintComponent()가 호출된다.
						p.repaint(); 		
					}
					try {
						Thread.sleep(300); // 300ms 초 동안 잠을 잔다.
					}
					catch(InterruptedException e){return;}
				}
			}
	}
	

	}
	
	public static void main(String[] args) {
		new ThreadWaitNotifyForOval();
	}
}
