public class MyIntegerTest {
    static public void main(String [] args) {
        MyInteger int1 = new MyInteger(2);
        MyInteger int2 = new MyInteger(3);
        MyInteger int3 = null;
        MyRationalNumber rn1 = new MyRationalNumber(3, 9);

        System.out.println("int1 : " + int1);
        System.out.println("int2 : " + int2);
        System.out.println(int1 + " + " + int2 + " = " + int1.plus(int2));
        System.out.println(int1 + " - " + int2 + " = " + int1.minus(int2));
        System.out.println(int1 + " * " + int2 + " = " + int1.multipliedBy(int2));
        System.out.println(int1 + " / " + int2 + " = " + int1.dividedBy(int2));
        System.out.println(int1 + " + " + rn1 + " = " + int1.plus(rn1));
        System.out.println(int1 + " - " + rn1 + " = " + int1.minus(rn1));
        System.out.println(int1 + " * " + rn1 + " = " + int1.multipliedBy(rn1));
        System.out.println(int1 + " / " + rn1 + " = " + int1.dividedBy(rn1));
    }
}
