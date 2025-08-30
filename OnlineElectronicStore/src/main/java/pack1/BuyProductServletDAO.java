package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyProductServletDAO {
	public int buyProduct(ProductBean pd) {
		int rowCount=0;
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update product SET pqty = pqty-? where pcode=? and pqty>=?");
			int qty = Integer.parseInt(pd.getR_qnty());
			pstmt.setInt(1, qty);
			//pstmt.setString(1, pd.getR_qnty());
			pstmt.setString(2, pd.getP_code());
			//pstmt.setString(3, pd.getR_qnty());
			pstmt.setInt(3, qty);
			
			 rowCount=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	public int getPrice(String pcode) {
        int price = 0;
        try {
            Connection con = DBConnect.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT pprice FROM product WHERE pcode = ?");
            ps.setString(1, pcode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price=rs.getInt("pprice");
           }
        }
            catch(Exception e) {
            	e.printStackTrace();
            }
		return price;
        }
}