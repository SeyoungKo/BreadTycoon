package randomitem;

import java.util.Random;

import javax.swing.JLabel;

import gui.GameMainFrame;

public class GetSetItem {

	String word[] = { "팥", "크림", "반죽", "고구마" };
	int rnd =0;
	String str = "";
	JLabel []lb1;
	
	GameMainFrame gmf = new GameMainFrame();
	
	
	public int count =0 ;
	
	public String tmp;
	public void setStr() {
		
		//이벤트가 1분동안 3번 발생	
		
		/*for(int i=0; i<3; i++) {
			try {
				rnd = new Random().nextInt(3);
			    str = word[rnd];
			    tmp = word[rnd];
			//    Thread.sleep(1000); //10초 있다가 나오게
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
