package pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
   /* protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Don't create new session

        if (session == null)
            req.getRequestDispatcher("AdminLogin.html").forward(req, res);
        else{
        String p_code = req.getParameter("pcode");
        DeleteProductDAO dao = new DeleteProductDAO();
        int rowCount = dao.deleteProductByCode(p_code);

        if (rowCount > 0) {
            req.setAttribute("msg", "Product deleted successfully!");
        } else {
            req.setAttribute("msg", "Product deletion failed!");
        }

        req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
      }
    }
}*/
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        handleDelete(req, res);
	    }

	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        handleDelete(req, res);
	    }

	    private void handleDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        HttpSession session = req.getSession(false);

	        if (session == null || session.getAttribute("abean") == null) {
	            req.getRequestDispatcher("AdminLogin.html").forward(req, res);
	            return;
	        }

	        String p_code = req.getParameter("pcode");
	        DeleteProductDAO dao = new DeleteProductDAO();
	        int rowCount = dao.deleteProductByCode(p_code);

	        if (rowCount > 0) {
	            req.setAttribute("msg", "Product deleted successfully!");
	        } else {
	            req.setAttribute("msg", "Product deletion failed!");
	        }

	        req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
	    }
	}

 