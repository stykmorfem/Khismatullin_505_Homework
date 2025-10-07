import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String oper = input.nextLine();
        int num1 = input.nextInt();
        int num2 = input.nextInt();


        switch (oper) {
            case "Сумма":
                System.out.println(name + " ваш результат: " + (num1 + num2));
                break;
            case "Вычитание":
                System.out.println(name + " ваш результат: " + (num1 - num2));
                break;
            case "Умножение":
                System.out.println(name + " ваш результат: " + (num1 * num2));
                break;
            case "Деление":
                if (num2 == 0) {
                    System.out.println("На ноль делить нельзя!");
                    break;
                }
                System.out.println(name + " ваш результат: " + (num1 / num2));
                break;
            default:
                System.out.println("Неправильно введен оператор");
        }
    }
}
