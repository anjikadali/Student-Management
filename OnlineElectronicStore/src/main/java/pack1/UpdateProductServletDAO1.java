package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductServletDAO1 {
    public int updateProduct(ProductBean pb) {
        int rowCount = 0;
        try {
            Connection con = DBConnect.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE product SET pname = ?, pcompany = ?, price = ?, pqty = ? WHERE pcode = ?");

            ps.setString(1, pb.getP_name());
            ps.setString(2, pb.getP_comp());
            ps.setInt(3, Integer.parseInt(pb.getP_price()));
            ps.setInt(4, Integer.parseInt(pb.getP_qnty()));
            ps.setString(5, pb.getP_code());
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		return rowCount;
    }
}  