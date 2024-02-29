import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class SegmentClock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		      		String str="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		    		UIManager.setLookAndFeel(str);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					SegmentClock frame = new SegmentClock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SegmentClock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		setTitle("Segment Clock");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Time_Lb = new JLabel("??:??:??");
		Time_Lb.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Time_Lb.setHorizontalAlignment(SwingConstants.CENTER);
		Time_Lb.setBounds(95, 87, 389, 176);
		contentPane.add(Time_Lb);
		
		JTextField EnterTime_Tf = new JTextField();
		EnterTime_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		EnterTime_Tf.setBounds(0, 368, 414, 45);
		EnterTime_Tf.setColumns(10);
		contentPane.add(EnterTime_Tf);
		
		JButton Enter_Bt = new JButton("Open");
		Enter_Bt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Enter_Bt.setBounds(413, 368, 173, 45);
		Enter_Bt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				createFrame(EnterTime_Tf, Time_Lb);
			}
		});
		contentPane.add(Enter_Bt);
		
		// add Event Firing to EnterTime_Tf
		EnterTime_Tf.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				createFrame(EnterTime_Tf, Time_Lb);
			}
		});
		
		JButton Question_Bt = new JButton("");
		Question_Bt.setBounds(524, 10, 52, 45);
		Question_Bt.setIcon(new ImageIcon(new ImageIcon(SegmentClock.class.getResource("/Images/question.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		Question_Bt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame DiaFrame = new JFrame("JDialog's frame");
				showGuide(DiaFrame);
			}
		});
		contentPane.add(Question_Bt);
		
		Timing TimingObj = new Timing(Time_Lb, 7, 0, 0);
		TimingObj.TimeStart();
	}
	
	private static void createFrame(JTextField tf1, JLabel lb1) {
		String strcheck = tf1.getText();
		int hour, minute, second;
		
		try {
			if (strcheck.charAt(0) == '+') {
				String strParentTime = lb1.getText();
				hour = Integer.valueOf(strParentTime.substring(0,2)) + Integer.valueOf(strcheck.substring(1,3));
				minute = Integer.valueOf(strParentTime.substring(3,5)) + Integer.valueOf(strcheck.substring(4,6));
				second = Integer.valueOf(strParentTime.substring(6,8)) + Integer.valueOf(strcheck.substring(7,9));			
			} else {
				hour = Integer.valueOf(strcheck.substring(0,2));
				minute = Integer.valueOf(strcheck.substring(3,5));
				second = Integer.valueOf(strcheck.substring(6,8));	
			}		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "invalid time input, please try again!.", "Error format!", JOptionPane.PLAIN_MESSAGE);
			return;
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "invalid time input, please try again!.", "Error format!", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		// for debugging!
		System.out.println(hour + "/" + minute + "/" + second);
		
		JFrame newFrame = new JFrame("SegmentClock_Cloned");
		newFrame.getContentPane().setLayout(null);
		newFrame.setSize(600, 450);
		
		JLabel Time_Lb = new JLabel("??:??:??");
		Time_Lb.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Time_Lb.setHorizontalAlignment(SwingConstants.CENTER);
		Time_Lb.setBounds(95, 87, 389, 176);
		newFrame.getContentPane().add(Time_Lb);
		
		JTextField EnterTime_Tf = new JTextField();
		EnterTime_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		EnterTime_Tf.setBounds(0, 368, 414, 45);
		EnterTime_Tf.setColumns(10);
		newFrame.getContentPane().add(EnterTime_Tf);
		
		JButton Enter_Bt = new JButton("Open");
		Enter_Bt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Enter_Bt.setBounds(413, 368, 173, 45);
		Enter_Bt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				createFrame(EnterTime_Tf, Time_Lb);
			}
		});
		newFrame.getContentPane().add(Enter_Bt);
		
		// add Event Firing to EnterTime_Tf LOCAL
		EnterTime_Tf.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				createFrame(EnterTime_Tf, Time_Lb);
			}
		});
		
		JButton Question_Bt = new JButton("");
		Question_Bt.setBounds(524, 10, 52, 45);
		Question_Bt.setIcon(new ImageIcon(new ImageIcon(SegmentClock.class.getResource("/Images/question.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		Question_Bt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame DiaFrame = new JFrame("JDialog's frame");
				showGuide(DiaFrame);
			}
		});
		newFrame.getContentPane().add(Question_Bt);
		
		Timing TimingObj = new Timing(Time_Lb, hour, minute, second);
		TimingObj.TimeStart();
		
		newFrame.setVisible(true);
	}
	
	private static void showGuide(JFrame parentFrame) {
		JDialog dialog = new JDialog(parentFrame, "Guide page", true);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 20, 575, 218);
		panel.setLayout(null);
		
		JTextArea Ta1 = new JTextArea();
		Ta1.setWrapStyleWord(true);
		Ta1.setOpaque(false);
		Ta1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		Ta1.setLineWrap(true);
		Ta1.setEditable(false);
		Ta1.setText("1. \"HH:MM:SS\" - create a new clock that run the typed time.\r\n\r\n2. \"+HH:MM:SS\" - put \"+\" at the beginning in order to create a new clock that run the time added based on parent clock's timer");
		Ta1.setBounds(26, 57, 539, 151);
		panel.add(Ta1);
		
		JLabel Lb1 = new JLabel("Guide:");
		Lb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lb1.setHorizontalAlignment(SwingConstants.CENTER);
		Lb1.setBounds(168, 21, 210, 26);
		panel.add(Lb1);
		
        // Set the content of the dialog to the panel
        dialog.getContentPane().add(panel);

        // Set dialog properties
        dialog.setSize(600, 300);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
	}
}
