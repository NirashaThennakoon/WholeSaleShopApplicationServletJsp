/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.service;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.ijse.business.custom.impl.CustomerBOImpl;
import lk.ijse.business.custom.impl.ItemBOImpl;
import lk.ijse.business.custom.impl.OrderBOImpl;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author CHATHURI
 */
public class ServeletPlaceOrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
        CustomerBOImpl customerBO = (CustomerBOImpl) ctx.getBean("customerBOImpl");
        ItemBOImpl itemBO = (ItemBOImpl) ctx.getBean("itemBOImpl");
        OrderBOImpl orderBO = (OrderBOImpl) ctx.getBean("orderBOImpl");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(new Date());

        switch (request.getParameter("action")) {

            case "save":
//                System.out.println("come to save");
//                RequestDispatcher rd = request.getRequestDispatcher("/PlaceOrder.jsp");
//                Date date=parseDate(formattedDate);
//                OrderDTO orderdto = new OrderDTO(
//                        request.getParameter("orderId").toString(),
//                        (request.getParameter("date")),
//                        request.getParameter("custId").toString()
//                        );
//                 {
//                    try {
//                        boolean result = orderBO.add(orderdto);
//                    } catch (Exception ex) {
//                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    rd.include(request, response);
//                    break;
//                }
                break;


            case "getOrderId":
                OrderDTO orderDTO = new OrderDTO();
                 {
                    try {
                        orderDTO = orderBO.get(orderDTO);
                        response.getOutputStream().print(orderDTO.getOrderId());
                    } catch (Exception ex) {
                        Logger.getLogger(ServeletPlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case "search":
                RequestDispatcher rd4 = request.getRequestDispatcher("/PlaceOrder.jsp");
                String id = request.getParameter("id");

                 {
                    try {
                        CustomerDTO get = customerBO.get(id);
                        response.getOutputStream().print("{\"id\":\"" + get.getId() + "\",\"name\":\"" + get.getName() + "\",\"address\":\"" + get.getAddress() + "\",\"salary\":\"" + get.getSalary() + "\"}");
                    } catch (Exception ex) {
                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //rd4.include(request, response);
                    break;
                }

            case "search2":
                RequestDispatcher rd5 = request.getRequestDispatcher("/PlaceOrder.jsp");
                String id2 = request.getParameter("id");

                 {
                    try {
                        ItemDTO get = itemBO.get(id2);
                        response.getOutputStream().print("{\"id\":\"" + get.getCode() + "\",\"description\":\"" + get.getDescription() + "\",\"unitPrice\":\"" + get.getUnitPrice() + "\",\"qtyOnHand\":\"" + get.getQtyOnHand() + "\"}");
                    } catch (Exception ex) {
                        Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //rd4.include(request, response);
                    break;
                }

            default:

        }

    }
    private Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            
        }
        return null;
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
