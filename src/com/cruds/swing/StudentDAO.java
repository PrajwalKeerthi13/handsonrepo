package com.cruds.swing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.cruds.exception.StudentException;
import com.cruds.swing.DBConnectionManager;
import com.cruds.swing.Student;

public class StudentDAO {

	public Vector<Vector<String>> getTableData() 
	{
		String sql = "select rollno,name from student";
		Vector<Vector<String>> data = new Vector<>();

		try (Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs!=null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				data.add(row);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean delete(int rollNo)
	{
		String sql = "delete from Student where rollno = ?";
		int rows =0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rollNo);
			rows = ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();

		}
		return rows>0;
	}

	public boolean update(Student s)
	{
		String sql = "update student set name = ? where = ? ";
		int rows = 0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, s.getRollNo());
			ps.setString(2, s.getName());

			rows = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}
		return rows> 0;
	}

	public Student getStudent(int rollNo)
	{
		String sql = "select rollNo, name from student where rollNo =?";
		Student s = null;
		try(Connection conn = DBConnectionManager.getConnection()){


			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rollNo);

			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				s= new Student(rs.getInt(1),rs.getString(2));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;



	}

	public List<Student> getAllStudents()
	{

		String sql =" select rollno , name from student";

		List<Student> list =new ArrayList<>();

		try(Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement ps =  conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs!= null && rs.next());
			{
				Student s = new Student(rs.getInt(1),rs.getString(2));
				list.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;

	}

	public boolean create(Student student)
	{
		String sql = "insert into Student(rollno,name)values (?,?)";
		String sql2 = "insert into address (street,city,pincode,rollno) values(?,?,?,?)";
		int rows = 0;
		try (Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setInt(1, student.getRollNo());
			ps.setString(2, student.getName());

			rows = ps.executeUpdate();

			if(student.getAddress() != null){
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, student.getAddress().getStreet());
				ps2.setString(2, student.getAddress().getCity());
				ps2.setString(3, student.getAddress().getPincode());
				ps2.setInt(4, student.getRollNo());

				rows= ps2.executeUpdate();
			}

		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			if(e.getMessage().contains("Duplicate"));
			{
				throw new StudentException(student.getRollNo()+" Already exists");
			}
			
		}


		return rows > 0;

	}


}
