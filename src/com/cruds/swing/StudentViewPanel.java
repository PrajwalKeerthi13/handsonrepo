package com.cruds.swing;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class StudentViewPanel extends JPanel {
	JFrame parentFrame;
	JPanel currPanel;

	JButton btnBack;

	StudentViewPanel(JFrame parentFrame)
	{

		this.parentFrame=parentFrame;
		currPanel=this;

		btnBack=new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				parentFrame.remove(currPanel);
				parentFrame.add(new StudentCreatePanel(parentFrame));
				parentFrame.revalidate();
			}
		});

		add(btnBack);

	}



}
