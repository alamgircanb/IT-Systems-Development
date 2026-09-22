/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectsminibook;

/**
 *
 * @author islammd
 */
// ===========================================================
// CHAPTER 2 – CLASSES AND INSTANCES
// ===========================================================

/*
------------------------------------------------------------
Chapter 2: Classes and Instances
------------------------------------------------------------
This chapter strengthens the understanding of how classes and
objects relate to one another. Many learners confuse these two
ideas.

What this chapter explains:
• A class as a blueprint or definition
• An object as a created instance stored in memory
• Why each object has its own independent data
• How multiple objects are created from one class
• A complete demonstration using two Person objects
------------------------------------------------------------
*/

class Chapter2_ClassesAndInstances {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT IS A CLASS?
    ------------------------------------------------------------
    A class is a definition.  
    It describes:

      • what information objects will store (fields)
      • what actions they can perform (methods)

    The class itself does NOT store the data for any specific
    person, light, circle, or account. It only describes what
    the object *will* have.

    Blueprint analogy:
    ------------------
    A blueprint explains how to build a house, but it does not
    contain furniture or paint. Only the actual built houses do.

    Similarly:
        Person.java is the description.
        The created Person objects hold the actual information.

    ------------------------------------------------------------
    WHAT IS AN OBJECT (INSTANCE)?
    ------------------------------------------------------------
    When we write:

        Person p = new Person();

    Java creates a NEW object in memory.

    The variable p stores a reference (an address) that points to
    the object.

    Diagram:

           p
           ↓
        +----------+
        | name: ?  |
        | age:  ?  |
        +----------+

    If we create a second object:

        Person p2 = new Person();

    Then p2 points to a separate memory location.  
    Changing p1 does not affect p2.

    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – TWO PERSON OBJECTS
    // ------------------------------------------------------------

    static class Person {

        String name;
        int age;

        public void introduce() {
            System.out.println(name + " is " + age + " years old.");
        }
    }


    public static void liveDemo2() {

        System.out.println("LIVE DEMO 2: Two Independent Objects");
        System.out.println("-------------------------------------");

        Person p1 = new Person();
        p1.name = "Alice";
        p1.age = 22;

        Person p2 = new Person();
        p2.name = "Sam";
        p2.age = 30;

        p1.introduce();
        p2.introduce();

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Alice is 22 years old.");
        System.out.println("Sam is 30 years old.");
        System.out.println();

        System.out.println("Each object stores its own values separately.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Once a class defines its structure, it is common to add new
    behaviours as the program evolves.

    A Person class may later include:
      • updateAge(newAge)
      • rename(newName)
      • calculateBirthYear()

    Each method acts on the specific object calling it. This is
    why objects behave independently even though they share the
    same class definition.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Add an updateAge(int newAge) method to the Person class.

    2. Create two Person objects with different ages.

    3. Update the age of only one object, then print both objects
       to verify that each instance maintains its own data.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo2();
    }
}

