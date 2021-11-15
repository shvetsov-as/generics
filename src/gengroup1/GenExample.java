/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gengroup1;

/**
 *
 * @author User
 */
public class GenExample <T>{
    private T t;//perem dannogo tipa T
    public GenExample (T init){
        this.t = init;
    }
    
    public T getT(){
        return t;
    }
    public void setT (T t){
        this.t = t;
        
    }
    
    
}
