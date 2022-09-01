public class MyRationalNumber extends MyNumber{
    double number; // 만들어진 숫자
    double numerator; // 분자
    double denominator; // 분모

    // 자연수, 정수, 유리수를 받아 생성할 수 있습니다.
    MyRationalNumber(double _number) {
        this.number = _number;

        // 분수로 나타낼 수 있는 경우
        if(IsUnderNumber(number)) {
            String[] split_number = String.valueOf(number).split("[.]");
            numerator = number * Math.pow(10 , split_number[1].length());
            denominator = Math.pow(10 , split_number[1].length());

            CalReducedFraction();
        }
    }

    // 분자/분모를 받아 생성할 수 있습니다.
    MyRationalNumber(String _fountain) {
        String[] split_fountain = _fountain.split("/");

        this.numerator = Double.valueOf(split_fountain[0]);
        this.denominator = Double.valueOf(split_fountain[1]);

        // 분모가 0일 경우 예외 처리.
        if(this.denominator == 0) {
            throw new ArithmeticException();
        }

        if(IsUnderNumber(numerator) || IsUnderNumber(denominator)) {
            String[] split_numerator = String.valueOf(numerator).split("[.]");
            String[] split_denominator = String.valueOf(denominator).split("[.]");
            int square = split_numerator[1].length() > split_denominator[1].length() ? split_numerator[1].length() :split_denominator[1].length();
        }

        CalReducedFraction();

        number = numerator/denominator;
    }

    @Override
    public MyNumber plus(MyNumber operand) throws NumberException {
//        System.out.println(((MyRationalNumber)operand).number);
        return new MyRationalNumber(this.number + ((MyRationalNumber)operand).number);
    }

    @Override
    public MyNumber minus(MyNumber operand) throws NumberException {
        return new MyRationalNumber(this.number - ((MyRationalNumber)operand).number);
    }

    @Override
    public MyNumber multipliedBy(MyNumber operand) throws NumberException {
        return new MyRationalNumber(this.number * ((MyRationalNumber)operand).number);
    }

    @Override
    public MyNumber dividedBy(MyNumber operand) throws NumberException {
        return new MyRationalNumber(this.number / ((MyRationalNumber)operand).number);
    }

    public void CheckCalPossible(MyNumber operand) throws NumberException {
        if(operand instanceof MyNaturalNumber) {
            throw new NumberException("유리수와 자연수의 연산은 지원하지 않습니다.");
        }
    }

    @Override
    public String toString() {
        if(IsUnderNumber(number)) {
            CalReducedFraction();
            return numerator + "/" + denominator;
        }
        return String.valueOf(this.number);
    }

    // 소숫점 아래 숫자가 있는지 확인 하는 함수.
    private boolean IsUnderNumber(double number) {
        if((int)number != number) return true;
        return false;
    }

    // 기약 분수 계산 함수.
    public void CalReducedFraction() {

        if(!IsUnderNumber(number)) return;

        int max_number = 0;

        // 최대 공약수를 찾는다.
        for(double i= denominator; i>1; i--) {
            if(denominator%i == 0 && numerator%i == 0) {
                max_number = (int)i;
            }
        }

        if(max_number != 0) {
            this.numerator = numerator/max_number;
            this.denominator = denominator/max_number;
        }
    }
}
