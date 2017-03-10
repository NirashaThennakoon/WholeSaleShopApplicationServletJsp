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
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.dto.OrderDetailDTO;

/**
 *
 * @author CHATHURI
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{
    
    private Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }
    
    @Override
    public boolean add(OrderDetailDTO t) throws Exception {
        PreparedStatement pst = connection.prepareStatement("INSERT INTO OrderDetail VALUES(?,?,?,?)");
        pst.setObject(1, t.getOrderId());
        pst.setObject(2, t.getItemCode());
        pst.setObject(3, t.getQty()) ;
        pst.setObject(4, t.getUnitPrice());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(OrderDetailDTO t) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Update OrderDetail set itemCode =?, qty =?, unitPrice =? where orderId =?");
        pst.setObject(4, t.getOrderId());
        pst.setObject(1, t.getItemCode());
        pst.setObject(2, t.getQty());
        pst.setObject(3, t.getUnitPrice());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From OrderDetail where id='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public OrderDetailDTO get(String id) throws Exception {
        OrderDetailDTO orderDetail = null;
        String sql = "SELECT * FROM OrderDetail WHERE orderId  = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            orderDetail = new OrderDetailDTO(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getInt(3),
                    rset.getDouble(3));
        }
        return orderDetail;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
        ArrayList<OrderDetailDTO> alOrderDetails = new ArrayList<>();
        String sql = "select * from OrderDetail";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        
        while (rset.next()) {
            String orderId   = rset.getString("id");
            String itemCode   = rset.getString("code");
            int qty   = rset.getInt("qty");
            double unitPrice   = rset.getDouble("unitPrice");
            OrderDetailDTO order = new OrderDetailDTO(orderId, itemCode, qty, unitPrice);
            alOrderDetails.add(order);
        }

        return alOrderDetails;
    }

    
    
}
