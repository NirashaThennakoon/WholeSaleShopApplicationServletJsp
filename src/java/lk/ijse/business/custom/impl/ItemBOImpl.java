/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.business.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.business.custom.ItemBO;
import lk.ijse.dao.ConnectionFactory;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dto.ItemDTO;

/**
 *
 * @author CHATHURI
 */
public class ItemBOImpl implements ItemBO{
    
    ItemDAO itemDAO ;
    
    public ItemBOImpl(ItemDAO itemDAO) {
        this.itemDAO=itemDAO;
    }

    @Override
    public boolean add(ItemDTO t) throws Exception {
        System.out.println("Come to BO");
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        boolean result = itemDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        boolean result = itemDAO.update(t);
        connection.close();
        return result;
    }

    @Override
    public boolean delete(ItemDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        boolean result = itemDAO.delete(t.getCode());
        connection.close();
        return result;
    }

    @Override
    public ItemDTO get(String id) throws Exception {
        System.out.println(id);
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        ItemDTO result =itemDAO.get(id);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        ArrayList<ItemDTO> result = itemDAO.getAll();
        connection.close();
        System.out.println("Business");
        return result;
    }
    
    public ItemDTO get(ItemDTO t) throws SQLException, Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        ItemDTO result =  itemDAO.get(t.getCode());
        connection.close();
        return result;
    }
    
}
