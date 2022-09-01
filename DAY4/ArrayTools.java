package DAY4;

import java.util.*;

public class ArrayTools {
    public static boolean isSorted(int[] array) {

        boolean ascendingOrder = true;
        boolean descendingOrder = true;

        for(int i=0; i<array.length-1; i++) {
           // 오름차순인지 내림차순인지 모름 - 판단하기
           // 오름차순이면 다음 요소가 작아선안된다
           // 내림차순이면 다음 요소가 커서는 안된다.

            if(ascendingOrder) {
               if(array[i+1] < array[i]) {
                    ascendingOrder = false;
                    i = 0;
                    continue;
               }
            }
            else if(descendingOrder){
                if(array[i+1] > array[i]) {
                    descendingOrder = false;
                    i = 0;
                    continue;
                }
            }

            if(!ascendingOrder && !descendingOrder) {
                return false;
            }
       }
        return true;
    }

    public static int getMin(int[] array) {

        if(array == null) {
            throw new NullPointerException("Null Array!");
        }

        if(array.length == 1) {
            return array[0];
        }

        int temp = array[0];

        for(int i=1; i<array.length; i++) {
            if(array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static int getMax(int[] array) {

        if(array == null) {
            throw new NullPointerException("Null Array!");
        }

        if(array.length == 1) {
            return array[0];
        }

        int temp = array[0];

        for(int i=1; i<array.length; i++) {
            if(array[i] > temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static double getAverage(int[] array) {
        return Arrays.stream(array).average().getAsDouble();
    }

    // 3-4
    public static int[] copyDistinctArray(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }

    // 3-5
    public static int[] reverseArray(int[] array) {
        //
//        return Arrays.stream(array)
        return null;
    }

    // 3-6
    public static int[] combineArrays(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];

        for(int i=0; i<arr1.length; i++) {
            combined[i] = arr1[i];
        }
        for(int i=arr1.length; i<arr2.length; i++) {
            combined[i] = arr2[i];
        }

        return combined;
    }

    // 3-7
    public static void printAlphabetCount(String string) {
        HashMap<Character,Integer> count = new HashMap();
        for(int i=0; i<string.length(); i++) {
            if(count.containsKey(string.charAt(i))) {
                count.put(string.charAt(i),count.get(string.charAt(i))+1);
            }
            else {
                count.put(string.charAt(i),1);
            }
        }

        count.forEach((key, value) -> { System.out.println(key + " : " + value); });

    }

    // 3-8 두 개의 double 배열을 받고 같은 인덱스의 요소들 곱하고 합을 반환.
    public static double getDoubleX(double[] arr1, double[] arr2) {
        int sum = 0;
        if(arr1.length != arr2.length || arr1.length == 0) {
            throw new IllegalArgumentException("계산 불가");
        }

        for(int i=0; i<arr1.length; i++) {
            sum += arr1[i] * arr2[i];
        }
        return sum;
    }

    // 3-9 두 개의 double 배열을 받습니다.
    public static double[][] makeMatrix(double[] arr1, double[] arr2) {

        double result[][] = new double[arr1.length][arr2.length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2.length; j++) {
                result[i][j] = arr1[i] * arr2[j];
            }
        }

        return result;
    }


    // 3-10 두 개의 행렬을 받아 계산합니다.

    // 4 .Pascal 의 삼각형
    public static void printPascal(int depth) {

        List<Integer> prePascal = new ArrayList<>();
        List<Integer> pascal = new LinkedList<>();

        for(int i=0; i<depth; i++) {

            if(i<2) {
                pascal.add(1);
            }
            else {
                for(int j=1; j<i; j++) {
                    pascal.set(j, prePascal.get(j) + prePascal.get(j - 1));
                }
                pascal.add(1);
            }

            prePascal = List.copyOf(pascal);

            System.out.println(pascal.toString());
        }
    }

    // 5. 에라토스테네스의 체
    /*
    step1. 첫번째 소수인 2부터 시작한다.
    step2. 소수의 배수를 모두 제거 한다.
    step3. 다음 소수를 가져와 배수를 모두 제거 한다.
    step4. step3을 배열 끝까지 반복한다.
     */
    // 5-1 java.util.Vector, java.util.BitSet을 이용해 각각 구현한다.
    // sieveOfEratosthenes

    static class sieveOfEratosthenes {
        public static BitSet getPrimeAsBitSet(int range) {
            BitSet numbers = new BitSet();
            for(int n=0; n<range; n++) {
                numbers.set(n);
            }
            int i=0;
            while(i < range) {
                if(i<2) {
                    numbers.clear(i);
                    i++;
                    continue;
                }
                if(!numbers.get(i)) {
                    i++;
                }
                int k=i;
                for(int x = 2; x*k<range; x++) {
                    numbers.clear(k*x);
                }
                i++;
            }
            return numbers;
        }
    }

    public static void printVectorSOE(int range) {

        Vector<Integer> numbers = new Vector<>();
        for(int i=0; i<range; i++) {
            if(i<2) {
                numbers.add(0);
            }
            else {
                numbers.add(i);
            }
        }

        int i=2;

        while(i < range) {

            if(numbers.get(i) == 0) {
                i++;
            }

            int k=i;

            for(int x = 2; x*k<range; x++) {
                numbers.set(k*x,0);
            }
            i++;
        }
//        System.out.println(numbers.toString());
        for(int n=0; n<range; n++) {
            if(n%10 == 0) {
                System.out.println();
            }
            if(numbers.get(n) == 0) {
                System.out.printf("[%4c]",'x');
            }
            else {
                System.out.printf("[%4d]",numbers.get(n));
            }

        }

        System.out.println();
    }


    public static void printBitsetSOE(int range) {

        BitSet numbers = sieveOfEratosthenes.getPrimeAsBitSet(range);

        for(int n=0; n<range; n++) {
            if(n % 10 == 0) {
                System.out.println();
            }
            System.out.print(n + ": " + numbers.get(n) + " ");
        }
        System.out.println();
    }

    // 5-2 소인수 분해하면 2*2+3*1+7*1 나오도록 소인수 분해한다. prime factorization
    public static void evaluatePrime(int number) {

        StringBuilder printString = new StringBuilder();

        BitSet numbers = sieveOfEratosthenes.getPrimeAsBitSet(number);

        System.out.print("Evaluate(" + number + "): ");

        for(int k=0; k<number; k++) {
            if(!numbers.get(k)) {
                continue;
            }
            if(number % k == 0) {
                printString.append(k + " * 1,");
            }
        }
        if(printString.toString().endsWith(",")) {
            System.out.println(printString.toString().substring(0,printString.length()-1));
        }
        else {
            System.out.println(printString.toString());
        }
    }

    // 5- 3 골드 바흐의 추측 Goldbach's conjecture
    public static void goldbach(int number) {

        StringBuilder printString = new StringBuilder();

        BitSet numbers = sieveOfEratosthenes.getPrimeAsBitSet(number);

        System.out.print(number + " = ");
        for(int k=0; k<number; k++) {
            if(!numbers.get(k)) {
                continue;
            }

            if(numbers.get(number - k)) {
                numbers.clear((number - k));
                printString.append(k + " + " + (number - k) + " = ");
            }
        }

        System.out.println(printString.toString().replaceAll("=\\s$",""));
    }
}
