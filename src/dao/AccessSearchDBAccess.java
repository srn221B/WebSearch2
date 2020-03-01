package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Access;

public class AccessSearchDBAccess {
	private Connection con = null;

	/**
	 * リンククリック数リストを返す
	 * @return List<Link_Click>
	 */
	public List<Access> list(String year,String month,String day){
		List<Access> AccessList = new ArrayList<Access>();
		ConnectionManager cm = new ConnectionManager();

		try {
			con = cm.getConnection();

			/*String sql = "SELECT HOUR(Access_Jumpdate), COUNT(*) FROM access
			 WHERE YEAR(Access_Jumpdate) = '?' AND MONTH(Access_Jumpdate) = '?'
			 AND DAY(Access_Jumpdate) = '?' GROUP BY HOUR(Access_Jumpdate);"
			*/
			String sql = "SELECT HOUR(Access_Jumpdate), COUNT(*) FROM access"
					+ " WHERE YEAR(Access_Jumpdate) = ? AND MONTH(Access_Jumpdate) = ?"
					+ " AND DAY(Access_Jumpdate) = ? GROUP BY HOUR(Access_Jumpdate);";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//year,month,dayをset
			int i = 1;
			pStmt.setString(i++, year);
			pStmt.setString(i++, month);
			pStmt.setString(i++, day);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Access Accessbean = new Access();

				String hour = rs.getString("HOUR(Access_Jumpdate)");
				Accessbean.setAccess_Hour(hour);

				String count = rs.getString("COUNT(*)");
				Accessbean.setAccess_Count(count);


				AccessList.add(Accessbean);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return AccessList;
	}
}
