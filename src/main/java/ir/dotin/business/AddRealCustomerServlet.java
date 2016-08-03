package ir.dotin.business;

import ir.dotin.dataAccess.RealCustomerDao;
import ir.dotin.entities.RealCustomer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddRealCustomerServlet extends HttpServlet {


    RealCustomer realCustomer = new RealCustomer();
    RealCustomerDao dao = new RealCustomerDao();

    protected void addRealCustomerRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        realCustomer.setName(request.getParameter("Name"));
        realCustomer.setFamilyName(request.getParameter("FamilyName"));
        realCustomer.setFatherName(request.getParameter("FatherName"));
        realCustomer.setBirthDate(request.getParameter("BirthDate"));
        realCustomer.setNationalId(request.getParameter("NationalId"));

//        boolean result = dao.addRealCustomer(realCustomer);
//        if (result){
//            response.sendRedirect();
//        }else {
//            response.sendRedirect();
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addRealCustomerRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addRealCustomerRequest(request, response);
    }
}
