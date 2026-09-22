
package arraysminibook;

/**
 *
 * @author islammd
 */


// ==============================
// CHAPTER 17 – REVIEW AND REFLECTION
// ==============================

/*
----------------------------------------
Chapter 17: Review and Reflection
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Summary of all array concepts
• Review questions and reflection prompts
• Final self-check for students
----------------------------------------
*/

class Chapter17_ReviewAndReflection {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Congratulations! You’ve now completed the Arrays module.

    By this point, you should be able to:
      ✓ Declare, initialize, and access arrays
      ✓ Populate arrays using loops or user input
      ✓ Compute totals, averages, and counts
      ✓ Find min/max values and their indices
      ✓ Search arrays and track frequency
      ✓ Use parallel arrays for linked data
      ✓ Pass arrays to methods and overload them
      ✓ Sort and reverse arrays
      ✓ Debug array-related errors
      ✓ Apply arrays in real-world programs

    Let’s summarize these ideas and self-test.
    ----------------------------------------
    */

    // ----------------------------------------
    // MINI-QUIZ REVIEW QUESTIONS
    // ----------------------------------------

    public static void reviewQuiz() {

        System.out.println("ARRAYS MODULE – SELF CHECK REVIEW");
        System.out.println("---------------------------------");

        System.out.println("1. What is the index of the first element in an array?");
        System.out.println("   (a) 1    (b) 0    (c) length-1\n");

        System.out.println("2. How do you find the number of elements in an array?");
        System.out.println("   Answer: Use arrayName.length\n");

        System.out.println("3. True or False: Arrays in Java can change their size after creation.\n");

        System.out.println("4. Write a single line of code to declare and fill an int array with 3 values: 5, 10, 15.");
        System.out.println("   Answer: int[] arr = {5, 10, 15};\n");

        System.out.println("5. When passing arrays to methods, are they copied or referenced?");
        System.out.println("   Answer: Passed by reference – methods access the same memory.\n");

        System.out.println("6. Describe in one sentence what a parallel array is.\n");

        System.out.println("7. Bonus: What does this code output?");
        System.out.println("   int[] a = {2, 4, 6};");
        System.out.println("   System.out.println(a[a.length - 1]);");
        System.out.println("   → Answer: 6\n");

        System.out.println("-------------------------------------------------------");
        System.out.println("End of Self-Check. Discuss your answers with a partner!");
        System.out.println("-------------------------------------------------------");
    }

    /*
    ----------------------------------------
    REFLECTION PROMPTS:
    ----------------------------------------
    • Which part of the arrays module was most challenging for you?
    • What debugging habit helped you the most?
    • How can you apply arrays in your next project or course?
    ----------------------------------------
    */

    public static void main(String[] args) {
        reviewQuiz();

        System.out.println();
        System.out.println("Final Reflection:");
        System.out.println("Think of one real-world dataset (e.g., weekly expenses, daily temperatures).");
        System.out.println("Describe how you could model and analyze it using arrays.");
        System.out.println();
        System.out.println("Congratulations — you have completed the Arrays Mini Book!");
    }
}
