package pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view1")
public class ViewProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		HttpSession session=req.getSession(false);
		if(session==null)
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		else {
			ViewProductDAO obj= new ViewProductDAO();
			ArrayList<ProductBean> al=obj.reteriveData();
			session.setAttribute("productlist", al);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
	}

}
