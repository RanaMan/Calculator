import java.io.IOException;

/**
 * Created by Rana on 10/18/2016.
 */
public class Main {

    public static void main (String[] args){
        System.out.println("Hey Rana");

        int firstNumber = 0;
        try {
            firstNumber = readNumber();

            int operator = readOperator();

            int secondNumber = readNumber();

            System.out.println("First Number ["+firstNumber+"]");
            System.out.println("Operator  ["+ (char)operator+"]");
            System.out.println("Second Number ["+secondNumber+"]");

            double result = 0;

            switch (operator){
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
                default:
                    System.out.println("Unknown Operator ["+(char)operator +"]");
                    break;

            }
            System.out.println("Result : " + result);
        } catch (IOException e) {
            System.out.println("I give up! " + e);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException);
        }


    }

    public static int readNumber() throws IOException{
        try{
            int c = System.in.read();
            return Character.getNumericValue(c);
        }catch(IOException exception){
            System.out.println("We tried to read a number but this exception occurred ["+exception+"]");
        }

        return 0;
    }

    public static int readOperator() throws IOException{
        int c = System.in.read();

        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
                break;
            default:
                throw new RuntimeException("Unknown Operator : " + (char)c );4$

        }
        return c;
    }
}
