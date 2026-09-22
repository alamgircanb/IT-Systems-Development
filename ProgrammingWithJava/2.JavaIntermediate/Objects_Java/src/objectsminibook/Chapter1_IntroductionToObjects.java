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
// CHAPTER 1 – INTRODUCTION TO OBJECTS
// ===========================================================

/*
------------------------------------------------------------
Chapter 1: Introduction to Objects
------------------------------------------------------------
This chapter explains the foundation of object-oriented
programming. Many learners find the idea of “objects” abstract, so this chapter
helps build a strong understanding before moving to more advanced concepts.

What this chapter explains:
• What an object represents
• The meaning of state and behaviour
• Why objects make programs easier to manage
• The difference between a class and an object
• A complete demonstration showing object usage
------------------------------------------------------------
*/

class Chapter1_IntroductionToObjects {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT IS AN OBJECT?
    ------------------------------------------------------------
    An object represents something meaningful inside a program.
    It always contains two essential parts:

    • State      – stored information
    • Behaviour  – actions the object can perform

    A real-life comparison:
    -----------------------
    Think about a simple light.
      - Its state is whether it is ON or OFF.
      - Its behaviour is the ability to turn on, turn off, or
        check whether it is currently on.

    In programming, we use objects to represent these kinds of
    meaningful units so the program stays organized and clear.

    ------------------------------------------------------------
    WHY OBJECTS?
    ------------------------------------------------------------
    Without objects, a program may contain many disconnected
    variables and functions. It becomes difficult to see which
    functions belong to which data.

    Objects keep related information and actions together.

    ------------------------------------------------------------
    HOW OBJECTS WORK IN JAVA
    ------------------------------------------------------------
    Java separates two layers:

    • The CLASS      – a blueprint describing what data and
                        behaviour objects will have.
    • The OBJECT     – an actual created entity stored in memory,
                        built from the class blueprint.

    Diagram:

         Class (Light) blueprint
         -------------------------
         | boolean on             |
         | turnOn()               |
         | turnOff()              |
         | isOn()                 |
         -------------------------

         ↓ create objects ↓

         Light kitchen
         -----------------
         | on = true      |
         -----------------

         Light hallway
         -----------------
         | on = false     |
         -----------------

    Each object stores its own state separately, even though both
    come from the same class.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – BASIC LIGHT OBJECT
    // ------------------------------------------------------------

    static class Light {

        private boolean on;   // object state

        public void turnOn()  { on = true; }
        public void turnOff() { on = false; }
        public boolean isOn() { return on; }
    }


    public static void liveDemo1() {

        System.out.println("LIVE DEMO 1: Working with an Object");
        System.out.println("------------------------------------");

        Light kitchen = new Light();

        kitchen.turnOn();
        System.out.println("Kitchen light on? " + kitchen.isOn());

        kitchen.turnOff();
        System.out.println("Kitchen light on? " + kitchen.isOn());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Kitchen light on? true");
        System.out.println("Kitchen light on? false");
        System.out.println();

        System.out.println("Each Light object controls its own ON/OFF state.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    As a program grows, the same object often needs more abilities.
    Instead of rewriting the entire system, we extend the class.

    For example, the Light class might later support:
      • dimming
      • blinking modes
      • automatic shutoff
      • timers

    Each new behaviour becomes another method inside the class.
    All existing Light objects immediately gain access to the new
    features because they share the same blueprint.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Add a toggle() method to the Light class that switches
       the light to the opposite state.

    2. Create two Light objects.

    3. Turn one on, leave the other off, and print both states
       to confirm that each object maintains its own state.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo1();
    }
}

