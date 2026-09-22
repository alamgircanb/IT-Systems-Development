package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 10 – PARALLEL ARRAYS
// ==============================

/*
----------------------------------------
Chapter 10: Parallel Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Storing related information in separate arrays
• Accessing matching elements by shared index
• Live Demo: names and scores (finding top performer)
----------------------------------------
 */
class Chapter10_ParallelArrays {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Sometimes we want to keep *related data* together,
    but each piece has a different data type.

    Example: a student's name and test score.
      • names → String[]
      • scores → int[]

    Each element at index i in one array corresponds
    to the element at index i in the other.

    Such arrays are called **parallel arrays**.
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 13: Finding Highest Score Using Parallel Arrays
    // ----------------------------------------
    /*public static void liveDemo13() {

        System.out.println("LIVE DEMO 13: Finding Highest Score Using Parallel Arrays");
        System.out.println("---------------------------------------------------------");

        String[] names = {"Bob", "Gus", "John", "Jack", "Sue", "Dave"};
        int[] scores = {123, 345, 781, 651, 341, 566};

        int indexOfMax = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[indexOfMax]) {
                indexOfMax = i;
            }
        }

        System.out.println("Top performer: " + names[indexOfMax]
                + " with score " + scores[indexOfMax]);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Top performer: John with score 781");
        System.out.println();

        System.out.println("Notice how both arrays use the same index to link names and scores.");
    }*/

    /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Parallel arrays act like a simple database table:
        Column 1 → names
        Column 2 → scores

    This concept directly supports:
      - Assignment 2 (Student Grades Project)
      - Practice Exercise 6 (product–price–quantity–total)

    Later, we can merge this logic into objects,
    but for now, parallel arrays are ideal for learning relationships.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Create two arrays: product[] and price[].
    2. Display each product name with its price.
    3. Then find the product with the highest price.
    ----------------------------------------
     */
    public static void livePrac13() {

        System.out.println("LIVE Prac 13: Finding Product with Highest price Using Parallel Arrays");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        String[] product = {"Rice", "Fish", "Beef", "Cooking Oil", "Bakery", "Clothing"};
        int[] price = {123, 345, 781, 651, 341, 566};

        for (int i = 0; i < product.length; i++) {
        
        System.out.println("Product Name: " + product[i] + " & Price: $" + price[i]);
    }
    System.out.println("-----------------------------------------------\n");

        int indexOfMax = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[indexOfMax]) {
                indexOfMax = i;
            }
        }

        System.out.println("Product Name: " + product[indexOfMax]
                + " with highest price $" + price[indexOfMax]);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Product Name: Beef with highest price $781");
        System.out.println();

    }

    public static void main(String[] args) {
        //liveDemo13();
        livePrac13();
    }
}
