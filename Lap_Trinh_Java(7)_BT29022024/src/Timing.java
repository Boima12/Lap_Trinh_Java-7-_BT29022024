import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

public class Timing {
	private JLabel lb1;
	
	private Calendar calendar = Calendar.getInstance();
	private Date customDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public Timing(JLabel lb1, int hour, int minute, int second) {
		this.lb1 = lb1;
		
		// setup 
		calendar.set(1, 1, 1, hour, minute, second);
	}
	
	public void TimeStart() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						calendar.add(Calendar.SECOND, 1);
						customDate = calendar.getTime();
						lb1.setText(sdf.format(customDate));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		thread.start();
	}
	
}