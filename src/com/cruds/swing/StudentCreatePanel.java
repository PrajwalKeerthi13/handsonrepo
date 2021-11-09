package com.cruds.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cruds.swing.StudentDAO;
import com.cruds.swing.Student;
import com.cruds.exception.StudentException;

public class StudentCreatePanel extends JPanel{

	private JButton btnCreate;
	JTextField txtRollNo;
	JLabel lblRollNo;
	JTextField txtName;
	JLabel lblName;
	JFrame parentFrame;
	JPanel currPanel;
	JPanel panel;


	public StudentCreatePanel(JFrame parentFrmae)
	{
		txtRollNo = new JTextField(5);
		lblRollNo = new JLabel("Roll No :");
		txtName = new JTextField(5);
		lblName = new JLabel("Name :");

		this.parentFrame = parentFrmae;
		currPanel = this;

		btnCreate = new JButton("Create");

		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strRollNo = txtRollNo.getText();
				String name = txtName.getText();
				System.out.println(strRollNo +":"+ name);

				Student s = null;
				try {
					s = new Student(Integer.parseInt(strRollNo), name);
					StudentDAO dao = new StudentDAO();
					if(dao.create(s))
					{
						JOptionPane.showMessageDialog(panel, "Student created succesfully", "Succes", JOptionPane.INFORMATION_MESSAGE);
						txtRollNo.setText("");
						txtName.setText("");
					}
				}

				catch(NumberFormatException ne)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, "Invalid Roll Number "+strRollNo, "Error", JOptionPane.ERROR_MESSAGE);

				}
				catch(StudentException se)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, se.getInfo(), "Error", JOptionPane.ERROR_MESSAGE);

				}
				parentFrame.remove(currPanel);
				parentFrame.add(new StudentViewPanel(parentFrame));
				parentFrame.validate();
			}
		});

		panel = new JPanel();
		panel.add(lblRollNo);
		panel.add(txtRollNo);// add field to panel
		panel.add(lblName);
		panel.add(txtName);
		add(panel);
		add(btnCreate);
	}

}
