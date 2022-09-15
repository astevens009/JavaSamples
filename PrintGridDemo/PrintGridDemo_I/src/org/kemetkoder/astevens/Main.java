package org.kemetkoder.astevens;

public class Main {
    static final int UPPERLIMIT = 10;

    public static void main(String[] args) {

	    // TODO: Generate an array filled with the dash ( - ) character
        char[] charArray = generateArray(UPPERLIMIT);

        // TODO: Print the contents of the array n times on separate lines
        displayGrid(charArray);
    }

    private static void displayGrid(char[] charArray) {
        // Print an initial space when displaying to the console
        System.out.println();
        for(int i = 0; i < UPPERLIMIT; i++){
            for(int j = 0; j < UPPERLIMIT; j++){
                System.out.printf("%c\t", charArray[j]);
            }
            System.out.println();
        }
    }

    private static char[] generateArray(int arraySize) {
        char[] gridArray = new char[arraySize];

        for(int index = 0; index < arraySize; index++){
            gridArray[index] = '-';
        }

        return gridArray;
    }
}
