package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginCDAO {
	public CustomerBean checkCustomerlogin(String cname, String cpwd) {
		CustomerBean cbean=null;
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from customer1 where uname=? and pword=?");
			pstmt.setString(1,cname);
			pstmt.setString(2,cpwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{	
			cbean=new CustomerBean();
			cbean.setC_name(rs.getString(1));
			cbean.setC_pwd(rs.getString(2));
			cbean.setC_fname(rs.getString(3));
			cbean.setC_lname(rs.getString(4));
			cbean.setC_addr(rs.getString(5));
			cbean.setC_mail(rs.getString(6));
			cbean.setC_phno(rs.getString(7));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cbean;
	}

}
