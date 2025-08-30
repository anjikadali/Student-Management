package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO 
	{
	public AdminBean checkAdminlogin(String aname, String apwd) 
	{
		AdminBean abean=null;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from admin where uname=? and pword=?");
			pstmt.setString(1,aname);
			pstmt.setString(2,apwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{	
			abean=new AdminBean();
			abean.setA_name(rs.getString(1));
			abean.setA_pwd(rs.getString(2));
			abean.setA_fname(rs.getString(3));
			abean.setA_lname(rs.getString(4));
			abean.setA_addr(rs.getString(5));
			abean.setA_mail(rs.getString(6));
			abean.setA_phno(rs.getString(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return abean;
	}

}
