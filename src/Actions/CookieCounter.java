package Actions;

import java.util.Timer;
import java.util.TimerTask;

public class CookieCounter {
	
	Timer count;

	public CookieCounter() {
		count = new Timer();
		count.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {

				Main.cookies += Main.cps/100;
				
			}
		}, 0, 10);
	}

}
