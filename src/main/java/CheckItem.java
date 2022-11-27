
public class CheckItem {
    String itemName; //наименование товара
    double itemCost; //стоимость товара

    CheckItem(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    //вывод на печать
    public void printItem() {
        System.out.println(String.format("%s х %s" ,itemName,Double2Rubles.print(itemCost)));
    }

}
