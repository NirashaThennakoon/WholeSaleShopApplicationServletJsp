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
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dto.ItemDTO;

/**
 *
 * @author CHATHURI
 */
public class ItemDAOImpl implements ItemDAO {
    
    private Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public boolean add(ItemDTO t) throws Exception {
        PreparedStatement pst = connection.prepareStatement("INSERT INTO Item VALUES(?,?,?,?)");
        pst.setObject(1, t.getCode());
        pst.setObject(2, t.getDescription());
        pst.setObject(3, t.getUnitPrice());
        pst.setObject(4, t.getQtyOnHand());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Update Item set description=?, unitPrice=?, qtyOnHand=? where code=?");
        pst.setObject(4, t.getCode());
        pst.setObject(1, t.getDescription());
        pst.setObject(2, t.getUnitPrice());
        pst.setObject(3, t.getQtyOnHand());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From Item where code='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public ItemDTO get(String id) throws Exception {
        ItemDTO item = null;
        String sql = "SELECT * FROM Item WHERE code = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            item = new ItemDTO(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getDouble(3),
                    rset.getInt(4));
        }
        return item;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        ArrayList<ItemDTO> alItems = new ArrayList<>();
        String sql = "select * from Item";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String code = rset.getString("code");
            String description  = rset.getString("description");
            double unitPrice = rset.getDouble("unitPrice");
            int qtyOnHand = rset.getInt("qtyOnHand");

            ItemDTO item = new ItemDTO(code, description, unitPrice, qtyOnHand);
            alItems.add(item);
        }

        return alItems;
    }
    
}
