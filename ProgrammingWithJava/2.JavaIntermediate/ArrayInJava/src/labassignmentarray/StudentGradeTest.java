/*
2. Student Grades Project
A local school’s teacher requires an application that calculates the overall final grade of
each student in her class. The data for each student are stored in 5 parallel arrays:
name = {"Robin", "Jo", "Kelly", "Jaimie"}
midtermScore = {28, 78, 92, 83}
finalScore = {58, 75, 96, 79}
assignmentGrade = {33, 80, 90, 83}
finalGrade = {to be calculated}
Write an application that performs the following tasks. Save your application code in a file called StudentGradeTest.java.
a)Display the values in each of the 4 populated arrays.
b)Write a class method that calculates each student’s final grade. The suggested signature for this method is:
public static int[] getFinalGrades(int[] mid, int[] fin, int[] ass) This method calculates the final grade of each student using data in the arrays midtermScore, finalScore, and assignmentGrade , and then populates the finalGrade array with the calculated value. 
Use the following grade distribution tocalculate each student’s final grade for this course:

Assignments 15%
Midterm 40%
Final 45%
c) Call getFinalGrades( ) and display the final grades.
d)Calculate and display the average of all the final grades. Verify the results of your calculations using a calculator.
e) Two more students were enrolled in this class. Their names and scores must be added to the existing data and used for calculating their final grades and the class averages.
You will have to use larger arrays. An array’s size cannot be changed once the array is declared, and so you will have to create 5 new arrays:
newName, newMidScore, newFinScore , newAssignGrade, and newFinalGrade. After you copied the data for the existing students into the first 4 elements of the new arrays, add new data to the
last 2 elements of each new array:
Name:
Midterm:
Final:
Assignment:
Terry 86 76 91
Kerry 71 75 78

f) Call getFinalGrades( ) to recalculate each student's final grade and to populate the newFinalGrade array elements with the calculated values.
g) Verify the results of your operation in the previous 2 questions by displaying the elements from each of the 5 newly created and populated arrays.
h) Calculate and display the average of all the final grades. Verify the results of your calculations using a calculator.
i) Display the name and final grade of the student with the lowest overall final grade, and the name and final grade of the student with the highest overall final grade. If more than one student has the highest overall grade or the lowest overall grade, then display information for the student whose mark occurs first in the newFinalGrade array.
j) Write a class method to find the number of students who obtained an overall final grade of 60 or higher. The suggested signature for this method is: public static int findFrequency(int[] array, intValue) Pass into this method as arguments the value 60 and the array newFinalGrade.The method should traverse the array and keep track of the number of elements whose value is equal to or greater than the value passed into the method.
k) Display the number of students who passed this class, ie. the number of students whose overall final grade is 60% or higher.
 
 */
package labassignmentarray;

/**
 *
 * @author Md Alamgir Hossain
 */
