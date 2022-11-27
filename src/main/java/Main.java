import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int guests;
        while (true) {
            System.out.println("Введите количество человек на которых необходимо разделить счет:");
            try {
                guests = scanner.nextInt();
                if (guests < 1) {
                    System.out.println("Количество гостей не может быть меньше 1");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введено неверное значение");
                scanner.nextLine();
            }
        }
        if (guests==1) {
            System.out.println("Для одного гостя не требуется делить счет");
        } else {
            CheckCalculator calc = new CheckCalculator(guests, scanner);
            calc.startCalc();
        }
    }
}
