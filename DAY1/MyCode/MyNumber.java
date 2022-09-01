public abstract class MyNumber {
    /* 유리수
    *  자연수 받아 생성 가능
    *  정수 받아 생성 가능
    *  유리수 받아 생성 가능
    *  분자/분모 받아 생성 가능
    *  숫자에 포함된다.
    * */
    /* 정수
    *  자연수, 정수 받아 생성 가능
    *  유리수에 포함된다.
    * */
    /* 자연수
    *  정수에 포함딘다.
    * */
    /* 4칙 연산 가능
    유리수 = 유리수.연산자(유리수)
    정수 = 정수.연산자(정수)
    자연수 = 자연수.연산자(자연수)
    유리수 = 자연수.연산자는(유리수) 지원하지 않음.
    * */

    /* 타입 조건에 위배될 경우 오류를 발생
    분수는 정수가 될 수 없다.
    0, 음의 정수는 자연수가 될 수 없다.
    *  */

    /* 각 숫자는 가장 단순한 형태로 출력된다.
    * 정슈 표현이 가능하면 정수로 표현
    * 분수는 기약 분수로 표시
    * */

    public abstract MyNumber plus(MyNumber operand) throws NumberException;
    public abstract MyNumber minus(MyNumber operand) throws NumberException;
    public abstract MyNumber multipliedBy(MyNumber operand) throws NumberException;
    public abstract MyNumber dividedBy(MyNumber operand) throws NumberException;
}
