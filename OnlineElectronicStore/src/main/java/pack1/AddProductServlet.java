package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		try {
			HttpSession session=req.getSession();
			if(session==null) {
				req.getRequestDispatcher("AdminLogin.html").forward(req, res);
			}
			else {
				ProductBean pb=new ProductBean();
				AddProductDAO obj=new AddProductDAO();
				pb.setP_code(req.getParameter("pcode"));
				pb.setP_name(req.getParameter("pname"));
				pb.setP_comp(req.getParameter("pcomp"));
				pb.setP_price(req.getParameter("pprice"));
				pb.setP_qnty(req.getParameter("pqty"));
				int rowCount=obj.insertProductDtails(pb);
				
				if (rowCount>0) {
					req.setAttribute("msg", "Product details added Succesfully");
					req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
				}
				/*else {
					req.setAttribute("msg", "Product data Not Updated!!!");
					req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
				}*/
			}
			
		}
		catch(Exception e){
			req.setAttribute("msg", "Duplicate Product ID'S Not Allowed!!!");
			req.getRequestDispatcher("Error.jsp").forward(req, res);
		}
	}

}
