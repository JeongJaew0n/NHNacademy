public class Main_number {
    public static void main(String[] args) throws NumberException {
        MyRationalNumber n1 = new MyRationalNumber(33.3/9);
        MyRationalNumber n2 = new MyRationalNumber(1);

        MyInteger ni1 = new MyInteger(3);
        MyInteger ni2 = new MyInteger(-4);

        MyNaturalNumber nn1 = new MyNaturalNumber(12);
        MyNaturalNumber nn2 = new MyNaturalNumber(33);

        System.out.println(n1.plus(n2));

    }
}
/*
분자 분모만으로 숫자 표현가능.
IllegalArgumentException 사용.
무리수 검사.
@NotNull
최대공약수(gcd) 재귀호출 구현
생성자 매개변수가 MyInteger 구현.
나누기 0 에러.
사칙연산 메소드에서 instance of 로 타입 체크.

 * 형변환 vs super
 - 형변환은 컴파일러에게 알려주기만, super 는 실제 타입 호출.
 */