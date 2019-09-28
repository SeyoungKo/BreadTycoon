package timer;

import java.awt.event.WindowAdapter;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import filewriter.LogFileWriter;
import gui.MainFrame;
import money.MoneyGetSet;

public class Timer extends Thread {

	// ************≈∏¿Ã∏”***************

	static final int TIME = 60;
	JTextField timerLabel;
	String hms;
	public static long LOGOUTTIME = 0;

	public static String msg = "TIME OVER!";

	public Timer() {

	}

	public Timer(JTextField timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void run() {
		long millis = 3600000;

		for (int TIME = 1; TIME <= 60; TIME++) {

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hms = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
					// TimeUnit.MILLISECONDS.toMinutes(millis) -
					// TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis)
							- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

			timerLabel.setText(hms);
			millis -= 1000;
		}

		JOptionPane.showMessageDialog(null, msg);
		LogFileWriter lf = new LogFileWriter();
		lf.mm();
		LOGOUTTIME = System.currentTimeMillis();
		MainFrame.DATA += Integer.toString(MoneyGetSet.getMONEY());
		System.exit(0);

	}

}
