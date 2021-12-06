
package com.obiokolie;

/**
 *
 * @author Obiokolie
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EditUser")
public class EditUser extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SQLControl control = new SQLControl();
        
        //If you wish to use session for the Admins, uncomment this section and include some profile codes
        //HttpSession session = request.getSession();
        
        //get cID,CreditLimit,monthLastSet
        
        int cCreditLimit = Integer.parseInt(request.getParameter("creditlimit"));
        String cID = request.getParameter("cID");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());
        
        try {
			if(!control.customerCreditLimitSet(cID)) {
				try {
					String isSet = "Yes";
				
					PrintWriter out = response.getWriter();
					control.updateCustomer(cID, cCreditLimit, date, isSet);
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Customer Limit Updated');");
					out.println("location='viewusers.jsp';");
					out.println("</script>");
					} catch (Exception e){
						System.out.println(e);
					}
			} else {
					PrintWriter out = response.getWriter();
		            out.println("<script type=\"text/javascript\">");
		            out.println("alert('Customer credit limit is already set. Try again next month');");
		            out.println("location='viewusers.jsp';");
		            out.println("</script>");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}      	
        
            		
            		
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
