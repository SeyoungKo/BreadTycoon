package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import money.MoneyGetSet;
import randomitem.GetSetItem;
import timer.Timer;
import util.Tycoon;

public class GameMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ARRLENGTH = 3; /// Panel 수
	public static JFrame F = new JFrame("타이쿤 게임");
	public static JButton[] btns1; // 재료버튼 4개
	public static int BREAD = 0; // 증가할 빵 개수
	public static boolean GETBREAD = false;

	
	public static final int VISITOR = 4; // 방문자를 4명으로 정한다.

	JTextField timerLabel = new JTextField();
	ImageIcon icon ; //background이미지 
	
	Timer th = new Timer(timerLabel);
	public static JTextField qRnd;
	BufferedImage img = null;

	
	// VisitorRandom vr = new VisitorRandom();
	// Thread t = new Thread(vr);

	JTextField jt1 = new JTextField(); // 이벤트 텍스트
	
	public GameMainFrame() {
	

	
		
	}

	

	public void GameMainFramee() {

		Tycoon ty = new Tycoon();
		F.add(ty.mPanel); // 붕어빵 메인패드 호출하는 부분

	}

	public void GameFrame() {

		F.getContentPane().setLayout(null);
		F.setLocation(250, 100);
		F.setSize(800, 800);
		F.setBackground(Color.WHITE);
		F.setVisible(true);

		String gameRule = "****게임설명****\n" + "1.붕어빵 한 개만들 때마다 10점을 얻을 수 있습니다\n" + "2.익지 않은 붕어빵을 클릭하면 -10점 감소됩니다.\n"
				+ "3.붕어빵 한 개를 만들 때 마다 500원을 벌을 수 있습니다.\n" + "4.익지 않은 붕어빵을 클릭하면 50원을 빼앗깁니다.\n+"
						+ "5.랜덤 이벤트 창에 있는 재료를 클릭하면 보너스를 받을 수 있습니다!\n"+
						"6.[할머니]는 붕어빵 1 개를, [할아버지]는 붕어빵 2개를 , [손녀]는 붕어빵 3개를, [손자]는 붕어빵 4개를 만들어야 합니다.";

		JOptionPane.showMessageDialog(null, gameRule);

		/*
		 * JButton btnStart = new JButton("게임시작!"); JTextArea tInven = new JTextArea();
		 */
		MenuBar mb = new MenuBar(); // 게임시작, 게임종료 메뉴바
		Menu mStart = new Menu("시작");
		MenuItem miS = new Menu("게임 시작!");
		mStart.add(miS);

		Menu mFin = new Menu("종료");
		MenuItem miFin = new Menu("게임 종료");
		mFin.add(miFin);

		mb.add(mStart);
		mb.add(mFin);
		F.setMenuBar(mb);

		/************** 게임시작! ******************/
		miS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 게임 시작하는 클래스, 메소드 호출
			}
		});

		/**************** 게임종료 *****************/
		miFin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(F, "정말로 종료하시겠습니까?");
				if (JOptionPane.OK_OPTION == 1) {
					F.setDefaultCloseOperation(F.getDefaultCloseOperation());
				}
			}
		});

		// ***메소드 호출 **
		TimerBoxLayout();
		RandomItemLayout(new GetSetItem());
		SaveMoneyBoxLayout();
		InvenBoxLayout();
		ItemButton();
		VisitorBoxLayout();
		GameMainFramee();
		InfoTextField();
	}

	public void TimerBoxLayout() { // 타이머 박스레이아웃

		// JPanel pTimer = new JPanel();
		JLabel textLabel = new JLabel();

		textLabel.setText("TIME");
		textLabel.setSize(90, 60);
		textLabel.setLocation(40, 18);

		timerLabel.setSize(130, 130);
		timerLabel.setLocation(40, 60);

		// timerLabel.setOpaque(); ///투명하게
		timerLabel.setFont(new Font("Serif", Font.BOLD, 18));
		timerLabel.setForeground(Color.black);

		setSize(250, 150);
		setVisible(true);
		th.start();

		F.getContentPane().add(textLabel);
		F.getContentPane().add(timerLabel);

	}

	public void SaveMoneyBoxLayout() { // 머니 레이아웃

		new Tycoon();
		MoneyGetSet mg = new MoneyGetSet();

		JPanel pMoney = new JPanel();
		JLabel money = new JLabel();
		// money.setText(Integer.toString(MoneyGetSet.getMONEY())+"원");

		// money.setText("" + MoneyGetSet.getMONEY());
		money.setText("" + Tycoon.MONEY + "원");

		money.setSize(50, 50);
		money.setLocation(240, 90);
		money.setFont((new Font("Gothic", Font.BOLD, 15)));

		pMoney.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "MONEY")); // 타이틀 이름
		pMoney.setLayout(new GridLayout(150, 150, 20, 20));

		pMoney.setSize(130, 130);
		pMoney.setLocation(200, 50); // x좌표 이동

		F.getContentPane().add(money);
		F.getContentPane().add(pMoney);

	}

	public void InvenBoxLayout() { // 인벤 영역

		/*JPanel pMoney = new JPanel();
		pMoney.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "INVENTORY")); // 타이틀 이름
		pMoney.setLayout(new GridLayout(150, 150, 20, 20));

		pMoney.setSize(200, 200);
		pMoney.setLocation(550, 300); // x좌표 이동
	*/

		JPanel pMoney = new JPanel();

		pMoney.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "INVENTORY")); // 타이틀 이름
		pMoney.setLayout(new GridLayout(2, 2));
		pMoney.setSize(200, 200);
		pMoney.setLocation(550, 300); // x좌표 이동

		ImageIcon img = new ImageIcon((getClass().getResource("/3.new.png")));
		JLabel[] imgBread = new JLabel[2 * 2];
		
		
		for (int i = 0; i < imgBread.length; ++i) {
			imgBread[i] = new JLabel(img);
		}
		
		
		if (BREAD > 0 && BREAD <= 5 && GETBREAD == true) {
		for (int j = 0; j < BREAD; ++j) {
		
				
				pMoney.add(imgBread[j]);
			}
		}
		
		 pMoney.setVisible(true);
			F.getContentPane().add(pMoney);

	}

	public void RandomItemLayout(GetSetItem gsi) { // 랜덤 아이템 영역		
		
		gsi.setStr();
		
		String word[] = { "팥", "크림", "반죽", "고구마" };


		qRnd = new JTextField(); //이벤트 텍스트 뜨는 label
		 System.out.println("dd"+gsi.getStr());

		qRnd.setText(gsi.getStr()+"(을)를 선택하세요!"); //클릭하세요 !!
		
		qRnd.setSize(150, 30);
		qRnd.setLocation(570, 550);
		qRnd.setFont((new Font("Gothic", Font.BOLD, 14)));

		JPanel jpRnd = new JPanel();
		jpRnd.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "RANDOM EVENT")); // 타이틀 이름
		jpRnd.setLayout(new GridLayout(150, 150, 20, 20));

		jpRnd.setSize(200, 150);
		jpRnd.setLocation(550, 500); // x좌표 이동

		F.getContentPane().add(qRnd);
		F.getContentPane().add(jpRnd);

	}

	public void InfoTextField() { // 게임 이벤트 메새지 알리미
		// ItemButton();

		// 1분동안 4번 이벤트 발생시키기
		// word[rnd]번 클릭해라 !!

	}

	public void VisitorBoxLayout() { // 방문자 엄마: 할머니: 아빠: 할아버지

		JPanel pVisit = null;

		// 버튼 4개 다클릭 (누적 4)가 되면 다시 돌리기 계속

		int random = (int) (Math.random() * VISITOR) + 1; // 1~4랜덤
		switch (random) {

		case 1:
			ImageIcon icon1 = new ImageIcon((getClass().getResource("/visitor1.png")));
			pVisit = new JPanel() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					g.drawImage(icon1.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}

			};
			break;
		case 2:
			ImageIcon icon2 = new ImageIcon((getClass().getResource("/visitor2.png")));
			pVisit = new JPanel() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					g.drawImage(icon2.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}

			};
			break;
		case 3:
			ImageIcon icon3 = new ImageIcon((getClass().getResource("/visitor3.png")));
			pVisit = new JPanel() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					g.drawImage(icon3.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}

			};
			break;
		case 4:
			ImageIcon icon4 = new ImageIcon((getClass().getResource("/visitor4.png")));
			pVisit = new JPanel() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					g.drawImage(icon4.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}

			};
			break;

		}



		pVisit.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "방문자가 나타났다!")); // 타이틀 이름
		pVisit.setLayout(new GridLayout(150, 150, 20, 20));

		pVisit.setBounds(20, 25, 100, 50);
		pVisit.setSize(200, 200);
		pVisit.setLocation(550, 100); // x좌표 이동

		// t.start();
		F.getContentPane().add(pVisit);

	}

	public void ItemButton() {

		String[] path = { "redbean.png",
				 "cream.png",
				"base.png",
				"sweet_potato.png" };

		// 이미지 불러와서 버튼에 집어 넣기!!
		btns1 = new JButton[4];

			btns1[0] = new JButton("" + 0, new ImageIcon(path[0]));
			btns1[1] = new JButton("" + 1, new ImageIcon(path[1]));
			btns1[2] = new JButton("" + 2, new ImageIcon(path[2]));
			btns1[3] = new JButton("" + 3, new ImageIcon(path[3]));

			for (int i = 0; i < btns1.length; ++i) {			
			btns1[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					// int rnd = new Random().nextInt(ARRLENGTH * ARRLENGTH);
				}

			});
		}

		F.getContentPane().add(btns1[0]);
		btns1[0].setSize(85, 85);
		btns1[0].setLocation(420, 180);
		btns1[0].setBorderPainted(false);
		F.getContentPane().add(btns1[1]);
		btns1[1].setSize(85, 85);
		btns1[1].setLocation(420, 280);
		btns1[0].setBorderPainted(false);
		F.getContentPane().add(btns1[2]);
		btns1[2].setSize(85, 85);
		btns1[2].setLocation(420, 380);
		btns1[0].setBorderPainted(false);
		F.getContentPane().add(btns1[3]);
		btns1[3].setSize(85, 85);
		btns1[3].setLocation(420, 480);
		btns1[0].setBorderPainted(false);

		// ****************재료 *
		btns1[0].setText("팥");
		btns1[1].setText("크림");
		btns1[2].setText("반죽");
		btns1[3].setText("고구마");

		for (int i = 0; i < btns1.length; i++) {
			btns1[i].addActionListener(new GameItemClickEvent());

		}

		// 버튼을 클릭하면 ActionListener 이벤트 호출 ,
		// int값 arraylist에 저장
	}
	
	public void Bonus() { //보너스 머니 레이아웃
		
	}
	
	

	static ActionListener al = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}
	};

}
