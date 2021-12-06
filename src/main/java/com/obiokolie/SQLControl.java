
package com.obiokolie;

/**
 *
 * @author Obiokolie
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.obiokolie.Cart;
import com.obiokolie.Customer;
import com.obiokolie.Product;

/*This is the Controller that contains most of the business logic */
public class SQLControl {

    Connection con;
    Statement st;
    ResultSet rs;

    public SQLControl() {
    }

    public void loadDB() {
        try {
            con = DBContext.getConnection();
            st = con.createStatement();
            System.out.println("Loaded Database");
        } catch (Exception ex) {
            System.out.println("Cant load DB");
        }

    }
    
    
    public static Customer getRecordById(int cID){
    	Customer customer =null;
    	try{
    		Connection con=DBContext.getConnection();
    		PreparedStatement ps=con.prepareStatement("select * from CustomerTBL where CustomerID = ?");
    		ps.setInt(1,cID);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()){
    			customer=new Customer();
    			customer.setcID(rs.getString("CustomerID"));
    			customer.setcName(rs.getString("CustomerName"));
    			customer.setcCreditLimit(rs.getInt("CustomerCreditLimit"));

    		}
    	}catch(Exception e){System.out.println(e);}
    	return customer;
    }
    
    
    
    public void updateCustomer(String cID, int cCreditBalance, String setDate, String isSet){
    	
    	try{
    		Connection con=DBContext.getConnection();
    		PreparedStatement ps=con.prepareStatement("update CustomerTBL set CustomerCreditLimit=?, isLimitSet=?, LastSetDate=? where CustomerID=?");

    		ps.setInt(1,cCreditBalance);
    		ps.setString(2,isSet);
    		ps.setString(3,setDate);
    		ps.setString(4,cID);

    		ps.executeUpdate();
    	}catch(Exception e){System.out.println(e);}

    }
    
    

    public ArrayList<Product> selectAllProduct() throws SQLException {
    	
        ArrayList<Product> pArrList = new ArrayList<>();
        loadDB();
        String sql = "select * from ProductTBL";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String pId = rs.getString("ProductID");
                String pName = rs.getString("ProductName");
                int pPrice = Integer.parseInt(rs.getString("ProductPrice"));
                pArrList.add(new Product(pId, pName, pPrice));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return pArrList;
    }
    
    public ArrayList<Transaction> selectAllTransaction() throws SQLException {
        ArrayList<Transaction> tArrList = new ArrayList<>();
        loadDB();
        String sql = "select * from orderlinetbl";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	int orderID = rs.getInt("OrderID");
            	String productID = rs.getString("ProductID");
            	int quantity = rs.getInt("Quantity");
            	int price = rs.getInt("Price");
            	String customerID = rs.getString("CustomerID");
            	String orderDate = rs.getString("OrderDate");
            	String paymentMethod = rs.getString("PaymentMethod");

                tArrList.add(new Transaction(orderID, productID, quantity, price, customerID, orderDate, paymentMethod));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return tArrList;
    }

    public ArrayList<Product> selectProduct(String id) throws SQLException {
        ArrayList<Product> arrCart = new ArrayList<>();
        loadDB();
        String xSQL = "select * from ProductTBL where ProductID = '" + id + "'";
        try {
            rs = st.executeQuery(xSQL);
            while (rs.next()) {
                String pId = rs.getString("ProductID");
                String pName = rs.getString("ProductName");
                int pPrice = Integer.parseInt(rs.getString("ProductPrice"));
                arrCart.add(new Product(pId, pName, pPrice));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return arrCart;
    }

    public ArrayList<Customer> selectAllCustomer() throws SQLException {
        ArrayList<Customer> arrCus = new ArrayList<>();
        loadDB();

        try {
            String sql = "select * from CustomerTBL";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String cID = rs.getString("CustomerID");
                String cName = rs.getString("CustomerName");
                int cCreditBalance = rs.getInt("CustomerCreditLimit");
                arrCus.add(new Customer(cID, cName, cCreditBalance));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return arrCus;
    }

    public void insertOrder(String date, String payment, String cusID, int itemPrice) throws SQLException {
        loadDB();

        try {
            //Assume a valid connection object conn
            con.setAutoCommit(false);

            //transaction insert order to database
            String sql = "insert into OrderTBL (OrderDate,PaymentMethod,CustomerID,itemAmount) "
                    + "values ('" + date + "','" + payment + "','" + cusID + "'," + itemPrice + ")";
            st.executeUpdate(sql);
            // If there is no error.
            con.commit();

        } catch (SQLException ex) {
            System.out.println("SQL Error");
            //if have any error
            con.rollback();
        } finally {
            st.close();
            con.close();
        }

    }
    
    public boolean customerCreditStatusIsOK(String cusID, int itemPrice) throws SQLException{
        loadDB();
        String xSQL = "select CustomerCreditLimit from CustomerTBL where CustomerID = '" + cusID + "'";
        boolean status = false;
        try {
            rs = st.executeQuery(xSQL);
            while (rs.next()) {
	            if (rs.getInt("CustomerCreditLimit") >= itemPrice) {
	            	status = true;
	            }
            }
                     
        } catch (SQLException ex) {
            System.out.println("SQL Error");
        }  finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return status;
    }
    
    
    public boolean customerCreditLimitSet(String cusID) throws SQLException{
        
    	loadDB();
        String xSQL = "select * from CustomerTBL where CustomerID = '" + cusID + "'";
        
        boolean status = false;
        try {
            rs = st.executeQuery(xSQL);
            while (rs.next()) {
            	String creditSetStatus = rs.getString("isLimitSet");
	            if ( creditSetStatus.equals("Yes")) {
	            	status = true;
	            }
            }
                     
        } catch (SQLException ex) {
            System.out.println("SQL Error");
        }  finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return status;
    }
    
    
    public void decreaseCustomerCredit(String cusID, int itemPrice) throws SQLException {
        

    	
    	loadDB();
        
        
        String xSQL2 = "select CustomerCreditLimit from CustomerTBL where CustomerID = '" + cusID + "'";
        
        try {
            rs = st.executeQuery(xSQL2);
            while (rs.next()) {
	            int decreaseValue = rs.getInt("CustomerCreditLimit") - itemPrice; 
	            String xSQL = "UPDATE CustomerTBL SET CustomerCreditLimit = " + decreaseValue + " WHERE CustomerID = '" + cusID + "'";
	            st.execute(xSQL);
	            }
            
                     
        } catch (SQLException ex) {
            System.out.println("SQL Error");
        }  finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
    }

    public int getlastedOrID() throws SQLException {
        loadDB();
        int orID = -1;
        try {
            String sql = "select top 1 OrderID from OrderTBL order by OrderID DESC ";
            String sql2 = "select * from OrderLineTBL ORDER BY OrderID DESC LIMIT 1";
            rs = st.executeQuery(sql2);
            while (rs.next()) {
                orID = rs.getInt("OrderID")+1;
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            rs.close();
            st.close();
            con.close();
        }

        return orID;
    }

    public void insertOrderLine(int orderID, String pID, int quantity, int price, String customerID, String orderDate, String paymentMethod) throws SQLException {
        loadDB();
        //Assume a valid connection object conn

        try {
            con.setAutoCommit(false);

            //transaction insert order line to database
            String sql = "insert into OrderLineTBL "
                    + "values ('" + orderID + "','" + pID + "','" + quantity + "','" + price + "','" + customerID + "','" + orderDate + "','" + paymentMethod + "')";
            st.executeUpdate(sql);
            // If there is no error.
            con.commit();
        } catch (SQLException ex) {
            System.out.println("SQL Error");
            //if have any error
            con.rollback();
        } finally {
            st.close();
            con.close();
        }
    }

}
