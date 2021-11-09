package com.cruds.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class JTableDemo extends JFrame {
	
	private JTable table;
	private JPanel panel;
	private JScrollPane scrollpane;
	private JButton btnDel;
	
	//private Object[] colNames = {"Roll No","name"}
	//private Object[][] data = { {"7887","banu"},{"6690","praju"}};
	
	private Vector<String> colNames;
	private Vector<Vector<String>> data;
	
	public JTableDemo()
	{
		setTitle("JTable Demo");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		colNames = new Vector<>();
		colNames.add("RollNo");
		colNames.add("Name");
		
		StudentDAO dao =new StudentDAO();
		data = dao.getTableData();
		
		panel = new JPanel();
		table = new JTable(data, colNames);
		scrollpane = new JScrollPane(table);
		btnDel = new JButton("Delete");
		
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int idx = table.getSelectedRow();
				String selRollNo = (String) table.getModel().getValueAt(idx, 0);
				System.out.println(selRollNo);
				
				StudentDAO dao = new StudentDAO();
				dao.delete(Integer.parseInt(selRollNo));
				
				
				table.setModel(new DefaultTableModel(dao.getTableData(), colNames));
				
			}
		});
		
		panel.add(scrollpane);
		panel.add(btnDel);
		add(panel);
		setVisible(true);
			
			
	
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
		
			
			@Override
			public void run() {
				new JTableDemo();
				
				
			}
		});
	}
}
