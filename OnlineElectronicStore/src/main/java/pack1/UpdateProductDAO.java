package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {
	public int updateData(ProductBean pd) {
		int rowCount=0;
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update product set pprice=?,pqty=? where pcode=?");
			pstmt.setString(1, pd.getP_price());
			pstmt.setString(2, pd.getP_qnty());
			pstmt.setString(3, pd.getP_code());
			rowCount=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

}