public class StudentGradeTest {
    public static void main(String[] args) {
        // Initial data arrays with data from the assignment requirement
        String[] name = {"Robin", "Jo", "Kelly", "Jaimie"};// to create a string type array named name
        int[] midtermScore = {28, 78, 92, 83};// to create an integer type array named midtermScore
        int[] finalScore = {58, 75, 96, 79};// to create an integer type array named finalScore
        int[] assignmentGrade = {33, 80, 90, 83};// to create an integer type array named assigmentGrade
        int[] finalGrade = new int[name.length]; /*to create an integer type array with length of te array (assuming that all parallel arrays are in same length
        value will be added after calculation the final grade from other arrays.*/

        System.out.println("--- 2. Student Grades Project ---");// to print a text line before the array print.

        // a) Display the values in each of the 4 populated arrays.
        System.out.println("\na) Initial Student Data:");
        System.out.println("Name:             " + java.util.Arrays.toString(name));// to print the name array
        System.out.println("Midterm Scores:   " + java.util.Arrays.toString(midtermScore));// to print the midtermScore array
        System.out.println("Final Scores:     " + java.util.Arrays.toString(finalScore));// to print the finalScore array
        System.out.println("Assignment Grades:" + java.util.Arrays.toString(assignmentGrade));// to print the assignmentGrade array

        // b) Write a class method (getFinalGrades) in the Methods class.

        
        finalGrade = Methods.getFinalGrades(midtermScore, finalScore, assignmentGrade);// c) to call getFinalGrades from methods class and to store the result to finalGrade variable
        System.out.println("\nc) Calculated Final Grades:");// to print a text line before printing the FinalGrade array result.
        System.out.println("Final Grades:     " + java.util.Arrays.toString(finalGrade));// to print finalGrade Array.

        // d) Calculate and display the average of all the final grades.
        double avgFinalGrade = Methods.calculateAverage(finalGrade);// to declare a double type variable named avgFinalGrade by calling claculateAverage method from methods class with finalGrade as parameter passed through value.
        System.out.printf("d) Average Final Grade: %.2f%%%n", avgFinalGrade);// to print avgFinalGrade with two decimal
        System.out.println("   (Verification: (44+77+94+80)/4 = 73.75)");// to print text result for verification.

        // e) Create new larger arrays and copy existing data, then add new student data.
        final int NEW_SIZE = name.length + 2; // 4 existing + 2 new = 6, out existing arrays length is four, now we will add two students value in them
        String[] newName = new String[NEW_SIZE];// to delcare a string type variable named newName with NEW_SIZE as length.
        int[] newMidScore = new int[NEW_SIZE];// to delcare an integer type variable named newMidScore with NEW_SIZE as length.
        int[] newFinScore = new int[NEW_SIZE];//to delcare an integer type variable named newFinScore with NEW_SIZE as length.
        int[] newAssignGrade = new int[NEW_SIZE];//to delcare an integer type variable named newAssignScore with NEW_SIZE as length.
        int[] newFinalGrade = new int[NEW_SIZE]; // to declare an Empty array to be populated with same size.

        // Copy existing data (using System.arraycopy for efficiency)
        System.arraycopy(name, 0, newName, 0, name.length);
        System.arraycopy(midtermScore, 0, newMidScore, 0, midtermScore.length);
        System.arraycopy(finalScore, 0, newFinScore, 0, finalScore.length);
        System.arraycopy(assignmentGrade, 0, newAssignGrade, 0, assignmentGrade.length);

        // Add new student data to the last two elements (index 4 and 5)
        int i = name.length; // Starting index for new students (4)
        newName[i] = "Terry";
        newMidScore[i] = 86;
        newFinScore[i] = 76;
        newAssignGrade[i] = 91;

        i++; // Index 5
        newName[i] = "Kerry";
        newMidScore[i] = 71;
        newFinScore[i] = 75;
        newAssignGrade[i] = 78;

        // f) Call getFinalGrades() to recalculate all final grades and populate newFinalGrade.
        newFinalGrade = Methods.getFinalGrades(newMidScore, newFinScore, newAssignGrade);

        // g) Verify the results by displaying all 5 newly created and populated arrays.
        System.out.println("\n--- g) New Student Data (6 Students) ---");
        System.out.println("Names:            " + java.util.Arrays.toString(newName));// to print the array named newName
        System.out.println("Midterm Scores:   " + java.util.Arrays.toString(newMidScore));//to print the array named newMidScore
        System.out.println("Final Scores:     " + java.util.Arrays.toString(newFinScore));////to print the array named newFinScore
        System.out.println("Assignment Grades:" + java.util.Arrays.toString(newAssignGrade));//to print the array named newAssignGrade
        System.out.println("New Final Grades: " + java.util.Arrays.toString(newFinalGrade));//to print the array named newFinalGrade
        // Recalculated Final Grades: [44, 77, 94, 80, 80, 75]

        // h) Calculate and display the average of all the new final grades.
        double newAvgFinalGrade = Methods.calculateAverage(newFinalGrade);// to declare a double type variable named newAvgFinalGrade by calling calculateAverage method from the methods class.
        System.out.printf("\nh) New Average Final Grade: %.2f%%%n", newAvgFinalGrade);// to print newAvgFinalGrade value with two decimal value
        System.out.println("   (Verification: (44+77+94+80+80+75)/6 = 75.00)");// to print a text line value to compare the values getting from the method

        // i) Display the name and final grade of the student with the lowest and highest overall final grade.
        int highestIndex = Methods.findHighestIndex(newFinalGrade);// to declare an integer variable named highestIndext by calling findHighestIndex method from methods class
        int lowestIndex = Methods.findLowestIndex(newFinalGrade);// to declare an integer variable named newFinalGrade by calling findLowestIndex method from methods class

        System.out.println("\ni) Highest and Lowest Grades:");// to print an exta text line before the result array print
        if (highestIndex != -1) {// to check if highest index is not -1 means not an empty array index.
            System.out.printf("Highest Grade: %s with %d%%%n", newName[highestIndex], newFinalGrade[highestIndex]); // to print highest final grade and it crossponding name ( Kelly with 94%)
        }
        if (lowestIndex != -1) {// to check if highest index is not -1 means not an empty array index.
            System.out.printf("Lowest Grade: %s with %d%%%n", newName[lowestIndex], newFinalGrade[lowestIndex]);   // to print lowest final grade and it crossponding name Robin with 44%
        }

        // j) Write a class method (findFrequency) in the Methods class.

        // k) Display the number of students who passed (>= 60%).
        final int PASS_THRESHOLD = 60;// declare an integer variable named PASS_THRESHOLD with Constraint final value
        int numPassed = Methods.findFrequency(newFinalGrade, PASS_THRESHOLD);// declare an integer variable named numPassed to call findFrequency method from methods class to get number of passed students

        System.out.println("\n k) Passing Students:");// to print a text line before printing the result
        System.out.printf("Number of students with a final grade of %d%% or higher: %d%n", PASS_THRESHOLD, numPassed);// to print the variable named numPassed to print number of pass students.
        // [44, 77, 94, 80, 80, 75] -> 5 students passed (all but Robin)
    }
}
