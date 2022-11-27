public class Double2Rubles {

    //преобразует число в строки формата "число рублей", где рублей склоняется в зависимости от остатка
    public static String print(double d) {
        String rubs = "рублей";
        int last10 = (int) (Math.floor(d)) % 100; //остаток от деления на 100
        int last1 = last10 % 10; //остаток от деления на 10

        if (!((last10>=11) && (last10<=20))) { //от 11 до 20 не проверять последнюю цифру - всегда рублей
            if (last1==1) {
                rubs = "рубль";
            } else if (last1 >=2 && last1 <= 4) {
                rubs = "рубля";
            }
        }

        return String.format("%.2f %s",d,rubs);
    }
}
