/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 */
import Interface.*;
import java.io.Serializable;
import java.util.Hashtable;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.*;

public class BankManagerImpl extends UnicastRemoteObject implements BankManager 
{
    private Hashtable accounts;
    private Hashtable clients;
    private Connection conn;
    private Statement s;
    private int CustomerID;
    
    // Hàm khởi tạo không tham số. Bắt buộc phải throw exception như ở dưới vì kế thừa từ UnicastRemoteObject
    public BankManagerImpl() throws RemoteException
    {
        super();
        initialize();
    }
    
    
    public Account getAccount(String accountNumber) throws RemoteException 
    {
        AccountImpl account = (AccountImpl)accounts.get(accountNumber);
        return account;
    }
    
    public Client getClient(String clientID) throws RemoteException 
    {
        ClientImpl client = (ClientImpl)clients.get(clientID);
        return client;
    }
    
    //Hàm rút tiền
    public void deposit(String idAccount, float amount)throws RemoteException
    {
        Account theAccount = (Account)accounts.get(idAccount);
        theAccount.deposit(amount);
        accounts.remove(idAccount);
        accounts.put(idAccount,theAccount);
        try 
        {
            Statement s = conn.createStatement();
            String sql = "Update account Set Balance ='" + theAccount.getBalance() +"' where idAccount = '" + idAccount +"'";
            s.executeUpdate(sql);
            /// update in the dataabase now
        }
        catch(Exception e)
        {
            e.printStackTrace();;
        }
    }
    
    public void withdraw(String idAccount, float amount)throws RemoteException
    {
        Account theAccount = (Account)accounts.get(idAccount);
        theAccount.withdraw(amount);
        accounts.remove(idAccount);
        accounts.put(idAccount,theAccount);
        try 
        {
            Statement s = conn.createStatement();
            String sql = "Update account Set Balance ='" + theAccount.getBalance() +"' where idAccount = '" + idAccount +"'";
            s.executeUpdate(sql);
            /// update in the dataabase now
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public void getClientsFromDatabase()
    {
    }
    
    public void initialize() throws java.rmi.RemoteException 
    {
        // Create the hashtables
        accounts = new Hashtable(20);
        clients = new Hashtable(10);

        CreateConnection();
        getCustomersFromDatabase();
        getAccountsFromDatabase();
    }
    
    public boolean initializeConnection(String SERVER, String DATABASE, String USER_ID, String PASSWORD) throws ClassNotFoundException, SQLException 
    {
        try 
        {
            String connString = "jdbc:sqlserver://" + SERVER + ":1433;integratedSecurity=true;databaseName=" + DATABASE;            
            conn = DriverManager.getConnection(connString);
            s = conn.createStatement();
            return true;
        }
        catch (SQLException e) 
        {
            return false;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public void CreateConnection()
    {
        if(conn == null)
        try
        {
           // initializeConnection("localhost", "bank", "root", "password");
             initializeConnection("localhost", "bank", "root", "");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int getCustomerId(int idAccount)
    {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try 
        {
            Statement s = conn.createStatement();
            String sql = "Select IdCustomer from accountCustomer where idAccount ='" + idAccount + "'";
            ResultSet r = s.executeQuery(sql);
            while(r.next())
            {
                ids.add(r.getInt("IdCustomer"));
            }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return ids.get(0).intValue();
    }
    
    public void getCustomersFromDatabase()
    {
        try 
        {
            Statement s = conn.createStatement();
            String sql = "Select * from customer";
            ResultSet r = s.executeQuery(sql);
            while(r.next())
            {
                int idCustomer = r.getInt("IdCustomer");
                String name = r.getString("name");
                String surname = r.getString("Surname");
                Client newClient = new ClientImpl(this, name + " " + surname);
                clients.put(String.valueOf(idCustomer), newClient);
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public void getAccountsFromDatabase()
    {
        System.out.println("------------------------------------");
        System.out.println("Đọc tài khoản từ cơ sở dữ liệu:");
        try 
        {
            int counter = 0;
            Statement s = conn.createStatement();
            Statement s1 = conn.createStatement();
            String sql = "Select * from accountcustomer";
            ResultSet r = s.executeQuery(sql);
            while(r.next())
            {
                int idCustomer = r.getInt("IdCustomer");
                int idAccount = r.getInt("idAccount");
                Client theClient = (ClientImpl)clients.get(String.valueOf(idCustomer));
                //get balance

                Account newAccount = new
                AccountImpl(this,theClient,String.valueOf(idAccount),0);
                accounts.put(String.valueOf(idAccount), newAccount);
                System.out.println("Customer:" + newAccount.getClient().getName() + " - Account:" + String.valueOf(idAccount));
                counter++;
            }
            for(int i =1;i<=counter;i++)
            {
                if(accounts.containsKey(String.valueOf(i)))
                {
                    sql = "Select Balance from account where idAccount = '" + i + "'";
                    ResultSet r1 = s1.executeQuery(sql);
                    r1.next();
                    float balance = r1.getFloat("Balance");
                    Account theAccount = (Account)accounts.get(String.valueOf(i));
                    theAccount.setBalance(balance);
                    accounts.remove(String.valueOf(i));
                    accounts.put(String.valueOf(i),theAccount);
                }
            }
            s.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}

