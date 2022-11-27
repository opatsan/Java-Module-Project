import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

//калькулятор чека
public class CheckCalculator {

        int guests; //количество гостей
        ArrayList<CheckItem> items = new ArrayList<CheckItem>(); //список товаров
        Scanner scanner; //сканер
        double totalSum = 0.0; //итоговая сумма по чеку

        //конструктор принимает на вход количество гостей и сканер
        CheckCalculator(int guests, Scanner scanner) {
            this.guests = guests;
            if (scanner==null) {
                this.scanner = new Scanner(System.in);
            } else {
                this.scanner = scanner;
            }
        }

        //конструктор без сканера
        CheckCalculator(int guests) {
            this(guests, null);
        }

        //Печать ИТОГО по чеку
        public void printTotal(){
            System.out.println(String.format("ИТОГО по чеку: %s", Double2Rubles.print(totalSum)));
        }

        //Печать чека
        public void printAll(){
            if (items.size() == 0) {
                System.out.println("Чек пустой, делить нечего");
            } else{
                System.out.println("Добавленные товары:");
                for (CheckItem ci : items) {
                    ci.printItem();
                }
                printTotal();

                //округляем свеху ceil, чтобы сумма с каждого получилась не меньше итоговой суммы
                System.out.println(String.format("На каждого из %d человек по %s",guests, Double2Rubles.print(Math.ceil(totalSum*100/guests)/100)));
            }
        }

        //Добавление товара в чек
        public void addItem(String itemName, double itemCost) {
            items.add(new CheckItem(itemName, itemCost)); //создаем новый объект товара и добавляем в список
            totalSum += itemCost; //обновляет итого по чеку
            System.out.println(String.format("В чек добавлен товар \"%s\" cтоимостью %s", itemName, Double2Rubles.print(itemCost))); //сообщение о добавлении товара в чек
            printTotal(); //выводим обновленное итого по чеку
        }

        public void startCalc() {
            //addItem("Колбаса", 5.01);
            //addItem("Хлеб", 1.11);
            String itemName;
            double itemCost;
            scanner.useLocale(Locale.ENGLISH);//чтобы был разделитель "."
            while (true) {
                System.out.println("Введите наименование товара или \"Завершить\" для окончания ввода:");
                itemName = scanner.next();
                if (itemName.equalsIgnoreCase("Завершить")) {
                    break;
                } else {
                    while (true) {
                        try {
                            System.out.println("Введите стоимость товара в формате рубли.копейки:");
                            itemCost = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Введено неверное значение");
                            scanner.nextLine();
                        }
                    }
                    addItem(itemName, itemCost);
                }
            }
            printAll();
        }

}
