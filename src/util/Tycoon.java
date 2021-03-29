package util;

import money.MoneyGetSet;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.GameMainFrame;
import gui.GameItemClickEvent;

public class Tycoon extends JFrame {
	Container contentPane;
	public JPanel panel[];
	public JPanel mPanel;

	public static JButton BTN[];
	static ImageIcon ONE; // 아무것도 없는 상태
	public static ImageIcon TWO;
	static ImageIcon THREE;
	public static ImageIcon FOUR;

	public static int SCORE = 0;
	public static int MONEY = 0; // 보너스 초기 비용

	static int SPEED = 10000; // 10초?
	Timer[] timer;
	Timer[] ttimer;
	JLabel textLabel; // 점수
	public static  JLabel txtLbBonus; //보너스 머니 넣는 레이블
	public static JTextField textLabel2; // Money
	public static int moneyadd;
	// JLabel countLabel;
	
	GameMainFrame gm;

	class job0 extends TimerTask {
		public void run() {
			if (BTN[0].getIcon() == TWO)
				BTN[0].setIcon(THREE);
		}
	}

	class tjob0 extends TimerTask {
		public void run() {
			if (BTN[0].getIcon() == THREE)
				BTN[0].setIcon(FOUR);
		}
	}

	class job1 extends TimerTask {
		public void run() {
			if (BTN[1].getIcon() == TWO)
				BTN[1].setIcon(THREE);
		}
	}

	class tjob1 extends TimerTask {
		public void run() {
			if (BTN[1].getIcon() == THREE)
				BTN[1].setIcon(FOUR);
		}
	}

	class job2 extends TimerTask {
		public void run() {
			if (BTN[2].getIcon() == TWO)
				BTN[2].setIcon(THREE);
		}
	}

	class tjob2 extends TimerTask {
		public void run() {
			if (BTN[2].getIcon() == THREE)
				BTN[2].setIcon(FOUR);
		}
	}

	class job3 extends TimerTask {
		public void run() {
			if (BTN[3].getIcon() == TWO)
				BTN[3].setIcon(THREE);
		}
	}

	class tjob3 extends TimerTask {
		public void run() {
			if (BTN[3].getIcon() == THREE)
				BTN[3].setIcon(FOUR);
		}
	}

	class job4 extends TimerTask {
		public void run() {
			if (BTN[4].getIcon() == TWO)
				BTN[4].setIcon(THREE);
		}
	}

	class tjob4 extends TimerTask {
		public void run() {
			if (BTN[4].getIcon() == THREE)
				BTN[4].setIcon(FOUR);
		}
	}

	class job5 extends TimerTask {
		public void run() {
			if (BTN[5].getIcon() == TWO)
				BTN[5].setIcon(THREE);
		}
	}

	class tjob5 extends TimerTask {
		public void run() {
			if (BTN[5].getIcon() == THREE)
				BTN[5].setIcon(FOUR);
		}
	}

	class job6 extends TimerTask {
		public void run() {
			if (BTN[6].getIcon() == TWO)
				BTN[6].setIcon(THREE);
		}
	}

	class tjob6 extends TimerTask {
		public void run() {
			if (BTN[6].getIcon() == THREE)
				BTN[6].setIcon(FOUR);
		}
	}

	class job7 extends TimerTask {
		public void run() {
			if (BTN[7].getIcon() == TWO)
				BTN[7].setIcon(THREE);
		}
	}

	class tjob7 extends TimerTask {
		public void run() {
			if (BTN[7].getIcon() == THREE)
				BTN[7].setIcon(FOUR);
		}
	}

	class job8 extends TimerTask {
		public void run() {
			if (BTN[8].getIcon() == TWO)
				BTN[8].setIcon(THREE);
		}
	}

	class tjob8 extends TimerTask {
		public void run() {
			if (BTN[8].getIcon() == THREE)
				BTN[8].setIcon(FOUR);
		}
	}

	class job9 extends TimerTask {
		public void run() {
			if (BTN[8].getIcon() == TWO)
				SPEED -= 100;
		}
	}

