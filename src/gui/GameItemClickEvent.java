package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import randomitem.GetSetItem;
import util.Tycoon;

public class GameItemClickEvent implements ActionListener {

	GameMainFrame gmf = new GameMainFrame(); // ��ư �Ӽ� ����� Ŭ����
	GetSetItem gsi = new GetSetItem(); // while������ ���� String return
	static int VALUE = 0;

	Thread t1 = new Thread();

	@Override
	public void actionPerformed(ActionEvent e) {

		// System.out.println("test:"+e.getActionCommand());
		// �̺�Ʈ�� �߻���Ų ��ü�� ���ڿ��� �����´�

		String click = (String) e.getActionCommand() + "(��)�� �����ϼ���!";
		// System.out.println(click);
		int value = 0;

		if (gmf.qRnd.getText().equals(click)) { // GameMainFrame���� ȣ��Ǵ� label�� text�� Ŭ���Ѱ� ������

			// System.out.println("����:"+gmf.qRnd.getText() + "/"+click);
			JOptionPane.showMessageDialog(null, "�����Դϴ�!!!!(���ʽ� +500��)");
			Tycoon.txtLbBonus.setText(/* "���ʽ� �Ӵ�: "+ */Integer.toString((Tycoon.MONEY += 500))); // �ӴϷ��̾ƿ��� �߰�

		
			// ���� (label)�� �ؽ�Ʈ�ʵ�? �� ����

			gsi.setStr(); // Ŭ���� ��ư�� ������ ���� �������� ���� �ٽ� ȣ��
			gmf.RandomItemLayout(gsi);

		} else if (gmf.qRnd.getText().equals(click) == false) {
			// System.out.println("����:"+gmf.qRnd.getText() + "/"+click);
			JOptionPane.showMessageDialog(null, "��....!!!");
			
			gsi.setStr();
			gmf.RandomItemLayout(gsi);
		}
	}
}

// String str = (String)e.getActionCommand();
// // "���1"�� Ŭ���Ͽ���! => ���� �̺�Ʈ �޼��� �˸��̿� ���?
//
// ArrayList<Object> Userlist = new ArrayList<>(); //
// ++VALUE;
//
// if(VALUE >= GameMainFrame.ITEM.length) {
// //������ Ŭ��Ƚ���� length���� ũ�ų� ���� �� ArrayList ��
// Userlist.add(e.getActionCommand());
// //Ŭ���� ��ư�� �ؽ�Ʈ�� �����Ѵ�.
//
// System.out.println(Userlist.add(e.getActionCommand()));
// //Ŭ���� ��ư�� �ؽ�Ʈ�� �����Ѵ�.
