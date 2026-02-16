public class Rekorsia {
    /**
     * O(n) time complexity, O(n) space complexity
     * This method calculates the sum of all elements in an array using recursion.
     * The helper method takes an additional parameter 'index' to keep track of the current position in the array.
     * Base case: when index reaches the length of the array, return 0.
     * Recursive case: add the current element to the sum of the rest of the array.
     * This is a basic example of how recursion can be used to solve problems that involve processing elements in a data structure, such as an array.
     * @param arr
     * @return
     */
    public static int sumOfArray(int[] arr) {
        return sumOfArrayHelper(arr, 0);
    }


    private static int sumOfArrayHelper(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumOfArrayHelper(arr, index + 1);
    }


    /**
     * O(n) time complexity, O(n) space complexity
     * This method checks if a given string contains the character 'x' using recursion.
     * The helper method takes an additional parameter 'index' to keep track of the current position
     * in the string. Base case: when index reaches the length of the string, return false.
     * Recursive case: if the current character is 'x', return true; otherwise, continue
     * checking the rest of the string.
     * @param a - String
     * @return if the string contains 'x', false otherwise
     */
    public static boolean HasX(String a){
        return HasXHelper(a, 0);
    }
    private static boolean HasXHelper(String a, int index){
            if (index == a.length()) {
                return false;
            }
            if (a.charAt(index) == 'x') {
                return true;
            }
            return HasXHelper(a, index + 1);
    }




    static void main() {
        int[] myArray = {1, 2, 3, 4, 5};
        int result = sumOfArray(myArray);
        IO.println("The sum of the array is: " + result); // Should print 15
    }
}
