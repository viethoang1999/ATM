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
import java.rmi.RemoteException;
import CustomException.NoCashAvailableException;

public class AccountImpl implements Account, Serializable 
{
    private BankManager bankManager;
    private Client client;
    private float balance;
    private String accountNumber;
    
    //Hàm khởi tạo
    public AccountImpl (BankManager bankManager, Client client, String accountNumber, float bal) 
    {
        this.bankManager = bankManager;
        this.client = client;
        this.balance = bal;
        this.accountNumber = accountNumber;
    }
    
    public void deposit(float amount) 
    {
        balance += amount;
    }
    
    public void withdraw(float amount) 
    {
        balance -= amount;
    }
    
    public BankManager getBankManager() throws RemoteException 
    {
        return bankManager;
    }
    
    public Client getClient() throws RemoteException 
    {
        return client;
    }
    
    public float getBalance() throws RemoteException 
    {
        return balance;
    }
    
    public void setBalance(float bal) throws RemoteException
    {
        balance = bal;
    }
    
    public long getCash(long amount) throws NoCashAvailableException, RemoteException 
    {
        if (amount > balance) 
        {
            throw new NoCashAvailableException();
        }
        balance = balance - amount;
        return amount;
    }
}
