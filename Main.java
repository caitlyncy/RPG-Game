import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	@SuppressWarnings("unused")
	private static final int WIDTH =1800;
	@SuppressWarnings("unused")
	private static final int HEIGHT=1600;
	
	public Main () {
		super("KeyListener Demo");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);	
		
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color RoyalBlue = new Color(22,13,193);
		
		
		setBackground(RoyalBlue);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				
				play.createFile();
				play.readFile();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				play.readFile();
				
				play.writeToFile();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}

		}); 

		
	}
	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main run = new Main();
		

	}


}