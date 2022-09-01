import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<String> evaluation(String expression) {

        // 자른 형태소를 추가해 나가기 위한 리스트.
        ArrayList<String> tokens = new ArrayList<>();

        for(int i=0; i<expression.length();) {

            switch (expression.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    StringBuilder number = new StringBuilder();
                    number.append(expression.charAt(i));
                    i++;
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        number.append(expression.charAt(i));
                        i++;
                    }
                    tokens.add(number.toString());
                }
                break;

                case '+':
                case '*':
                case '/':
                case '(':
                case ')':
                    tokens.add(String.valueOf(expression.charAt(i)));
                    i++;
                    break;

                    // -는 연산자가 될 수도 있고 음수 기호도 될 수 있기에 판별하는 과정이 필요하다.
                case '-': {
                    if(tokens.size() == 0
                            || tokens.get(tokens.size() - 1).equals("+")
                            || tokens.get(tokens.size() - 1).equals("-")
                            || tokens.get(tokens.size() - 1).equals("*")
                            || tokens.get(tokens.size() - 1).equals("/")
                            || tokens.get(tokens.size() - 1).equals("(")
                    ) {
                        StringBuilder number = new StringBuilder();
                        number.append("-");
                        i++;
                        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                            number.append(expression.charAt(i));
                            i++;
                        }
                        tokens.add(number.toString());
                    }
                    else {
                        tokens.add("-");
                        i++;
                    }
                }
                break;

                case ' ':
                    i++;
                    break;

                default: {
                    throw new InvalidParameterException("Invalid expression");
                }
               }


            }

        return tokens;
    }
}
