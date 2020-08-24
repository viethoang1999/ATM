package Interface;

/**
 *
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankManager extends Remote 
{
    //Phương thức lấy tài khoản theo mã
    public Account getAccount(String accountNumber) throws RemoteException;
    
    //Phương thức lấy client theo tên
    public Client getClient(String clientName) throws RemoteException;
    
    //phươn thức lấy mã khách hàng theo mã tài khoản
    public int getCustomerId(int accountId)  throws RemoteException;
    
    //phương thức gửi tiền vòa tài khoản
    public void deposit(String idAccount, float Amount) throws RemoteException;
    
    //phương thức rút tiền
    public void withdraw(String idAccount, float Amount) throws RemoteException;
}
