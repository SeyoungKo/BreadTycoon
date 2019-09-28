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
	public static final int ARRLENGTH = 3; /// Panel ��
	public static JFrame F = new JFrame("Ÿ���� ����");
	public static JButton[] btns1; // ����ư 4��
	public static int BREAD = 0; // ������ �� ����
	public static boolean GETBREAD = false;

	
	public static final int VISITOR = 4; // �湮�ڸ� 4������ ���Ѵ�.

	JTextField timerLabel = new JTextField();
	ImageIcon icon ; //background�̹��� 
	
	Timer th = new Timer(timerLabel);
	public static JTextField qRnd;
	BufferedImage img = null;

	
	// VisitorRandom vr = new VisitorRandom();
	// Thread t = new Thread(vr);

	JTextField jt1 = new JTextField(); // �̺�Ʈ �ؽ�Ʈ
	
	public GameMainFrame() {
	

	
		
	}

	

	public void GameMainFramee() {

		Tycoon ty = new Tycoon();
		F.add(ty.mPanel); // �ؾ �����е� ȣ���ϴ� �κ�

	}

	public void GameFrame() {

		F.getContentPane().setLayout(null);
		F.setLocation(250, 100);
		F.setSize(800, 800);
		F.setBackground(Color.WHITE);
		F.setVisible(true);

		String gameRule = "****���Ӽ���****\n" + "1.�ؾ �� ������ ������ 10���� ���� �� �ֽ��ϴ�\n" + "2.���� ���� �ؾ�� Ŭ���ϸ� -10�� ���ҵ˴ϴ�.\n"
				+ "3.�ؾ �� ���� ���� �� ���� 500���� ���� �� �ֽ��ϴ�.\n" + "4.���� ���� �ؾ�� Ŭ���ϸ� 50���� ���ѱ�ϴ�.\n+"
						+ "5.���� �̺�Ʈ â�� �ִ� ��Ḧ Ŭ���ϸ� ���ʽ��� ���� �� �ֽ��ϴ�!\n"+
						"6.[�ҸӴ�]�� �ؾ 1 ����, [�Ҿƹ���]�� �ؾ 2���� , [�ճ�]�� �ؾ 3����, [����]�� �ؾ 4���� ������ �մϴ�.";

		JOptionPane.showMessageDialog(null, gameRule);

		/*
		 * JButton btnStart = new JButton("���ӽ���!"); JTextArea tInven = new JTextArea();
		 */
		MenuBar mb = new MenuBar(); // ���ӽ���, �������� �޴���
		Menu mStart = new Menu("����");
		MenuItem miS = new Menu("���� ����!");
		mStart.add(miS);

		Menu mFin = new Menu("����");
		MenuItem miFin = new Menu("���� ����");
		mFin.add(miFin);

		mb.add(mStart);
		mb.add(mFin);
		F.setMenuBar(mb);

		/************** ���ӽ���! ******************/
		miS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ���� �����ϴ� Ŭ����, �޼ҵ� ȣ��
			}
		});

		/**************** �������� *****************/
		miFin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(F, "������ �����Ͻðڽ��ϱ�?");
				if (JOptionPane.OK_OPTION == 1) {
					F.setDefaultCloseOperation(F.getDefaultCloseOperation());
				}
			}
		});

		// ***�޼ҵ� ȣ�� **
		TimerBoxLayout();
		RandomItemLayout(new GetSetItem());
		SaveMoneyBoxLayout();
		InvenBoxLayout();
		ItemButton();
		VisitorBoxLayout();
		GameMainFramee();
		InfoTextField();
	}

	public void TimerBoxLayout() { // Ÿ�̸� �ڽ����̾ƿ�

		// JPanel pTimer = new JPanel();
		JLabel textLabel = new JLabel();

		textLabel.setText("TIME");
		textLabel.setSize(90, 60);
		textLabel.setLocation(40, 18);

		timerLabel.setSize(130, 130);
		timerLabel.setLocation(40, 60);

		// timerLabel.setOpaque(); ///�����ϰ�
		timerLabel.setFont(new Font("Serif", Font.BOLD, 18));
		timerLabel.setForeground(Color.black);

		setSize(250, 150);
		setVisible(true);
		th.start();

		F.getContentPane().add(textLabel);
		F.getContentPane().add(timerLabel);

	}

	public void SaveMoneyBoxLayout() { // �Ӵ� ���̾ƿ�

		new Tycoon();
		MoneyGetSet mg = new MoneyGetSet();

		JPanel pMoney = new JPanel();
		JLabel money = new JLabel();
		// money.setText(Integer.toString(MoneyGetSet.getMONEY())+"��");

		// money.setText("" + MoneyGetSet.getMONEY());
		money.setText("" + Tycoon.MONEY + "��");

		money.setSize(50, 50);
		money.setLocation(240, 90);
		money.setFont((new Font("Gothic", Font.BOLD, 15)));

		pMoney.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "MONEY")); // Ÿ��Ʋ �̸�
		pMoney.setLayout(new GridLayout(150, 150, 20, 20));

		pMoney.setSize(130, 130);
		pMoney.setLocation(200, 50); // x��ǥ �̵�

		F.getContentPane().add(money);
		F.getContentPane().add(pMoney);

	}

	public void InvenBoxLayout() { // �κ� ����

		/*JPanel pMoney = new JPanel();
		pMoney.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "INVENTORY")); // Ÿ��Ʋ �̸�
		pMoney.setLayout(new GridLayout(150, 150, 20, 20));

		pMoney.setSize(200, 200);
		pMoney.setLocation(550, 300); // x��ǥ �̵�
	*/

		JPanel pMoney = new JPanel();

		pMoney.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "INVENTORY")); // Ÿ��Ʋ �̸�
		pMoney.setLayout(new GridLayout(2, 2));
		pMoney.setSize(200, 200);
		pMoney.setLocation(550, 300); // x��ǥ �̵�

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

	public void RandomItemLayout(GetSetItem gsi) { // ���� ������ ����		
		
		gsi.setStr();
		
		String word[] = { "��", "ũ��", "����", "����" };


		qRnd = new JTextField(); //�̺�Ʈ �ؽ�Ʈ �ߴ� label
		 System.out.println("dd"+gsi.getStr());

		qRnd.setText(gsi.getStr()+"(��)�� �����ϼ���!"); //Ŭ���ϼ��� !!
		
		qRnd.setSize(150, 30);
		qRnd.setLocation(570, 550);
		qRnd.setFont((new Font("Gothic", Font.BOLD, 14)));

		JPanel jpRnd = new JPanel();
		jpRnd.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "RANDOM EVENT")); // Ÿ��Ʋ �̸�
		jpRnd.setLayout(new GridLayout(150, 150, 20, 20));

		jpRnd.setSize(200, 150);
		jpRnd.setLocation(550, 500); // x��ǥ �̵�

		F.getContentPane().add(qRnd);
		F.getContentPane().add(jpRnd);

	}

	public void InfoTextField() { // ���� �̺�Ʈ �޻��� �˸���
		// ItemButton();

		// 1�е��� 4�� �̺�Ʈ �߻���Ű��
		// word[rnd]�� Ŭ���ض� !!

	}

	public void VisitorBoxLayout() { // �湮�� ����: �ҸӴ�: �ƺ�: �Ҿƹ���

		JPanel pVisit = null;

		// ��ư 4�� ��Ŭ�� (���� 4)�� �Ǹ� �ٽ� ������ ���

		int random = (int) (Math.random() * VISITOR) + 1; // 1~4����
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



		pVisit.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "�湮�ڰ� ��Ÿ����!")); // Ÿ��Ʋ �̸�
		pVisit.setLayout(new GridLayout(150, 150, 20, 20));

		pVisit.setBounds(20, 25, 100, 50);
		pVisit.setSize(200, 200);
		pVisit.setLocation(550, 100); // x��ǥ �̵�

		// t.start();
		F.getContentPane().add(pVisit);

	}

	public void ItemButton() {

		String[] path = { "redbean.png",
				 "cream.png",
				"base.png",
				"sweet_potato.png" };

		// �̹��� �ҷ��ͼ� ��ư�� ���� �ֱ�!!
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

		// ****************��� *
		btns1[0].setText("��");
		btns1[1].setText("ũ��");
		btns1[2].setText("����");
		btns1[3].setText("����");

		for (int i = 0; i < btns1.length; i++) {
			btns1[i].addActionListener(new GameItemClickEvent());

		}

		// ��ư�� Ŭ���ϸ� ActionListener �̺�Ʈ ȣ�� ,
		// int�� arraylist�� ����
	}
	
	public void Bonus() { //���ʽ� �Ӵ� ���̾ƿ�
		
	}
	
	

	static ActionListener al = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}
	};

}
