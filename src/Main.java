import java.io.IOException;

/**
 * Created by Rana on 10/18/2016.
 */
public class Main {

    public static final int MAX_DIGITS=9;

    public static void main (String[] args){
        System.out.println("Hey Rana");

        try {
            while(true) {
                readEquation();
            }
        } catch (IOException e) {
            System.out.println("I give up! " + e);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException);
        }


    }

    public static void readEquation() throws IOException {
        int firstNumber = readNumber();

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
    }

    public static int readNumber() throws IOException{
        int c=0;
        String characters= "";

        int count;
        for (count =0;count<MAX_DIGITS;count++){
            c=System.in.read();
            if(c=='\n'){
                break;
            }
            characters +="" +(char)c;
        }
        if (c!='\n'){
            throw new RuntimeException("Too many digits: " + characters);
        }

        return Integer.parseInt(characters);
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
                throw new RuntimeException("Unknown Operator : " + (char)c );

        }

        //Remember, you need to get the next character which is the \n before you can go to the next step...
        int separator = System.in.read();
        if (separator != '\n'){
            throw new RuntimeException("Unknown Operator : " + (char)c );
        }
        return c;
    }
}
