/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.business.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.business.custom.OrderDetailBO;
import lk.ijse.dao.ConnectionFactory;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.dto.OrderDetailDTO;

/**
 *
 * @author CHATHURI
 */
public class OrderDetailBOImpl implements OrderDetailBO{
    
    OrderDetailDAO orderDetailDAO ;
    
    public OrderDetailBOImpl(OrderDetailDAO orderDetailDAO) {
        this.orderDetailDAO=orderDetailDAO;
    }

    @Override
    public boolean add(OrderDetailDTO t) throws Exception {
        System.out.println("Come to BO");
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDetailDAO.setConnection(connection);
        boolean result = orderDetailDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(OrderDetailDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDetailDAO.setConnection(connection);
        boolean result = orderDetailDAO.update(t);
        connection.close();
        return result;
    }

    @Override
    public boolean delete(OrderDetailDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDetailDAO.setConnection(connection);
        boolean result = orderDetailDAO.delete(t.getOrderId());
        connection.close();
        return result;
    }

    @Override
    public OrderDetailDTO get(String id) throws Exception {
         Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDetailDAO.setConnection(connection);
        OrderDetailDTO result =orderDetailDAO.get(id);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDetailDAO.setConnection(connection);
        ArrayList<OrderDetailDTO> result = orderDetailDAO.getAll();
        connection.close();
        System.out.println("Business");
        return result;
    }
    
    public OrderDetailDTO get(OrderDetailDTO t) throws SQLException, Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDetailDAO.setConnection(connection);
        OrderDetailDTO result =  orderDetailDAO.get(t.getOrderId());
        connection.close();
        return result;
    }
    
}
