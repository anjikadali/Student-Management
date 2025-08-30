package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/updateproduct")
public class UpdateProductServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {

        String pcode = req.getParameter("pcode");
        String pname = req.getParameter("pname");
        String pcomp = req.getParameter("pcomp");
        String price =req.getParameter("pprice");
        String qty =req.getParameter("pqty");
        
        ProductBean pb=new ProductBean();
        pb.setP_code(pcode);
        pb.setP_name(pname);
        pb.setP_comp(pcomp);
        pb.setP_price(price);
        pb.setP_qnty(qty);
        
        UpdateProductDAO dao=new UpdateProductDAO();
        int row =dao.updateData(pb);
        
        String msg=(row>0)?"Product Updated Successfully":"Update failed";
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
    }
}
