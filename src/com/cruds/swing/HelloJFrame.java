package com.cruds.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloJFrame extends JFrame{
	private JButton btnClose;
	private JButton btnBeep;
	
	 public HelloJFrame(){
		 setTitle("Welcome To CBBMS");
		 setSize(300,300);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLayout(new FlowLayout());
		 
		 btnClose = new JButton("close");
		 btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		 btnBeep = new JButton("Beep");
		 btnBeep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getToolkit().beep();
				
			}
		});
		 add(btnClose);
		 add(btnBeep);
	//add(btnBeep, BorderLayout.SOUTH)
		 setVisible(true);
		 
	 }
	  public static void main(String[] args) {
		new HelloJFrame();
	}

}
