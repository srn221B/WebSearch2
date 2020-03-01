package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class YearListDAO {

	private Connection con = null;

	/**
	 * 履歴にある年のリストを返す
	 * @return List<String>
	 */
	public List<String> list(){
		List<String> list = new ArrayList<String>();
		ConnectionManager com = new ConnectionManager();

		try {
			con = com.getConnection();

			//String sql = "SELECT DISTINCT YEAR(Access_Jumpdate) from access;";
			String sql = "SELECT DISTINCT YEAR(Access_Jumpdate) from access;";
			PreparedStatement pStmt = con.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String year = rs.getString("YEAR(Access_Jumpdate)");
				list.add(year);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
