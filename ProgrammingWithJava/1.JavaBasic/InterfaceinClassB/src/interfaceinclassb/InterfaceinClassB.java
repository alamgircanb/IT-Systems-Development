/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaceinclassb;
import java.util.Arrays;
/**
 *
 * @author User
 */
public class InterfaceinClassB {

    public static void main(String[] args) {
       Widget[] widgets =new Widget[3];
       widgets[0]=new Widget(1001,"Screw", 47);
       widgets[1]=new Widget(1006,"Bolt", 32);
       widgets[2]=new Widget(1003,"Zebra", 3);
       
       // print out hte widgets before sorting the array
       for (int i=0; i<widgets.length; i++)
       {
        System.out.println("---Before Sort");
           System.out.println(widgets[i]);
       }
       
       //sorth the array
        System.out.println("---------After Sort--------------");
       Arrays.sort(widgets);
       // print out the widgets after sorting the array
       for (int i=0; i<widgets.length; i++)
       {
           System.out.println(widgets[i]);
       }
       
    }
}
