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
// CHAPTER 13 – REVIEW AND REFLECTION
// ===========================================================

/*
------------------------------------------------------------
Chapter 13: Review and Reflection
------------------------------------------------------------
This final chapter brings together all of the major ideas from
the Objects module. Object-oriented programming becomes much
easier once students see how the pieces fit together: fields,
constructors, getters/setters, behaviour, encapsulation, UML,
and relationships among multiple objects.
------------------------------------------------------------
*/

class Chapter13_ReviewAndReflection {

    /*
    ------------------------------------------------------------
    1. KEY IDEAS TO REMEMBER
    ------------------------------------------------------------

    • A class is a blueprint.
      It describes what information objects store and what actions
      they can perform.

    • Objects have state.
      State comes from the values stored in private fields.

    • Encapsulation protects state.
      Private fields + methods ensure values stay valid.

    • Constructors initialize the object.
      They place the object in a safe, predictable starting state.

    • Getters and setters manage access.
      Setters validate incoming values.
      Getters provide controlled read access.

    • Behaviour defines what an object can do.
      Compute, update, compare, display, or perform tasks using
      the object’s fields.

    • UML is a structural contract.
      It tells you exactly which fields and methods the class requires.

    • Multiple objects represent multiple real-world items.
      Each object keeps its own state and behaves using its own data.

    • Methods can receive objects.
      Passing objects allows methods to inspect or modify shared state.

    All of these ideas work together, not separately.
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    2. CONNECTING THE CONCEPTS (THE COMPLETE PICTURE)
    ------------------------------------------------------------
    Here is a complete mental model of an object:

        +-------------------------------------------+
        |                 CLASS                     |
        |   (blueprint describing structure)        |
        +-------------------------------------------+
        | private fields → object's memory          |
        | constructors  → starting state            |
        | getters      → controlled access          |
        | setters      → validation rules           |
        | behaviour    → actions / work             |
        +-------------------------------------------+
        |          OBJECT INSTANCES                 |
        |  Many objects with different values        |
        +-------------------------------------------+

    A class defines a general idea.
    Objects represent actual usable items.

    Example:
       Wallet → blueprint
       wallet1 (balance 10), wallet2 (balance 250) → objects

    Same class, different state, same behaviour rules.
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    3. COMMON MISUNDERSTANDINGS CLEARED UP
    ------------------------------------------------------------

    MISCONCEPTION 1:
    “Fields can be public because it’s easier.”

      → This breaks encapsulation, allows invalid values,
        and makes objects unreliable.

    MISCONCEPTION 2:
    “Constructors return objects.”

      → Constructors do NOT return anything.
        They initialize the object that is being created.

    MISCONCEPTION 3:
    “this is optional.”

      → this is required whenever field names and parameters
        overlap. It increases clarity and prevents mistakes.

    MISCONCEPTION 4:
    “Objects passed to methods are copies.”

      → Java passes references — the method can modify the original.

    MISCONCEPTION 5:
    “Behaviour and fields are unrelated.”

      → Behaviour must always use or update the object’s state.
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    4. REFLECTION QUESTIONS
    ------------------------------------------------------------
    (Instructor may use some of these in class discussion.)

     • How does encapsulation improve reliability?
     • Why must fields be private in a well-designed class?
     • Why are constructors important, and what would happen if
       a class had none?
     • When should this be used?
     • How does behaviour connect directly to an object's fields?
     • How do UML diagrams help in building correct classes?
     • What does it mean for two objects to have the same class
       but different states?
     • Why can methods modify the objects passed to them?

    These questions ensure deep understanding and prepare learners
    for quizzes and assignments.
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    5. TRY THIS (FINAL EXERCISE)
    ------------------------------------------------------------
    1. Design a class BankCard with private fields:
         - ownerName
         - balance

    2. Add:
         - a constructor
         - deposit and withdraw methods
         - getters for both fields

    3. Create several BankCard objects and compare their balances.

    4. Explain in your own words how encapsulation protects the
       BankCard from invalid values.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {

        System.out.println("Objects MiniBook – Final Reflection");
        System.out.println("-----------------------------------");
        System.out.println("Review the key ideas from this chapter to reinforce");
        System.out.println("your understanding of object-oriented programming.");
    }
}

