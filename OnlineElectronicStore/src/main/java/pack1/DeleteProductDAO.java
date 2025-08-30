package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {
    public int deleteProductByCode(String p_code) {
        int rowCount = 0;
        try {
            Connection con = DBConnect.getCon();
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM product WHERE pcode=?");
            pstmt.setString(1, p_code);
            rowCount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
