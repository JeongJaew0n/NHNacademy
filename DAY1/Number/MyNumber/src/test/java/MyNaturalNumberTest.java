public class MyNaturalNumberTest {
    static public void main(String [] args) {
        MyNaturalNumber nn1 = new MyNaturalNumber(3);
        MyNaturalNumber nn2 = new MyNaturalNumber(2);
        MyInteger int1 = new MyInteger(-1);
        MyRationalNumber rn1 = new MyRationalNumber(3, 9);

        System.out.println("nn1 : " + nn1);
        System.out.println("nn2 : " + nn2);
        System.out.println(nn1 + " + " + nn2 + " = " + nn1.plus(nn2));
        System.out.println(nn1 + " - " + nn2 + " = " + nn1.minus(nn2));
        System.out.println(nn1 + " * " + nn2 + " = " + nn1.multipliedBy(nn2));
        System.out.println(nn1 + " / " + nn2 + " = " + nn1.dividedBy(nn2));
        System.out.println(nn1 + " + " + int1 + " = " + nn1.plus(int1));
        System.out.println(nn1 + " - " + int1 + " = " + nn1.minus(int1));
        System.out.println(nn1 + " * " + int1 + " = " + nn1.multipliedBy(int1));
        System.out.println(nn1 + " / " + int1 + " = " + nn1.dividedBy(int1));
        System.out.println(nn1 + " + " + rn1 + " = " + nn1.plus(rn1));
        System.out.println(nn1 + " - " + rn1 + " = " + nn1.minus(rn1));
        System.out.println(nn1 + " * " + rn1 + " = " + nn1.multipliedBy(rn1));
        System.out.println(nn1 + " / " + rn1 + " = " + nn1.dividedBy(rn1));
    }
}
