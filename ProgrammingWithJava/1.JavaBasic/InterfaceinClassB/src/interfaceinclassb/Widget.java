/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceinclassb;

/**
 *
 * @author User
 */
public class Widget implements Comparable {
    private int id;
    private String name;
    private int amount;
    
    //constructors
    public Widget(){
        
    }
    public Widget(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
    
    
    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    
    //setters
     public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    //toSting(optional)

    @Override
    public String toString() {
        return "Id : "+id+" Name:" + name+" Amount:" +amount ;
    }
    
    /**
     * compares this Widget with another object for order. Uses id to mae the 
     * decision
     * @param o object -the other object we are comparing this to 
     * @return int -returns -1,0, or positive 1 if this ojbect is less than, 
     * equal to , or greater than the other object
     */

   public int compareTo(Object o)
   {
       int result=0;
       if (o instanceof Widget otherWidget)
       {
       // this <0
       
       if(id<otherWidget.getId())
       {
           result=-1;
       }
       // this ==0
       else if (id==otherWidget.getId())
       {
           result=0;
       }
       // this >0
       else if (id>otherWidget.getId())
       {
           result=1;
       }
       }
       return result;
   }
}

