package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		HttpSession session=req.getSession(false);
		if(session==null) {
			req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
		}
			String pcode=req.getParameter("pcode");
			String reqQty=req.getParameter("reqQty");
			
			ProductBean pb = new ProductBean();
			pb.setP_code(pcode);
			pb.setR_qnty(reqQty);
					
			BuyProductServletDAO dao= new BuyProductServletDAO();
			int row=dao.buyProduct(pb);
			
			if (row>0) {
				int price=dao.getPrice(pcode);
				int total=price*Integer.parseInt(reqQty);
	            req.setAttribute("pcode", pcode);
	            req.setAttribute("reqQty", reqQty);
	            req.setAttribute("price", price);
	            req.setAttribute("total", total);
	            req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
	        } else {
	            req.setAttribute("msg", "Purchase failed!!");
	            req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
	 }
  }
}
