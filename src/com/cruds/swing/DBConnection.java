package com.cruds.swing;


	import java.sql.Connection;


	import com.cruds.swing.DBConnectionManager;

	public class DBConnection {

		
		public void test() {
			
			Connection conn = DBConnectionManager.getConnection();
			if(conn !=null)
			{
				
			System.out.println("connection successfull");
		}

	}


}
