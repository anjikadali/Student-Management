package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

@WebServlet("/reg")
public class CustomerRegistrationServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		CustomerBean cd=new CustomerBean();
		cd.setC_name(req.getParameter("cname"));
		cd.setC_pwd(req.getParameter("cpwd"));
		cd.setC_fname(req.getParameter("fname"));
		cd.setC_lname(req.getParameter("lname"));
		cd.setC_addr(req.getParameter("cadd"));
		cd.setC_mail(req.getParameter("mid"));
		cd.setC_phno(req.getParameter("cphn"));
		
		CustomerRegisterDAO rDAO=new CustomerRegisterDAO();
		int rowCount=rDAO.insertCustomerData(cd);
		if(rowCount>0) {
			req.setAttribute("msg", "Customer Registered Succesfully!!!");
			req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Customer Registered failed!!!");
			req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
		}
		
	}
}
