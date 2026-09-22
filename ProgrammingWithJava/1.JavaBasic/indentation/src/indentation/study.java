/*
 *What is Indentation? 
Why Indentation is Important 
How to Indent in Java 
 */
package indentation;

/**
 *
 * @author User
 */
public class study {

    /**
     * Indentation is a stylistic element where you insert spaces or tabs to
     * shift lines of code to the right. It is typically used to show the
     * hierarchical structure and nesting of code elements, such as:
     *
     * The body of classes and methods
     *
     * The code within control flow statements (e.g., if, for, while)
     *
     * The code within exception handling blocks (e.g., try, catch)
     *
     * In the example below, the lines inside the main method and the if
     * statement are indented:
     *
     * *
     * @param args
     */
    public static void main(String[] args) { // Start of main method block
        int x = 10;
        if (x > 5) { // Start of if statement block
            System.out.println("x is greater than 5");
        } // End of if statement block
    } // End of main method block
    
/**
 * Why Indentation is Important
While Java compilers ignore most whitespace, including indentation, for the execution of the program, it is crucial for human readability and maintenance:

Clarity and Structure: It makes the code's structure immediately clear, showing which statements belong to which block (e.g., which lines are inside a loop or a conditional statement).

Maintainability: Properly indented code is much easier for developers (including your future self) to navigate, understand, debug, and modify.

Error Reduction: It helps spot common errors like mismatched curly braces ({}) or logic errors where a line of code is mistakenly placed outside a loop or condition.

Professionalism: Following standard conventions (like the Oracle Code Conventions or Google Java Style) makes code consistent across teams, which is a hallmark of professional development.
 */
  /**
   * How to Indent in Java
Standard Practice
The universally accepted standard for Java indentation is:

Use 4 spaces for each level of indentation. Tabs are often discouraged because their visual width can vary depending on the text editor, leading to inconsistencies.

The opening curly brace ({) is typically placed on the same line as the construct it belongs to (e.g., class, method, if statement), followed by a space. This is known as the K&R style (or Java style).

The code within the block is indented one level further.

The closing curly brace (}) is on its own line, aligned with the line that contains the corresponding opening brace.
     * @param args
   */  
 public static void how(String[] args) {
        int count = 5;
        
        // 4 spaces for if block
        if (count > 0) {
            
            // 8 spaces for nested block
            for (int i = 0; i < count; i++) {
                System.out.println("Iteration: " + i);
            }
            
        } else {
            System.out.println("Count is zero or negative.");
        }
 }
 /**
  * Tools
Fortunately, you don't usually have to manually insert four spaces for every line. Modern Integrated Development Environments (IDEs) like IntelliJ IDEA, Eclipse, and VS Code offer powerful features:

Automatic Indentation: The IDE automatically indents code correctly as you type.

Code Formatters: You can use a built-in "Format Code" or "Reformat Code" command (often a keyboard shortcut) to automatically apply the configured indentation and style rules to an entire file or selection.

Customization: You can configure the IDE to use 4 spaces, 2 spaces, or tabs, though 4 spaces is the standard for Java.
  */
}
   

