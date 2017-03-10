/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.business.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.business.custom.OrderBO;
import lk.ijse.dao.ConnectionFactory;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dto.OrderDTO;

/**
 *
 * @author CHATHURI
 */
public class OrderBOImpl implements OrderBO{
    
    OrderDAO orderDAO ;
    
    public OrderBOImpl(OrderDAO orderDAO) {
        this.orderDAO=orderDAO;
    }

    @Override
    public boolean add(OrderDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDAO.setConnection(connection);
        boolean result = orderDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDAO.setConnection(connection);
        boolean result = orderDAO.update(t);
        connection.close();
        return result;
    }

    @Override
    public boolean delete(OrderDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDAO.setConnection(connection);
        boolean result = orderDAO.delete(t.getOrderId());
        connection.close();
        return result;
    }

    @Override
    public OrderDTO get(String id) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDAO.setConnection(connection);
        OrderDTO result =orderDAO.get(id);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDAO.setConnection(connection);
        ArrayList<OrderDTO> result = orderDAO.getAll();
        connection.close();
        System.out.println("Business");
        return result;
    }
    
    
    public OrderDTO get(OrderDTO t) throws SQLException, Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        orderDAO.setConnection(connection);
        OrderDTO result =  orderDAO.get(t.getCustomerId());
        connection.close();
        return result;
    }
    
}
