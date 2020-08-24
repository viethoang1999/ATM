
package ATM_v1;
import atm_v1.SingIn;
import atm_v1.processData.Customer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Customer> list;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        SingIn dangNhap=new SingIn();
        dangNhap.setVisible(true);
    }

}
