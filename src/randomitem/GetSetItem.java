package randomitem;

import java.util.Random;

import javax.swing.JLabel;

import gui.GameMainFrame;

public class GetSetItem {

	String word[] = { "��", "ũ��", "����", "����" };
	int rnd =0;
	String str = "";
	JLabel []lb1;
	
	GameMainFrame gmf = new GameMainFrame();
	
	
	public int count =0 ;
	
	public String tmp;
	public void setStr() {
		
		//�̺�Ʈ�� 1�е��� 3�� �߻�	
		
		/*for(int i=0; i<3; i++) {
			try {
				rnd = new Random().nextInt(3);
			    str = word[rnd];
			    tmp = word[rnd];
			//    Thread.sleep(1000); //10�� �ִٰ� ������
			} catch (Exception e) {
				e.printStackTrace();								
			}						
		}*/		
			rnd = new Random().nextInt(3);
		    str = word[rnd];	 
			
		
		 
		}	
	
	public String getStr() {
		return str;
	}


}
