package pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect 
{
	private DBConnect() {}
	private static Connection con=null;
	static 
	{
		try 
		{
			Class.forName(DbInfo.driver);
		  con=DriverManager.getConnection(DbInfo.dbUrl, DbInfo.dbUName, DbInfo.dbPwd);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}		
	}
	public static Connection getCon() 
	{
	
		return con;
	}

}
