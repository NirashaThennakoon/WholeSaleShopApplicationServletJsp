/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dao.custom.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.CustomerDTO;

/**
 *
 * @author student
 */
public class CustomerDAOImpl implements CustomerDAO {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public boolean add(CustomerDTO t) throws SQLException {
        PreparedStatement pst = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?)");
        pst.setObject(1, t.getId());
        pst.setObject(2, t.getName());
        pst.setObject(3, t.getAddress());
        pst.setObject(4, t.getSalary());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean update(CustomerDTO t) throws SQLException {
        PreparedStatement pst = connection.prepareStatement("Update Customer set name=?, address=?, salary=? where id=?");
        pst.setObject(4, t.getId());
        pst.setObject(1, t.getName());
        pst.setObject(2, t.getAddress());
        pst.setObject(3, t.getSalary());
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException {
        System.out.println("Welcomto DAO Layer");
        ArrayList<CustomerDTO> alCustomers = new ArrayList<>();
        String sql = "select * from Customer";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String id = rset.getString("id");
            String name = rset.getString("name");
            String address = rset.getString("address");
            double salary = rset.getDouble("salary");

            CustomerDTO customer = new CustomerDTO(id, name, address, salary);
            alCustomers.add(customer);
        }

        return alCustomers;
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From Customer where id='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public CustomerDTO get(String id) throws Exception {            
        CustomerDTO customer = null;
        String sql = "SELECT * FROM Customer WHERE id = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        if (rset.next()) {
            customer = new CustomerDTO(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getDouble(4));
        }

        return customer;
    }

    public CustomerDTO get(CustomerDTO t) throws SQLException {
        String id = t.getId();
        CustomerDTO customer = null;
        String sql = "SELECT * FROM Customer WHERE id = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            customer = new CustomerDTO(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getDouble(4));
        }
        return customer;
    }

}