	class tjob9 extends TimerTask {
		public void run() {
			if (BTN[9].getIcon() == THREE)
				BTN[9].setIcon(FOUR);
		}
	}

	public Tycoon() {
		
		gm = new GameMainFrame();
		new GameItemClickEvent();
		
		timer = new Timer[10];
		ttimer = new Timer[9];
	
		mPanel = new JPanel();
		mPanel.setLayout(null);
		mPanel.setSize(600,600);
		mPanel.setLocation(0,0);

		panel = new JPanel[9];

		
		for (int i = 0; i < 9; i++) {
			panel[i] = new JPanel();
			panel[i].setLayout(null);

		}

		ONE = new ImageIcon((getClass().getResource("/startImage.png")));
		TWO = new ImageIcon((getClass().getResource("/1.png")));
		THREE = new ImageIcon((getClass().getResource("/clear.png")));
		FOUR = new ImageIcon((getClass().getResource("/bad.png")));

		BTN = new JButton[10];
		for (int i = 0; i < 9; i++) {
			BTN[i] = new JButton("", ONE);
			BTN[i].setSize(116, 95);

		}

		timer[9] = new Timer();
		timer[9].schedule(new job9(), 1000, 1000);

		BTN[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[0].getIcon() == ONE) {
					timer[0] = new Timer();
					ttimer[0] = new Timer();
					BTN[0].setIcon(TWO);
					timer[0].schedule(new job0(), SPEED);
					ttimer[0].schedule(new tjob0(), SPEED);
				} else {
					if (BTN[0].getIcon() == TWO || BTN[0].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
						

					} else{
					SCORE += 10;
					moneyadd += 500;
					gm.GETBREAD = true;
					++gm.BREAD;
					gm.InvenBoxLayout();
									}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));
					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					BTN[0].setIcon(ONE);
					
				}
					
			}
		});
		BTN[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[1].getIcon() == ONE) {
					timer[1] = new Timer();
					ttimer[1] = new Timer();
					BTN[1].setIcon(TWO);
					timer[1].schedule(new job1(), SPEED - 5000);
					ttimer[1].schedule(new tjob1(), SPEED);
				} else {
					if (BTN[1].getIcon() == TWO || BTN[1].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[1].setIcon(ONE);

				}
			}
		});
		BTN[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[2].getIcon() == ONE) {
					timer[2] = new Timer();
					ttimer[2] = new Timer();
					BTN[2].setIcon(TWO);
					timer[2].schedule(new job2(), SPEED);
					ttimer[2].schedule(new tjob2(), SPEED/** 2 */
					);
				} else {
					if (BTN[2].getIcon() == TWO || BTN[2].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[2].setIcon(ONE);
				}
			}
		});
		BTN[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[3].getIcon() == ONE) {
					timer[3] = new Timer();
					ttimer[3] = new Timer();
					BTN[3].setIcon(TWO);
					timer[3].schedule(new job3(), SPEED - 5000);
					ttimer[3].schedule(new tjob3(), SPEED);
				} else {
					if (BTN[3].getIcon() == TWO || BTN[3].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[3].setIcon(ONE);
				}
			}
		});
		BTN[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[4].getIcon() == ONE) {
					timer[4] = new Timer();
					ttimer[4] = new Timer();
					BTN[4].setIcon(TWO);
					timer[4].schedule(new job4(), SPEED - 5000);
					ttimer[4].schedule(new tjob4(), SPEED);
				} else {
					if (BTN[4].getIcon() == TWO || BTN[4].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();

					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[4].setIcon(ONE);
				}
			}
		});
		BTN[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[5].getIcon() == ONE) {
					timer[5] = new Timer();
					ttimer[5] = new Timer();
					BTN[5].setIcon(TWO);
					timer[5].schedule(new job5(), SPEED - 5000);
					ttimer[5].schedule(new tjob5(), SPEED);
				} else {
					if (BTN[5].getIcon() == TWO || BTN[5].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[5].setIcon(ONE);
				}
			}
		});
		BTN[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[6].getIcon() == ONE) {
					timer[6] = new Timer();
					ttimer[6] = new Timer();
					BTN[6].setIcon(TWO);
					timer[6].schedule(new job6(), SPEED);
					ttimer[6].schedule(new tjob6(), SPEED * 2);
				} else {
					if (BTN[6].getIcon() == TWO || BTN[6].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[6].setIcon(ONE);
				}
			}
		});
		BTN[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[7].getIcon() == ONE) {
					timer[7] = new Timer();
					ttimer[7] = new Timer();
					BTN[7].setIcon(TWO);
					timer[7].schedule(new job7(), SPEED - 5000);
					ttimer[7].schedule(new tjob7(), SPEED);
				} else {
					if (BTN[7].getIcon() == TWO || BTN[7].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[7].setIcon(ONE);
				}
			}
		});
		BTN[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BTN[8].getIcon() == ONE) {
					timer[8] = new Timer();
					ttimer[8] = new Timer();
					BTN[8].setIcon(TWO);
					timer[8].schedule(new job8(), SPEED);
					ttimer[8].schedule(new tjob8(), SPEED * 2);
				} else {
					if (BTN[8].getIcon() == TWO || BTN[8].getIcon() == FOUR) {
						SCORE -= 10;
						moneyadd -= 50;
					} else {
						SCORE += 10;
						moneyadd += 500;
						SCORE += 10;
						gm.GETBREAD = true;
						++gm.BREAD;
						gm.InvenBoxLayout();
					}
					textLabel.setText("현재점수 :" + Integer.toString(SCORE));

					txtLbBonus.setText("보너스 머니: " +Integer.toString(MONEY));
					textLabel2.setText("" + moneyadd + "원");
					BTN[8].setIcon(ONE);
				}
			}
		});

		for (int i = 0; i < 9; i++) {

			BTN[i].setSize(116, 95);
		}
		// ************버튼사이즈*************
		BTN[0].setLocation(50, 220); //
		BTN[1].setLocation(170, 220);
		BTN[2].setLocation(290, 220);
		BTN[3].setLocation(50, 315);
		BTN[4].setLocation(170, 315);
		BTN[5].setLocation(290, 315);
		BTN[6].setLocation(50, 410);
		BTN[7].setLocation(170, 410);
		BTN[8].setLocation(290, 410);

		// contentPane.add(panel[0]);
		panel[1].add(BTN[0]);
		panel[1].add(BTN[1]);
		panel[1].add(BTN[2]);
		mPanel.add(panel[1]);
		
		panel[2].add(BTN[3]);
		panel[2].add(BTN[4]);
		panel[2].add(BTN[5]);
		mPanel.add(panel[2]);
		panel[3].add(BTN[6]);
		panel[3].add(BTN[7]);
		panel[3].add(BTN[8]);
		mPanel.add(panel[3]);

		for (int k = 0; k < 9; k++) {
			mPanel.add(BTN[k]);

		}
		setSize(600, 600);

		textLabel = new JLabel("현재점수 :" + SCORE);
		textLabel.setSize(100, 80);
		textLabel.setLocation(150, 500);
		textLabel.setFont(new Font("Gothic", Font.BOLD, 15));
		panel[4].add(textLabel);
		mPanel.add(panel[4]);

		textLabel2 = new JTextField("" + moneyadd);
		textLabel2.setSize(50, 50);
		textLabel2.setLocation(240, 90);
		textLabel2.setFont(new Font("Gothic", Font.BOLD, 15));
		panel[5].add(textLabel2);
		mPanel.add(panel[5]);

		txtLbBonus = new JLabel("보너스 머니 :" + MONEY);
		txtLbBonus.setSize(180, 80);
		txtLbBonus.setLocation(550, 50);
		txtLbBonus.setFont(new Font("Gothic", Font.BOLD, 15));
		//txtLbBonus.setBackground(Color.red);
		panel[6].add(txtLbBonus);
		mPanel.add(panel[6]);
		
		
		mPanel.add(textLabel2);
		mPanel.add(textLabel);
		mPanel.add(txtLbBonus);
		

	}
	

}
