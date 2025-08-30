package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {
	public int insertProductDtails(ProductBean pd)throws Exception {
		int rowCount=0;
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?,?)");
			pstmt.setString(1, pd.getP_code());
			pstmt.setString(2, pd.getP_name());
			pstmt.setString(3, pd.getP_comp());
			pstmt.setString(4, pd.getP_price());
			pstmt.setString(5, pd.getP_qnty());
			rowCount=pstmt.executeUpdate();
		}
		catch(Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return rowCount;
	}

}
