package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegisterDAO {
	public int insertCustomerData(CustomerBean cd) {
		int rowCount=0;
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into customer1 values(?,?,?,?,?,?,?)");
			pstmt.setString(1, cd.getC_name());
			pstmt.setString(2, cd.getC_pwd());
			pstmt.setString(3, cd.getC_fname());
			pstmt.setString(4, cd.getC_lname());
			pstmt.setString(5, cd.getC_addr());
			pstmt.setString(6, cd.getC_mail());
			pstmt.setString(7, cd.getC_phno());
			rowCount=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}

}
