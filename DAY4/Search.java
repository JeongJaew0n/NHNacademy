package DAY4;


// number1 - Binary Search 구현
public class Search {
    public int binarySearch(int[] array, int key) {

//        // 정렬.
//        for(int i=0; i<array.length; i++) {
//
//            int temp = array[i];
//            int index = 0;
//
//            for(int j=i+1; j<array.length; j++) {
//                if(array[j] < temp) {
//                    temp = array[j];
//                    index = j;
//                }
//            }
//
//            if(index !=0) {
//                temp = array[i];
//                array[i] = array[index];
//                array[index] = temp;
//            }
//         }
//        System.out.println("정렬끝");

        int high, middle, lower;

        lower = 0;
        high = array.length-1;

        while(lower <= high) {
            middle = (high + lower) /2;
            if(array[middle] == key) {
                return middle;
            }

            if(array[middle] < key) {
                lower = middle+1;
            }
            else {
                high = middle;
            }
        }

        return -1;
    }


    public boolean isSorted() {
        return false;
    }
}
