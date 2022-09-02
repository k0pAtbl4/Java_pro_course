package lesson15;

public class Main {
    public static void main(String[] args) {
        InfixToPostfixTranslator temp = new InfixToPostfixTranslator();
        System.out.println(temp.InfixToPostfix("1 + 2 * 3"));
        System.out.println(temp.calculator(temp.InfixToPostfix("1 + 2 * 3")));
    }
}
