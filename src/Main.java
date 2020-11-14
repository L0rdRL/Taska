import java.util.Scanner;

public class Main {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Parser parser = new Parser();
        String[] values;

        Number firstNum;
        Number secondNum;

        System.out.println("Введите строку, которую нужно посчитать:");

        while (true) {
            String inputStr = scanner.nextLine();  // Read user input
            values = parser.split(inputStr);
            if (values == null) {
                System.out.println("СТРОКА НЕ ВАЛИДНА");
                continue;
            }
            String firstValue = values[0];
            String secondValue = values[1];

            if (parser.parseValue(firstValue) != Consts.VALUE_FORMAT_ERROR) {
                firstNum = new ArabicNumber();
                secondNum = new ArabicNumber();
            } else {
                firstNum = new RomanNumber();
                secondNum = new RomanNumber();
            }
            if (firstNum.setValue(firstValue) == Consts.VALUE_FORMAT_ERROR) {
                System.out.println("СТРОКА НЕ ВАЛИДНА");
                continue;
            }
            if (secondNum.setValue(secondValue) == Consts.VALUE_FORMAT_ERROR) {
                System.out.println("СТРОКА НЕ ВАЛИДНА");
                continue;
            }

            System.out.println("Результат: " + firstNum.calc(secondNum, parser.getOperation()));
            break;
        }
    }
}