package bestbuy.app;

import bestbuy.model.BestBuyLinkedList;

public class App {
    public static void main(String[] args) {
        BestBuyLinkedList bestBuyLinkedList = new BestBuyLinkedList();
        bestBuyLinkedList.insert(1);
        bestBuyLinkedList.insert(2);
        bestBuyLinkedList.insert("Hello");
        System.out.println(bestBuyLinkedList);
        bestBuyLinkedList.show();

    }
}