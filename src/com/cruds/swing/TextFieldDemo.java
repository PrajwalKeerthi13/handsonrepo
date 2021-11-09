package com.cruds.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cruds.swing.StudentDAO;
import com.cruds.exception.StudentException;
import com.cruds.swing.Student;

public class TextFieldDemo extends JFrame{

	JTextField txtRollNo;
	JTextField txtName;
	JLabel lblRollNo;
	JLabel lblName;
	JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private Vector<String> colNames;
	private Vector<Vector<String>> data;
	JButton btnCreate;

	public TextFieldDemo() 
	{
		setTitle("Text Field Demo");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		colNames = new Vector<>();
		colNames.add("Roll No");
		colNames.add("name");


		txtRollNo = new JTextField(5);
		lblRollNo = new JLabel("Roll No: ");
		txtName = new JTextField(5);
		lblName = new JLabel("Name: ");
		
		StudentDAO dao = new StudentDAO();
		data = dao.getTableData();
		
		table = new JTable(data, colNames);
		scrollPane = new JScrollPane(table);

		btnCreate = new JButton("Create");

		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strRollNo = txtRollNo.getText();
				String name = txtName.getText();
				System.out.println(strRollNo + ":" + name);


				Student s = null;
				try{
					s = new Student(Integer.parseInt(strRollNo), name);
					StudentDAO dao = new   StudentDAO();
					if (dao.create(s));
					{
						JOptionPane.showMessageDialog(panel, " Student Craete succesfully","Succes",JOptionPane.INFORMATION_MESSAGE);
						txtRollNo.setText("");
						txtName.setText("");
						table.setModel(new DefaultTableModel(dao.getTableData(), colNames));
					}

				}
				catch(NumberFormatException ne)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, "Invalid Roll Number "+ strRollNo,"Error",JOptionPane.ERROR_MESSAGE);
				}
				catch(StudentException se)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, se.getInfo(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}

			});
		panel = new JPanel();
		panel.add(lblRollNo);
		panel.add(txtRollNo);//add field to panel
		panel.add(lblName);
		panel.add(txtName);
		panel.add(btnCreate);
		panel.add(scrollPane);
		add(panel);//add panel to frame
		setVisible(true);

		}

		public static void main(String[] args) {
			new TextFieldDemo();

		}

	}
