import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();

        System.out.println("Output:\n" + calc(input));


    }

    public static String calc(String input) {
        String[] data = input.split(" ");

        if (data.length != 3) {
            throw new IllegalArgumentException("Недопустимое количество переменных");
        }

        int a = parseNumber(data[0]);
        int b = parseNumber(data[2]);
        int result = 0;

        switch (data[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Недопустимое значение");
        }

        return Integer.toString(result);
    }

    private static int parseNumber(String data) {
        int number = 0;

        try {
            number = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа");
        }

        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Число должно быть от 1 до 10 включительно");
        }

        return number;
    }
}