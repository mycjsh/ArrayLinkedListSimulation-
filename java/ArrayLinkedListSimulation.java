//Name: Mayco Josh F, Pallaya
    //Section: BSIT 2A
    //Date: 09-05-2025
  
    //ArrayLinkedListSimulation.java
    //This program simulates a linked list using arrays in Java.
    //It supports basic queue and stack operations with user interaction:
    //add(int value): adds an element to the end (enqueue)
    //poll(): removes and returns the first element (dequeue)
    //peek(): returns the first element without removing it
    //pop(): removes and returns the last element (stack pop)
    //The array resizes dynamically when full.
import java.util.Scanner;
    
    public class ArrayLinkedListSimulation 
    {
        private int[] iElements;  // array to store elements.
        private int iSize;        // current number of elements.

        //Constructor initializes the array with capacity 5 and size 0.
        public ArrayLinkedListSimulation() 
        {
            iElements = new int[5];
            iSize = 0;
        }
        //Adds a new element at the end of the array.
        //Resizes the array if it is full.
        //value the integer to add.
        public void add(int iValue) 
        {
            if (iSize == iElements.length) 
            {
                // Resize array: double the capacity
                int[] iNewArray = new int[iElements.length * 2];
                System.arraycopy(iElements, 0, iNewArray, 0, iElements.length);
                iElements = iNewArray;
            }
            iElements[iSize++] = iValue;
            System.out.println(iValue + " added.");
        }
        //Removes and returns the first element.
        //Shifts remaining elements left.
        //Returns -1 if empty.
        //@return the first element or -1 if empty
        public int poll() 
        {
            if (iSize == 0) 
            {
                System.out.println("Poll operation failed: list is empty.");
                return -1;
            }
            int firstElement = iElements[0];
            for (int i = 1; i < iSize; i++) 
            {
                iElements[i - 1] = iElements[i];
            }
            iSize--;
            System.out.println(firstElement + " polled (removed from front).");
            return firstElement;
        }
        //Returns the first element without removing it.
        //Returns -1 if empty.
        //Return the first element or -1 if empty.
        public int peek() 
        {
            if (iSize == 0) 
            {
                System.out.println("Peek operation failed: list is empty.");
                return -1;
            }
            System.out.println("Peeked value: " + iElements[0]);
            return iElements[0];
        }
        //Removes and returns the last element.
        //Returns -1 if empty.
        // return the last element or -1 if empty.
        public int pop() 
        {
            if (iSize == 0) 
            {
                System.out.println("Pop operation failed: list is empty.");
                return -1;
            }
            int iLastElement = iElements[iSize - 1];
            iSize--;
            System.out.println(iLastElement + " popped (removed from end).");
            return iLastElement;
        }
        //Returns a copy of the array containing only the active elements.
        private int[] getElements() 
        {
            int[] iActiveElements = new int[iSize];
            System.arraycopy(iElements, 0, iActiveElements, 0, iSize);
            return iActiveElements;
        }
        //Displays the current elements in the list.
        public void display() 
        {
            if (iSize == 0) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Current List: ");
        int[] iActiveElements = getElements();
        boolean bFirst = true;
        for (int iValue : iActiveElements) 
        {
            if (!bFirst) System.out.print(", ");
            System.out.print(iValue);
            bFirst = false;
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner sScanner = new Scanner(System.in);
        ArrayLinkedListSimulation aList = new ArrayLinkedListSimulation();

        while (true) 
        {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Add (enqueue)");
            System.out.println("2. Poll (dequeue)");
            System.out.println("3. Peek (view first element)");
            System.out.println("4. Pop (remove last element)");
            System.out.println("5. Display all elements");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String sInput = sScanner.nextLine();

            int iChoice;
            try 
            {
                iChoice = Integer.parseInt(sInput);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                continue;
            }
            if (iChoice == 1) 
            {
                System.out.print("Enter an integer to add: ");
                String valToAdd = sScanner.nextLine();
                try 
                {
                    int value = Integer.parseInt(valToAdd);
                    aList.add(value);
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
            else if (iChoice == 2) 
            {
                aList.poll();
            }
            else if (iChoice == 3) 
            {
                aList.peek();
            }
            else if (iChoice == 4) 
            {
                aList.pop();
            }
            else if (iChoice == 5) 
            {
                aList.display();
            }
            else if (iChoice == 6) 
            {
                System.out.println("Exiting program... Goodbye!!!");
                sScanner.close();
                return;
            }
            else 
            {
                System.out.println("Invalid choice. Please select from 1 to 6.");
            }
        }
    }
}
