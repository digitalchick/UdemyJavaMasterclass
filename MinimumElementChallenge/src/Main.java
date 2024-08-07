import java.util.Arrays;
import java.util.Scanner;
/*
Instructions for the Minimum Element Challenge:
* Write a method called readIntegers, that reads a comma delimited list of numbers,
entered by the user from the console, and then returns an array, containing those
numbers that were entered.
* Next, write a method called findMin, that takes the array as an argument, and returns the minimum value found in that array.
*In the main method
            *Call the method readIntegers, to get the array of integers from the user, and print these out, using a method
             found in java.util.Arrays.
            *Next, call the findMin method, passing the array, returned from the call to the readIntegers method.
            *Print the minimum element in the array, which should be returned from the findMin method.
            *A tip here. Assume that the user will only enter numbers - so you don't need to do any validation
              for the console input.
 */
public class Main {
    public static void main(String[] args) {
        //int num = readInteger();
        int[] currentArray = readIntegers();
        int minNum = 0;
        System.out.println("Integer Array: " + Arrays.toString(currentArray));
        minNum = findMin(currentArray);
        //reverseArray(currentArray);
        //System.out.println("Reversed: " + Arrays.toString(currentArray));
       System.out.println("The Minimum number is: " + minNum);

    }

    private static void reverse(int[] intArray){
        int[] original = Arrays.copyOf(intArray, intArray.length);
        int j = intArray.length - 1;
        for(int i = 0; i< intArray.length; i++){
            intArray[j] = original[i];
            j--;
        }
    }

    private static void reverseArray(int[] intArray){
        int halflength = intArray.length/2;
        int maxIndex = intArray.length-1;

        int tempLowValue = 0;

        for(int i=0; i< halflength;i++){
            tempLowValue = intArray[i];
            intArray[i] = intArray[maxIndex];
            intArray[maxIndex] = tempLowValue;

            maxIndex--;
        }
    }
    public static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        String input;

        //String[] stringList = new String[];

        System.out.println("Please enter a comma delimited list of integers");

        input = scanner.nextLine();
        String[] stringList = input.split(",");

        int[] integerList = new int[stringList.length];
        for (int i = 0; i < stringList.length; i++) {
            integerList[i] = Integer.parseInt(stringList[i]);
        }


        return integerList;


    }

//    public static int findMin(int[] array) {
//        int min = array[0];
//
//        for (int i : array) {
//            if (i < min) {
//                min = i;
//            }
//        }
//        //array = Arrays.sort(array);
//
//
//        return min;
//
//    }


        private static int readInteger() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter a digit for how many elements you will put in:");


            return scanner.nextInt();
        }

        private static int[] readElements(int num) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] strElements = new String[num];
            strElements = input.split(",");
            int[] intElements = new int[num];
            int currentNum = 0;

            for (int i = 0; i < num; i++) {

                currentNum = Integer.parseInt(strElements[i]);
                intElements[i] = currentNum;

            }

            return intElements;
        }

        private static int findMin(int[] array) {

            int min = array[0];

            for (int ele : array) {

                if (ele < min) {
                    min = ele;
                }
            }

            return min;

        }


    }

