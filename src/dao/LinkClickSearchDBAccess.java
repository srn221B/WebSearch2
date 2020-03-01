package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Link_Click;


public class LinkClickSearchDBAccess {
	private Connection con = null;

	/**
	 * リンククリック数リストを返す
	 * @return List<Link_Click>
	 */
	public List<Link_Click> list(String year,String month,String day){
		List<Link_Click> LinkList = new ArrayList<Link_Click>();
		ConnectionManager cm = new ConnectionManager();

		try {
			con = cm.getConnection();

			//String sql = "SELECT Link_Column, COUNT(*) FROM link_history WHERE YEAR(Link_Jumpdate) = '?' AND MONTH(Link_Jumpdate) = '?' AND DAY(Link_Jumpdate) = '?' GROUP BY Link_Column;"
			String sql = "SELECT Link_Column, COUNT(*) FROM link_history"
					+ " WHERE YEAR(Link_Jumpdate) = ?"
					+ " AND MONTH(Link_Jumpdate) = ?"
					+ " AND DAY(Link_Jumpdate) = ?"
					+ " GROUP BY Link_Column;";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//year,month,dayをset
			int i = 1;
			pStmt.setString(i++, year);
			pStmt.setString(i++, month);
			pStmt.setString(i++, day);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Link_Click linkclickbean = new Link_Click();
				String colum_name  = rs.getString("Link_Column");
				linkclickbean.setLink_Colum(colum_name);

				String colum_count = rs.getString("COUNT(*)");
				linkclickbean.setLink_Count(colum_count);

				LinkList.add(linkclickbean);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return LinkList;
	}
}
