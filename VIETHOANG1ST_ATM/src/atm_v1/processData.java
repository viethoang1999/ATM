/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_v1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Quangnv
 */
public class processData {

    /**
     */
    public ArrayList<Customer> list;

    public  ArrayList<Customer> result() throws FileNotFoundException, IOException{
        File f = new File("dataATM.txt");
        list = getListCustomer(f);
        return list;
    }
    //Lớp khách hàng
    public  class Customer{
        public String name;
        public String so_tk;
        public String pass;
        public double tk;
        public Customer(String name, String so_tk, String pass, double tk){
            this.name = name;
            this.so_tk = so_tk;
            this.pass = pass;
            this.tk = tk;
        }
    }
    
    //Lấy danh sách đối tượng Customer
    public  ArrayList<Customer> getListCustomer(File file) throws FileNotFoundException, IOException{
        ArrayList<Customer> listCutomer = new ArrayList();
        int sodong = 0;
        
        //Lấy số dòng
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
             String line = input.nextLine();
                        sodong++;
                }
        //System.out.println("" + sodong);
        
        //Add đối tượng Customer vào danh sách
        FileReader fr=new FileReader(file);
        BufferedReader textReader =new BufferedReader(fr);
        String arrline;
        for(int i = 0;i < sodong; i++){
            arrline = textReader.readLine();
//            System.out.println(arrline);
            Customer customer = getCustomer(arrline);
            listCutomer.add(customer);
        }
        
        return listCutomer;
    }
    
    //Lấy đối tượng Customer từ 1 chuỗi
    private  Customer getCustomer(String input) {
        Customer customer = null;
        String str1, str2, str3, str5;
        double str4;
        StringTokenizer str=new StringTokenizer(input, "|", false);
        while(str.hasMoreTokens()){
            str1=str.nextToken();
            str2=str.nextToken();
            str3=str.nextToken();
            //str5=str.nextToken();
            //str4=Integer.parseInt(str.nextToken());
            str4=Double.parseDouble(str.nextToken());
            customer = new Customer(str1, str2, str3, str4);
        }
        return customer;
    }
    public  void writeListToFile(ArrayList<Customer> list,File f) throws FileNotFoundException, IOException{
        FileWriter fw=new FileWriter(f,true);
        BufferedWriter out=new BufferedWriter(fw);
        try {
            for(int i=0;i<list.size();i++){
            out.write(list.get(i).name + "|" + list.get(i).so_tk + "|" + list.get(i).pass + "|" + String.valueOf(list.get(i).tk));
            out.newLine();
        }
        out.close();
        } catch (NullPointerException e) {
        }
    
        FileOutputStream fo = new FileOutputStream(f);
        PrintStream input = new PrintStream(fo);
        try {
            for(int i=0;i<list.size();i++){
            input.println(list.get(i).name + "|" + list.get(i).so_tk + "|" + list.get(i).pass + "|" + String.valueOf(list.get(i).tk));
        }
        } catch (NullPointerException e) {
        }
        
            
    }
}
