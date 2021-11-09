package com.cruds.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class NavigationDemo extends JFrame{
	
	JFrame frame;
	
	NavigationDemo()
	{
		frame = this;
		setTitle("Navigation Demo");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new StudentCreatePanel(frame));
		
		setVisible(true);
		}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new NavigationDemo();
				
			}
		});

	}

}