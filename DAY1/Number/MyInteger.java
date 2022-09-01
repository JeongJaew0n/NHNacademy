// 정수는 유리수에 포함됩니다.
public class MyInteger extends MyRationalNumber{

    int number;

    // 생성자의 매개변수를 부모인 유리수와 다른 integer 로 하고 분수를 받는 생성자는 만들지 않음.
    // 자연수, 정수를 받아 생성할 수 있습니다.
    MyInteger(int _number) {
        super(_number);
    }   // 잘 저장되는지 테스트 해보기.

}
