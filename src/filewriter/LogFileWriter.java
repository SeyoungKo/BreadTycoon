package filewriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import gui.MainFrame;
import money.MoneyGetSet;

public class LogFileWriter {

	//log데이터 저장 클래스
	
	String path = "C:\\Users\\세영\\Desktop\\JavaProject1\\log.txt";
	PrintWriter pw = null;
	SimpleDateFormat sdf = new SimpleDateFormat("[YYYYMMdd_HHmmss]");
	String filename = sdf.format(System.currentTimeMillis()) + ".txt";
	

	public void mm()  {
		try {
			pw = new PrintWriter(new FileWriter(path,true));
	
			String data = Integer.toString(MoneyGetSet.getMONEY());
			data = data.replace("\n", "\r\n");

			pw.write(MainFrame.LOGINTIME+"에" +MainFrame.ID+ "님이 로그인 하셨습니다. "+data);
			//사용자 id추가하기 *****
			
		} catch (Exception e) {
			
		}finally {
			if(pw !=null) {
				try {
					pw.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
			
		}
	}
	
	
}
