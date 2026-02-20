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

    /**
     * O(2^n) time complexity, O(n) space complexity
     * This method checks if there is a subset of the given array that sums up to the
     * target value using recursion. The method takes an additional parameter 'index' to keep track of the current position in the array.
     * Base case: if the target is 0, return true (found a valid subset that sums to the target). If index reaches the length of the array or target becomes negative, return false (no valid subset found).
     * Recursive case: include the current element and check if the remaining target can be achieved,
     * or exclude the current element and check if the target can be achieved without it. This method explores all possible combinations of including or excluding each element, leading to an exponential time complexity.
     * @param arr
     * @param target
     * @param index
     * @return
     */
    public static boolean isSubSetSum(int[] arr, int target,int index) {
        if (target ==0) {
            return true;
        }
        if (index == arr.length || target < 0 || arr.length == 0) {
            return false;
        }
        // Include the current element and check if the remaining target can be achieved
        if (isSubSetSum(arr, target - arr[index], index + 1)){
            return true;
        }
        // Exclude the current element and check if the target can be achieved
        return isSubSetSum(arr, target, index + 1);
    }

    /**
     * O(2^n) time complexity, O(n) space complexity
     * This method checks if it is possible to reach an index with value 0 in the
     * array by starting from a given index and moving either left or right by the value at the current index. The method takes an additional parameter 'index' to keep track of the current position in the array.
     * Base case: if the current index is out of bounds, return false. If the value at the current index is 0, return true (found a valid path to an index with value 0). Recursive case: move right by the value at the current index and check if it leads to a valid path, or move left by the value at the current index and check if it leads to a valid path. This method explores all possible paths from the starting index, leading to an exponential time complexity.
     * Recursive calls will be made to explore both directions (left and right) from the current index, and the method will return true if any path leads to an index with value 0, or false if all paths are exhausted without finding such an index.
     * @param arr
     * @param index
     * @return
     */
    public static boolean CanReachZero (int [] arr, int index){
        if (index < 0 || index >= arr.length) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        if (index + arr[index] < arr.length) {
            boolean foundRight = CanReachZero(arr, index + arr[index]);
            if (foundRight == true) {
                return true;
            }
        }
        if (index - arr[index] >= 0) {
            boolean foundLeft = CanReachZero(arr, index - arr[index]);
            if (foundLeft == true) {
                return true;
            }
        }
        return false;
    }
    static void main() {
        int[] myArray = {1, 2, 3, 4, 5};
        int result = sumOfArray(myArray);
        IO.println("The sum of the array is: " + result); // Should print 15
    }
}
