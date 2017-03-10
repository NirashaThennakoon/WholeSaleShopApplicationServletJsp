/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.ijse.business.custom.impl.CustomerBOImpl;
import lk.ijse.dto.CustomerDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author CHATHURI
 */
public class Servelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
        CustomerBOImpl customerBO = (CustomerBOImpl) ctx.getBean("customerBOImpl");

        switch (request.getParameter("action")) {
            case "save":
                RequestDispatcher rd = request.getRequestDispatcher("/Customer.jsp");
                CustomerDTO custdto = new CustomerDTO(
                        request.getParameter("txtCustomerId1").toString(),
                        request.getParameter("txtCustomerName1").toString(),
                        request.getParameter("txtCustomerAddress1").toString(),
                        Double.parseDouble(request.getParameter("txtCustomerSalary1")));
                 {
                    try {
                        boolean result = customerBO.add(custdto);
                    } catch (Exception ex) {
                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rd.include(request, response);
                    break;
                }

            case "update":
                RequestDispatcher rd2 = request.getRequestDispatcher("/Customer.jsp");
                CustomerDTO custdtoUpdate = new CustomerDTO(
                        request.getParameter("txtCustomerId").toString(),
                        request.getParameter("txtCustomerName").toString(),
                        request.getParameter("txtCustomerAddress").toString(),
                        Double.parseDouble(request.getParameter("txtCustomerSalary")));

                boolean resultUpdate;
                 {
                    try {
                        resultUpdate = customerBO.update(custdtoUpdate);
                        System.out.println("come to servlet update");
                    } catch (Exception ex) {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rd2.include(request, response);
                    break;
                }

            case "delete":
                RequestDispatcher rd3 = request.getRequestDispatcher("/Customer.jsp");
                CustomerDTO custdtoDelete = new CustomerDTO(
                        request.getParameter("txtCustomerId").toString(),
                        request.getParameter("txtCustomerName").toString(),
                        request.getParameter("txtCustomerAddress").toString(),
                        Double.parseDouble(request.getParameter("txtCustomerSalary")));

                boolean resultDelete;
                 {
                    try {
                        resultDelete = customerBO.delete(custdtoDelete);
                    } catch (Exception ex) {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rd3.include(request, response);
                    break;
                }

            case "search":
                RequestDispatcher rd4 = request.getRequestDispatcher("/Customer.jsp");
                String id = request.getParameter("id");
                System.out.println(id);
                 {
                    try {
                        CustomerDTO get = customerBO.get(id);
                        System.out.println("Servlet");
                        response.getOutputStream().print("{\"id\":\""+get.getId()+"\",\"name\":\""+get.getName()+"\",\"address\":\""+get.getAddress()+"\",\"salary\":\""+get.getSalary()+"\"}");
                    } catch (Exception ex) {
                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //rd4.include(request, response);
                    break;
                }

            default:
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
