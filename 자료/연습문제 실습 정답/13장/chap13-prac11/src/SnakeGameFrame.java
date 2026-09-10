import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class SnakeGameFrame extends JFrame {
	private Thread snakeThread = null;
	private GroundPanel p = null;
	
	public SnakeGameFrame() {
		super("스네이크 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GroundPanel();
		setContentPane(p);
		setSize(400,400);
		setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
		
		snakeThread = new Thread(p);
		snakeThread.start();
	}

	class GroundPanel extends JPanel implements Runnable {
		private static final int LEFT = 0;
		private static final int RIGHT = 1;
		private static final int UP = 2;
		private static final int DOWN = 3;
		private static final int STOP = 4;
		private int direction;
		private Image img;
		private SnakeBody snakeBody;
		private final int delay = 200;
		
		public GroundPanel() {
			setLayout(null);
			snakeBody = new SnakeBody();
			snakeBody.addIn(this);
			direction = LEFT;
			this.addKeyListener(new MyKeyListener());
			ImageIcon icon = new ImageIcon("images/bg.jpg");
			img = icon.getImage();
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					GroundPanel.this.requestFocus(); // 마우스로 클릭하면 자동으로 포커스를 가지고 옴
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0,0,getWidth(), getHeight(), null);
		}
		
		@Override
		public void run() {
			// 설정된 방향 direction으로 delay 시간 간격으로 무한반복 움직임
			while(true) {
				try {
					Thread.sleep(delay);	
					if(direction == STOP) 
						continue;
					
					snakeBody.move(direction); // 설정된 방향으로 한 번 움직이기
				} catch(InterruptedException e) {
					return;
				}
			}
		}
				
		class MyKeyListener extends KeyAdapter {
			
			// 눌러진 키에 따라 방향 전환. direction 멤버 변수 변경
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction = LEFT;
					break;
				case KeyEvent.VK_RIGHT:
					direction = RIGHT;
					break;
				case KeyEvent.VK_UP:
					direction = UP;
					break;
				case KeyEvent.VK_DOWN:
					direction = DOWN;
					break;
				case KeyEvent.VK_S: // 의도적으로 삽입한 코드 s 키가 입력되면 움직이지 않음. 다른 키 입력된 다시 움직임
					direction = STOP;
					break;
					
				}
			}
		}
	}
	
	class SnakeBody {
		private Vector<JLabel> v = new Vector<JLabel>(); // 스네이크의 바디와 헤드를 저장하는 벡터
		
		public SnakeBody() {
			ImageIcon head = new ImageIcon("images/head.jpg");
			JLabel la = new JLabel(head);
			la.setSize(head.getIconWidth(), head.getIconHeight());
			la.setLocation(100, 100);
			v.add(la);

			ImageIcon body = new ImageIcon("images/body.jpg");		
			for(int i=1; i<10; i++) {
				la = new JLabel(body);
				la.setSize(body.getIconWidth(), body.getIconHeight());
				la.setLocation(100+i*20, 100);
				v.add(la);
			}
		}
		
		// 벡터에 저장된 바디와 헤드 레이블들을 패널 p에 부착하여 화면 출력
		// 초기에만 1회 호출되는 메소드 
		private void addIn(JPanel p) {
			for(int i=0; i<v.size(); i++)
				p.add(v.get(i));
		}
		
		public void move(int direction) {
			// 벡터 v에 저장된 각 바디들에 대해, 앞의 바디 위치로 이동
			for(int i=v.size()-1; i>0; i--) { 
				JLabel b = v.get(i);
				JLabel a = v.get(i-1);
				b.setLocation(a.getX(), a.getY());
			}
			
			// 스네이크의 헤드를 direction 방향으로 한 번 이동 
			JLabel head = v.get(0);
			switch(direction) {
			case GroundPanel.LEFT :
				head.setLocation(head.getX()-20, head.getY());
				break;
			case GroundPanel.RIGHT :
				head.setLocation(head.getX()+20, head.getY());
				break;
			case GroundPanel.UP :
				head.setLocation(head.getX(), head.getY()-20);
				break;
			case GroundPanel.DOWN :
				head.setLocation(head.getX(), head.getY()+20);
				break;
			}
		} 
	}

	public static void main(String[] args) {
		new SnakeGameFrame();
	}
}

