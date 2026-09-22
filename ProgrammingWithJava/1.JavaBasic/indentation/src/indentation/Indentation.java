/*
 *Java 
indentation 
Indent-move to right to look good 
Java indentation is not matter (but python indentation matter) 
For humans and other programmers, it good understanding good. 

Indentation is space (there is general rule of thumb we say that opening Curley bracket increases indentation. 
Opening the Curley bracket increases indentation; closing Curley bracket decreases indentation. 
Whenever you are coding, make sure you are seriously observable. 

Format code block by block.
(it helps to be human readable) formatting after every line of code  may be tedious 
and too much work but formatting all in the closing may make you a mess. 

Blocks 
Between the Curley bracket is block 

If () { 
Whatever I am typing it is a block of code 

System.out.println() 

} 
Opening curley bracket start the block and closing curley bracket close the block 


A loop continue till condition is true
A loop naturally ends when condition becomes false
break and condition is usual for switch (there may be questin)
difference between for while and for (achieve same purpose) fixed time (for is more tidy)
when and why we use do while (do not overthink it)


question about menu
if you follow the best practices ( user input price but skip it will iterate)
for option based work switch is very clear, 

make a question about do while
why and when and how we use different of loop and condition in code


Switch and break, continue
Play with switch, continue and break (what will happen without break, continue (it is called switch fall through) switch without break or without continue)
some trick question there.
when default will be treated and when the default will not be treated.


Input
for loop (code tracing, print out a current counter, print out the number -10 to 10 , all even number , multiple of 10)


all
operators
equal to , not equall to == , = , ++, +=


do -while
boolean
control structure (while, do-while, for )
improve logic sense should improve

anything parenthesis is call block
what should indentation do( closing curley 
the loop end condition false
switch without break fallthrough (go next case)
loop atleast one (do while)
indentation is for human and braces control the code block)
only for loop can run fixed number of time (false, any loop can run fixed number of time if writen currectly)
loop repeate until condition true, and ends conditon false
inclusion and exclution (<= or <)

 */
package indentation;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Indentation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /**
         * int x =1;
         *
         * switch (x){ case 1: System.out.println("Case 1"); //break
         *
         * case 2: System.out.println("Case 2"); break;
         *
         * default: System.out.println("Case Default"); } }
         */
        Scanner input = new Scanner(System.in);

        System.out.println("Please input your Menu");
        int menu = input.nextInt();

        if (menu == 1) {
            System.out.println("Please input your option");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Case 1");

                case 2:
                    System.out.println("Case 2");
                case 3:
                    System.out.println("Case 3");
                default:
                    System.out.println("Case 4");
            }
        } else if (menu == 2) {
          
            
            for (int i = 0; i < 5; i++) {
                String command = (i == 3) ? "SKIP" : "PROCESS";

                switch (command) {
                    case "SKIP":
                        // This 'continue' applies to the 'for' loop, not the 'switch'.
                        System.out.println("Skipping item: " + i);
                        continue; // Jumps to i++
                    case "PROCESS":
                        // ... normal processing ...
                        break;
                }

                System.out.println("Processing complete for item: " + i);
            }
        } else {
            char ch = 'f';

            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("Vowel");
                    break;
                default: {
                    System.out.println("Consonant");

                }
            }
        }
        
    }
}
