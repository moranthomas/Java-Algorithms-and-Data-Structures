public class QuickSort {

    public static int[] quickSort(int arr[], int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);

            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    private static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = (left-1);

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = swapTemp;

        return i+1;
    }

}
