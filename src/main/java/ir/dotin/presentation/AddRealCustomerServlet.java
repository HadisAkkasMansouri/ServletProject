package ir.dotin.presentation;

import ir.dotin.business.CustomerValidation;
import ir.dotin.dataaccess.RealCustomer;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter result = response.getWriter();
        String name = request.getParameter("Name");
        String familyName = request.getParameter("FamilyName");
        String fatherName = request.getParameter("FatherName");
        String birthDate = request.getParameter("BirthDate");
        String nationalId = request.getParameter("NationalId");
        try {
            if(CustomerValidation.validateAddRealCustomer(name, familyName, fatherName, birthDate, nationalId)){
                RealCustomer realCustomer = realCustomerDAO.addRealCustomer(name, familyName, fatherName, birthDate, nationalId);
                response.getWriter().println(PageGenerator.generateAddOfRealCustomerHTML(realCustomer));
            }
        } catch (NullRequiredFieldException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        } catch (InvalidEntranceException e) {
            result.println("<body style='background-color:#000000; direction:rtl;'>");
            result.println("<h1 style = \"color:#fff8dc\"'>" + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
