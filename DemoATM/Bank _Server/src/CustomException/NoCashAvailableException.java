/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomException;

/**
 *
 * @author MinhLuong
 */
public class NoCashAvailableException extends Exception
{
    public NoCashAvailableException(String message) 
    {
        super(message);
    }
    
    public NoCashAvailableException() 
    {
        super();
    }
}
