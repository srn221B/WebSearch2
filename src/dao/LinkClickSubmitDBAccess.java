package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LinkClickSubmitDBAccess {
	Connection con = null;

	public void submitClickByLinkInf(String Link_colum) {
		ConnectionManager cm = new ConnectionManager();
		try {
			con = cm.getConnection();
			String sql = "INSERT INTO `yamazaki`.`link_history` (`Link_Column`) VALUES (?);";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, Link_colum);
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
