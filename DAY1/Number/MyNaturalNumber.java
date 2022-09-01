// 자연수는 정수에 포함됩니다.
public class MyNaturalNumber extends  MyInteger{

    int number;
    MyRationalNumber forCompare = new MyRationalNumber(0);
    MyNaturalNumber(int _number) throws NumberException {
        super(_number);
        this.number = _number;
        if(number <= 0) {
            throw new NumberException("0, 음의 정수는 자연수가 될 수 없습니다!");
        }
    }

    @Override
    public MyNumber plus(MyNumber operand) throws NumberException {
        canCalPossible(operand);
        return super.plus(operand);
    }

    @Override
    public MyNumber minus(MyNumber operand) throws NumberException {
        canCalPossible(operand);
        return super.minus(operand);
    }

    @Override
    public MyNumber multipliedBy(MyNumber operand) throws NumberException {
        canCalPossible(operand);
        return super.multipliedBy(operand);
    }

    @Override
    public MyNumber dividedBy(MyNumber operand) throws NumberException {
        canCalPossible(operand);
        return super.dividedBy(operand);
    }

    private void canCalPossible(MyNumber operand) throws NumberException {
        if(operand.getClass().isInstance(forCompare)) {
            throw new NumberException("자연수와 유리수 연산은 지원되지 않습니다.");
        }
    }

}
