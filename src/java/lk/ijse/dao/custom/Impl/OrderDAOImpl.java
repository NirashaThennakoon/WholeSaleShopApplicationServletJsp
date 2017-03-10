/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dto.OrderDTO;

/**
 *
 * @author CHATHURI
 */
public class OrderDAOImpl implements OrderDAO{

    private Connection connection;
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
        System.out.println("connected");
    }
    
    @Override
    public boolean add(OrderDTO t) throws Exception {
        System.out.println("Come to orderDAO");
        PreparedStatement pst = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?)");
        pst.setObject(1, t.getOrderId());
        pst.setObject(2, t.getCustomerId());
        pst.setObject(3, t.getDate());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Update Orders set date =?, customerId  =?, where id=?");
        pst.setObject(4, t.getOrderId());
        pst.setObject(1, t.getDate());
        pst.setObject(2, t.getCustomerId());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From Orders where id='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public OrderDTO get(String id) throws Exception {
        OrderDTO order = null;
        String sql = "SELECT * FROM Orders WHERE orderId  = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            order = new OrderDTO(
                    rset.getString(1),
                    rset.getDate(2),
                    rset.getString(3));
        }
        return order;
    
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        System.out.println("Come to the DAO layer getAll");
        ArrayList<OrderDTO> alOrders = new ArrayList<>();
        String sql = "select * from Orders";
        Statement stm;
        stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        System.out.println("Come to the DAO layer getAll");
        while (rset.next()) {
            String orderId  = rset.getString("orderId");
             Date date  = rset.getDate("date");
            String customerId = rset.getString("customerId");
           
            OrderDTO order = new OrderDTO(orderId , (java.sql.Date) date, customerId );
            alOrders.add(order);
        }
        
        System.out.println("End of the dao getAll");

        return alOrders;
    }

    

    
    
}