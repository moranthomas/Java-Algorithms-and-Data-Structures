public class BubbleSort {

    static int[] sort(int[] array) {

        boolean isSorted = true;
        for(var i=0; i < array.length; i++)
            for(var j=1; j < array.length-i; j++) {
                if(array[j] < array[j-1]) {
                    // Swap the 2 elements
                    var temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    // if we had to do a swap it means that the array is not in fact sorted yet
                    isSorted = false;
                }
                if(isSorted)
                    return array;   // no need to iterate the outside loop again
            }
        return array;
    }
}
