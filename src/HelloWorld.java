public class HelloWorld {
    public static void main(String[] args){
        System.out.print("Hello World\n");

        /*
        Create an int variable named myFavoriteNumber and assign your favorite number to it, then print it out to the console.
        */
        {
          int myFavoriteNumber = 7;
          System.out.println("" + myFavoriteNumber);
          /*
          Create a String variable named myString and assign a string value to it, then print the variable out to the console.
          */
          String myString = "alphabet: abcdefghijklmnopqrstuvwxyz";
          System.out.println("" + myString);
          /*
          Change your code to assign a character value to myString. What do you notice?
          */
          myString += 'A';
          /*
          Change your code to assign the value 3.14159 to myString. What happens?
          */
          myString += ("" + 3.14159);
        }

        {
          /*
          Declare an long variable named myNumber, but do not assign anything to it. Next try to print out myNumber to the console. What happens?
          */
          long myNumber;
          //System.out.println("" + myNumber); <-- doesn't compile
          /*
          Change your code to assign the value 3.14 to myNumber. What do you notice?
          */
          // myNumber = 3.14; <-- compiler error
          /*
          Change your code to assign the value 123L (Note the 'L' at the end) to myNumber.
          */
          myNumber = 123L;
          /*
          Change your code to assign the value 123 to myNumber.
          */
          myNumber = 123;
          /*
          Why does assigning the value 3.14 to a variable declared as a long not compile, but assigning an integer value does?
          */
          System.out.println("The long type is a long integer (and integer is 32 bits while a long is 64 bits).\n" +
            "The long type does not use the same arithmetic logic units on the CPU as a decimal number,\n" +
            "so it cannot be evaluated as one.\n");
        }
        /*
        Change your code to declare myNumber as a float. Assign the value 3.14 to it. What happens? What are two ways we could fix this?
        */
        {
          float myNumber = 3.14F;
        }
        /*
        Copy and paste the following code blocks one at a time and execute them
        */
    }
}
