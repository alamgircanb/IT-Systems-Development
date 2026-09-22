package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 1 – INTRODUCTION TO ARRAYS
// ==============================

/*
----------------------------------------
Chapter 1: Introduction to Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Why we need arrays
• How arrays store multiple values
• How arrays make data easier to manage
• First live demo: storing and printing multiple numbers
----------------------------------------
 */
class Chapter1_Introduction {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Imagine you are writing a Java program that stores quiz scores for several students.
    Using individual variables works only for a small number of items:

        int score1 = 90;
        int score2 = 75;
        int score3 = 88;

    But what if you need to store 50 or 100 scores? Managing that many variables
    quickly becomes unmanageable. This is where ARRAYS come in.

    An array is a **collection of variables of the same data type** stored under one name.
    Arrays allow us to organize, search, and process data efficiently.

    Think of an array like a *row of labeled boxes*:
    each box can hold one value, and we can access a specific box by its index number.
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 1: From Single Variable to Array
    // ----------------------------------------

    /*public static void liveDemo1() {

        System.out.println("LIVE DEMO 1: From Single Variable to Array");
        System.out.println("------------------------------------------");

        // Problem: store and print 5 quiz scores.
        // Instead of using 5 different variables, we use one array.

        int[] scores = new int[5];
        scores[0] = 90;
        scores[1] = 75;
        scores[2] = 88;
        scores[3] = 92;
        scores[4] = 79;

        System.out.println("Here are the 5 stored quiz scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score " + (i + 1) + ": " + scores[i]);
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Score 1: 90");
        System.out.println("Score 2: 75");
        System.out.println("Score 3: 88");
        System.out.println("Score 4: 92");
        System.out.println("Score 5: 79");
        System.out.println();

        System.out.println("Notice how the loop visits each array element automatically.");
        System.out.println("We can now store and display any number of scores just by changing the array size!");
    }*/

 /*
    ----------------------------------------
    REFLECTION:
    ----------------------------------------
    • Arrays reduce repetition.
    • The same logic can handle 5 or 500 values without rewriting code.
    • Loops and arrays work hand in hand to manage data efficiently.

    ----------------------------------------
    TRY THIS:
    ----------------------------------------
    Create a new program that:
    1. Declares an array of 3 temperatures (in Celsius)
    2. Assigns values manually
    3. Prints them all with their average temperature
    ----------------------------------------
    * @author  Md Alamgir Hossain
     */
    static void livePrac() {
        System.out.println("Live Prac: From Single Variable to Array");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        int[] temp = new int[3];
        temp[0] = 100;
        temp[1] = 105;
        temp[2] = 75;
        System.out.println("Here are the 5 stored quiz scores: ");
        for (int i = 0; i < temp.length; i++) {
            System.out.println("The Temperature " + (i + 1) + ":" + temp[i] + "C");
        }
    }
static void livePracExtra(){
    int[] studentAge = new int[6];
    String [] studentName= new String[6];
    studentAge[0]= 35;
    studentAge[1]=30;
    studentAge[2]=50;
    studentAge[3]=35;
    
    studentName[0]="Md Alamgir Hossain";
    studentName[1]="Arjit chakma";
    studentName[2]="Moksudul";
    studentName[3]="Vineesh";
    
    int[][] incomeExpense=new int[5][3];
    incomeExpense [0][0]=15000;
    incomeExpense [0][1]=12000;
    incomeExpense [1][0]=10000;
    incomeExpense [1][1]=8000;
    incomeExpense [2][0]=5000;
    incomeExpense [2][1]=3000;
    
     System.out.println("Student name:            "+java.util.Arrays.toString(studentName));
    System.out.println("Student Age:             " + java.util.Arrays.toString(studentAge));
    System.out.println("Student Income and Expenditure :  "+java.util.Arrays.deepToString(incomeExpense));
    
    for (int i=0;i<studentAge.length;i++){
        System.out.println("Student Name : "+i+1+" is "+studentName[i]);
    }
    
}
    public static void main(String[] args) {
        //liveDemo1();
        livePrac();
        livePracExtra();
    }
}
