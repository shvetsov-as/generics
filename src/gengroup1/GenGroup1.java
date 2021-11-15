/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gengroup1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author User
 */
public class GenGroup1 {
    public static void main(String[] args) {
        ArrayList aold = new ArrayList();
        aold.add("Stroka");
        aold.add(new Integer(5));
        
        String te = (String) aold.get(0);
        
        ArrayList<String> as = new ArrayList<>();//zadaem M Stringov
        //as.add(new Integer(5)); //Oshubka yavnaya
        as.add("eee Lubaya stroka");
        String s = as.get(0); //dostaem stroky
        
        GenExample<Number> gn = new GenExample<>(new Integer(5));
        GenExample<Integer> gi = new GenExample<>(new Integer(5));
        printObject(new Integer(5));
        
        Integer[] a = {2, 3, 5};
        printObject(a);
        //List<Number> ln = Arrays.asList(2,3,5);//sozdaem spisok, add i remove ne realizovany
       List<Integer> ln = new ArrayList(Arrays.asList(2,3,5)); //interfeis List v nacale pishyt dlia gibkosti koda
       ln.add(15);
       
       
       List<Integer> ln1 = new ArrayList(Arrays.asList(2,3,5,-1,-2));
       
       int count = countIf(ln1, new MyCondition<Integer>(){
            @Override
            public boolean countIt(Integer arg) {
                if (arg > 0)
                    return true;
                else
                    return false;
            }
            
        });//C - naslednic number
        System.out.println(count);
        
        ///////////////////////////////////kopirovanie M
        Integer[] ab = {2,5,9};
        System.out.println("stariy M");
        for (Integer x: ab ){
            System.out.println(x);
        };
        ab = doubleSize(Integer.class, ab);
        System.out.println("noviy M");
        for (Integer x: ab ){
            System.out.println(x);
        };
        ////////////////////////////////////////////
        
        ///////Meniaet nestami 2 ykaz elementa massiva
        //VbIzov swap
        
        ///////
        
        List lst = new ArrayList(Arrays.asList(5,4,7,9,11,2,6));
        System.out.println("comparator positive");
        System.out.println(findBest(lst, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((Integer)o1 > (Integer)o2) return 1;
                else return -1;    
                
            }
            
        
              
            
      
            
            
            
            
            
        }));
        
        
        
        
        
        
       
    }
    
    //static void printObject(List<? extends Number> p){//? - whilecard 
    //static <T extends Number> void printObject(List<T> p){ List<? super Number> dst - vse chto ygodno do objecta/ prinimaushiy klass Number i vbIshe, a peredavaemiy ogranichen number. oshibki ne bydet
    static  void printObject(List<? extends Number> src,  List<? super Number> dst){//pozvolit sdelat add, no bydet privodit k objekty. chtenie ogarnicheno
        //for (T x: p){
        for (int i = 0; i < src.size(); i++){
            dst.add(src.get(i));//zapis// chtenie obektov tipa object. nado preobrazov potom
        //System.out.println(x.doubleValue());
        }
        //p.add(new Integer(16)); Ne dast dobavit
    }
    static void printObject(Number p){
        System.out.println(p.toString());
    }
    
    static void printObject(Number [] v){ //tyt tip objectom ne stanovitsia
        for (Number x: v){
        System.out.println(x.doubleValue());
        }
    }
    
    //obobshen metod - refleksiya
    static <T> T[] doubleSize (Class<T> cl, T[] a){ //stat metod s param T vozvr M ydvoennogo razmera. a - stariy massiv
        T[] data = (T[]) Array.newInstance(cl, a.length*2);
        for(int i = 0; i<a.length; i++){
            data[i] = a[i];
        }
        return data;
    }
    
       
    static <T extends Number> int countIf(Collection<T> col, MyCondition<T> p){
        int count = 0;
        for (T posit: col){
        if (p.countIt(posit))
            
        count++;
        }
        return count;
        
                        
    }
            
        
        ///////Meniaet nestami 2 ykaz elementa massiva
    
    static <T> void swap (T[] a, int i, int j){
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;     
    }
    
    /////// Naity lychshee znachenie v sootv s Comparator
    static <T extends Comparable<T>> T findBest(List<T> list, Comparator<T> c){
        T best = list.get(0);
        for(T arg: list){
            if(c.compare(arg, best) > 0)
                best = arg;
        }
   return best;

    }
    
//    static <T> Map <T , Integer> countNumbers(T[] a){
//        
//        
//        return null;
//    }
    
    }
    
    

