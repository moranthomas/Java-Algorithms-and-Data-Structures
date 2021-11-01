public class BinarySearch {

    public int runBinarySearchIteratively(int[] sortedArray, int searchKey, int low, int high) {

        int index = Integer.MAX_VALUE;

        while (low <= high) {

            // important to do it this way for very large arrays.
            int mid = low  + ((high - low) / 2);

            if (sortedArray[mid] < searchKey) {
                low = mid + 1;
            } else if (sortedArray[mid] > searchKey) {
                high = mid - 1;
            } else if (sortedArray[mid] == searchKey) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int runBinarySearchRecursively(int[] sortedArray, int searchKey, int low, int high) {

        // important to do it this way for very large arrays.
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        // NOTE - no while loop required.
        if (searchKey == sortedArray[middle]) {
            return middle;
        } else if (searchKey < sortedArray[middle]) {
            // search bottom half
            return runBinarySearchRecursively(sortedArray, searchKey, low, middle - 1);
        } else {
            // search top half
            return runBinarySearchRecursively(sortedArray, searchKey, middle + 1, high);
        }
    }

}
