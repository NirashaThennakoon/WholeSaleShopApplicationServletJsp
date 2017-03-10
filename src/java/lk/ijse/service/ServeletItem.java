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
import lk.ijse.business.custom.impl.ItemBOImpl;
import lk.ijse.dto.ItemDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author CHATHURI
 */
public class ServeletItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
        ItemBOImpl itemBO = (ItemBOImpl) ctx.getBean("itemBOImpl");

        switch (request.getParameter("action")) {
            case "save":
                RequestDispatcher rd = request.getRequestDispatcher("/addItem.html");
                ItemDTO itemdto = new ItemDTO(
                        request.getParameter("txtItemCode").toString(),
                        request.getParameter("txtItemDescription").toString(),
                        Double.parseDouble(request.getParameter("txtItemUnitPrice")),
                        Integer.parseInt(request.getParameter("txtItemQtyOnHand")));
                 {
                    try {
                        boolean result = itemBO.add(itemdto);
                    } catch (Exception ex) {
                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rd.include(request, response);
                    break;
                }

            case "update":
                RequestDispatcher rd2 = request.getRequestDispatcher("/Item.html");
                ItemDTO itemdtoUpdate = new ItemDTO(
                        request.getParameter("txtItemCode").toString(),
                        request.getParameter("txtItemDescription").toString(),
                        Double.parseDouble(request.getParameter("txtItemUnitPrice")),
                        Integer.parseInt(request.getParameter("txtItemQtyOnHand")));

                boolean resultUpdate;
                 {
                    try {
                        resultUpdate = itemBO.update(itemdtoUpdate);
                    } catch (Exception ex) {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rd2.include(request, response);
                    break;
                }

            case "delete":
                RequestDispatcher rd3 = request.getRequestDispatcher("/Item.jsp");
                ItemDTO itemdtoDelete = new ItemDTO(
                        request.getParameter("txtItemCode").toString(),
                        request.getParameter("txtItemDescription").toString(),
                        Double.parseDouble(request.getParameter("txtItemUnitPrice")),
                        Integer.parseInt(request.getParameter("txtItemQtyOnHand")));
                boolean resultDelete;
                 {
                    try {
                        resultDelete = itemBO.delete(itemdtoDelete);
                    } catch (Exception ex) {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rd3.include(request, response);
                    break;
                }

            case "search":
                RequestDispatcher rd4 = request.getRequestDispatcher("/Item.jsp");
                String code = request.getParameter("id");
                 {
                    try {
                        ItemDTO get = itemBO.get(code);
                        response.getOutputStream().print("{\"code\":\""+get.getCode()+"\",\"description\":\""+get.getDescription()+"\",\"unitPrice\":\""+get.getUnitPrice()+"\",\"qtyOnHand\":\""+get.getQtyOnHand()+"\"}");
                    } catch (Exception ex) {
                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }

            default:
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
