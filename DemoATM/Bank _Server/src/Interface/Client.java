package Interface;

/**
 *
 * @author MinhLuong
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Client extends Remote 
{
    //Phương thức trả về ngân hàng quản lý client này
    public BankManager getBankManager() throws RemoteException;
    
    //Phương thức trả về tên của client
    public String getName() throws RemoteException;
}
