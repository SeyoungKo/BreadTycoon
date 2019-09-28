package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import randomitem.GetSetItem;
import util.Tycoon;

public class GameItemClickEvent implements ActionListener {

	GameMainFrame gmf = new GameMainFrame(); // 버튼 속성 저장된 클래스
	GetSetItem gsi = new GetSetItem(); // while문으로 랜덤 String return
	static int VALUE = 0;

	Thread t1 = new Thread();

	@Override
	public void actionPerformed(ActionEvent e) {

		// System.out.println("test:"+e.getActionCommand());
		// 이벤트를 발생시킨 객체의 문자열을 가져온다

		String click = (String) e.getActionCommand() + "(을)를 선택하세요!";
		// System.out.println(click);
		int value = 0;

		if (gmf.qRnd.getText().equals(click)) { // GameMainFrame에서 호출되는 label의 text와 클릭한게 같으면

			// System.out.println("정답:"+gmf.qRnd.getText() + "/"+click);
			JOptionPane.showMessageDialog(null, "정답입니다!!!!(보너스 +500원)");
			Tycoon.txtLbBonus.setText(/* "보너스 머니: "+ */Integer.toString((Tycoon.MONEY += 500))); // 머니레이아웃에 추가

		
			// 글자 (label)을 텍스트필드? 에 넣음

			gsi.setStr(); // 클릭한 버튼과 문제가 같이 눌러지면 랜덤 다시 호출
			gmf.RandomItemLayout(gsi);

		} else if (gmf.qRnd.getText().equals(click) == false) {
			// System.out.println("오답:"+gmf.qRnd.getText() + "/"+click);
			JOptionPane.showMessageDialog(null, "땡....!!!");
			
			gsi.setStr();
			gmf.RandomItemLayout(gsi);
		}
	}
}

// String str = (String)e.getActionCommand();
// // "재료1"을 클릭하였다! => 게임 이벤트 메세지 알리미에 출력?
//
// ArrayList<Object> Userlist = new ArrayList<>(); //
// ++VALUE;
//
// if(VALUE >= GameMainFrame.ITEM.length) {
// //아이템 클릭횟수가 length보다 크거나 같을 때 ArrayList 비교
// Userlist.add(e.getActionCommand());
// //클릭한 버튼의 텍스트를 저장한다.
//
// System.out.println(Userlist.add(e.getActionCommand()));
// //클릭한 버튼의 텍스트를 저장한다.
