package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class AccessSubmitDBAccess {
	Connection con = null;

	public void submitAccessByAccessInf() {
		ConnectionManager cm = new ConnectionManager();
		try {
			con = cm.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO yamazaki.access () VALUES();";
			stmt.executeUpdate(sql);

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
