/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.business.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.business.custom.CustomerBO;
import lk.ijse.dao.ConnectionFactory;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.CustomerDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author CHATHURI
 */
public class CustomerBOImpl implements CustomerBO{

    
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
//    SuperDAO<CustomerDTO> customerDAO  =  (SuperDAO<CustomerDTO>) ctx.getBean("customerDAOImpl");
    CustomerDAO customerDAO ;
    
    public CustomerBOImpl(CustomerDAO custDAO) {
        this.customerDAO=custDAO;
    }

    
    @Override
    public boolean add(CustomerDTO t) throws Exception {
        System.out.println("Come to BO");
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean result = customerDAO.add(t);
        connection.close();
        return result;
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean result = customerDAO.update(t);
        connection.close();
        return result;
    }

    @Override
    public boolean delete(CustomerDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean result = customerDAO.delete(t.getId());
        connection.close();
        return result;
    }

    @Override
    public CustomerDTO get(String id) throws Exception {
        System.out.println(id);
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        CustomerDTO result =customerDAO.get(id);
        connection.close();
        System.out.println(result.getName());
        return result;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        ArrayList<CustomerDTO> result = customerDAO.getAll();
        connection.close();
        System.out.println("Business");
        return result;
    }
    
    public CustomerDTO get(CustomerDTO t) throws SQLException, Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        CustomerDTO result =  customerDAO.get(t.getId());
        connection.close();
        return result;
    }
    
}
