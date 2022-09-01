public class MyRationalNumberTest {
    static public void main(String [] args) {
        MyRationalNumber rn1 = new MyRationalNumber(2,6);
        MyRationalNumber rn2 = new MyRationalNumber(6);

        System.out.println("rn1 : " + rn1);
        System.out.println("rn2 : " + rn2);
        System.out.println(rn1 + " + " + rn2 + " = " + rn1.plus(rn2));
        System.out.println(rn1 + " - " + rn2 + " = " + rn1.minus(rn2));
        System.out.println(rn1 + " * " + rn2 + " = " + rn1.multipliedBy(rn2));
        System.out.println(rn1 + " / " + rn2 + " = " + rn1.dividedBy(rn2));
        System.out.println("Create rational number from string : " + MyRationalNumber.create("1/2"));
    }
}
