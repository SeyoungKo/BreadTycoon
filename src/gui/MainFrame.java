package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import filewriter.LogFileWriter;

public class MainFrame {

	public static String ID = "";
	public static String DATA = "";
	
	public static long LOGINTIME = 0;

	public static void main(String[] args) {

		 new GameMainFrame();
		// MainPad mp = new MainPad();
		LogFileWriter lfw = new LogFileWriter();
		lfw.mm();

		
		Frame f = new Frame("타이쿤 게임 메인화면");
		f.setLayout(null);
		f.setBounds(500, 500, 750, 500);
		f.setSize(550, 550);
		f.setLocation(250, 250);

		Button btnLog = new Button("로그인");

		Button btnExit = new Button("종료");

		JLabel jp1 = new JLabel();
		JLabel jp2 = new JLabel();
		JLabel jp3 = new JLabel();
		JLabel jp4 = new JLabel();
		
		JLabel jlb = new JLabel();
		
		jlb.setSize(90,90);
		jlb.setLocation(200,300);
		jlb.setIcon(new ImageIcon("fish.png"));

		
		jp1.setSize(100,100);
		jp1.setIcon(new ImageIcon("visitor1_small.png"));
		jp2.setSize(100,100);
		jp2.setIcon(new ImageIcon("visitor2_small.png"));
		jp3.setSize(100,100);
		jp3.setIcon(new ImageIcon("visitor3_small.png"));
		jp4.setSize(100,100);
		jp4.setIcon(new ImageIcon("visitor4_small.png"));
		
		
		jp1.setLocation(80,450);
		jp2.setLocation(180,450);
		jp3.setLocation(285,450);
		jp4.setLocation(390,450);
		
		
		
		btnLog.setBounds(90, 110, 130, 50);
	//	btnJoin.setBounds(btnLog.getBounds());
		btnExit.setBounds(btnLog.getBounds());

	//	btnJoin.setLocation(btnLog.getWidth() + btnLog.getX() + 50, btnLog.getY());
		btnExit.setLocation(btnLog.getWidth() + btnLog.getX() + 100, btnLog.getY());

	//	f.add(btnJoin);
		f.add(jp1);
		f.add(jp2);
		f.add(jp3);
		f.add(jp4);
		f.add(jlb);
		
		f.add(btnLog);
		f.add(btnExit);

		f.setVisible(true);

		// **************************************
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
		// ***************************************
		btnLog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ID = JOptionPane.showInputDialog("아이디:");
				String pwd = JOptionPane.showInputDialog("비밀번호: ");

			
				JOptionPane.showMessageDialog(null, ID + "님 환영합니다!");
				LOGINTIME =System.currentTimeMillis() / 1000; //로그인 시각
				LogFileWriter lf = new LogFileWriter();
				lf.mm();
				

				GameMainFrame gmf = new GameMainFrame();
				gmf.GameFrame();

			}
		});
		// **************************************
	/*	btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f2 = new JFrame("회원가입");

				f2.setBounds(500, 500, 750, 500);
				f2.setSize(400, 400);
				f2.setLocation(250, 250);

				Label lb1 = new Label("회원가입");

				Panel p1 = new Panel();
				p1.setSize(100, 100);
				p1.setLocation(200, 200);
				Panel p2 = new Panel();
				p2.setSize(100, 100);
				p2.setLocation(300, 300);
				Panel p3 = new Panel();

				Label lID = new Label("아이디");
				Label lPwd = new Label("비밀번호");

				JTextField tId = new JTextField(10);
				JTextField tPwd = new JTextField(10);
				Button btnOk = new Button("완료");
				Button btnCancel = new Button("취소");

				Font f = new Font(" ", Font.BOLD, 25);
				p1.setFont(f);

				p1.add(lb1);
				p2.add(lID);// Panel에 아이디 label 붙임
				p2.add(tId);
				p2.add(lPwd); // Panel에 비밀번호 label 붙임
				p2.add(tPwd);
				p2.add(btnOk);
				p2.add(btnCancel);

				f2.getContentPane().add(BorderLayout.NORTH, p1);
				f2.getContentPane().add(BorderLayout.CENTER, p2);
				f2.getContentPane().add(BorderLayout.SOUTH, p3);

				f2.setVisible(true);

				f2.setDefaultCloseOperation(f2.getDefaultCloseOperation());
			}
		});*/
		// *************************************

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
