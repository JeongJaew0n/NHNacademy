import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer_AddType {
    public static List<Token> evaluation(String expression) {

        ArrayList<Token> tokens = new ArrayList<>();

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
                    tokens.add(new Token(TokenType.OPERAND,number.toString()));
                }
                break;

                case '+':
                case '*':
                case '/':
                case '(':
                case ')':
                    tokens.add(new Token(TokenType.OPERATOR,String.valueOf(expression.charAt(i))));
                    i++;
                    break;

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
                        tokens.add(new Token(TokenType.OPERAND,number.toString()));
                    }
                    else {
                        tokens.add(new Token(TokenType.OPERATOR,"-"));
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
