/*
    재귀 호출
 */
public class Main_Recursive {
    public static void main(String[] args) {

        Main_Recursive ex = new Main_Recursive();

        int n = 10;

//        System.out.println("1~n까지 정수의 합: " + ex.recursiveSum(11000));
//        System.out.println("1~n까지 정수의 합: " + ex.whileSum(11000));
//        System.out.println("1~n까지 팩토리얼: " + ex.factorial(4));
        System.out.println("n번째 피보나치 수: " + ex.fibonacci(6));

    }

    // 정수의 합
    public int recursiveSum(int n) {

        if(n < 0) {
            return 0;
        }

        return n + recursiveSum(n-1);
    }

    public int whileSum(int n) {

        int sum = 0;

        while(n>0) {
            sum += n;
            n--;
        }

        return sum;
    }

    // 팩토리얼
    public int factorial(int n) {
        if(n <0) {
            return 0;
        }
        return n * recursiveSum(n-1);
    }

    // 피보나치 수열
    public int fibonacci(int n) {

        if(n<0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    // 하노이의 탑
    public void TowerOfHanoi() {

    }
}
