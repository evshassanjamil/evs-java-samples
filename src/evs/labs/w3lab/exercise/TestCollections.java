package evs.labs.w3lab.exercise;

import java.util.ArrayList;
import java.util.Iterator;

public class TestCollections {

    public static void main(String[] args) {
        ArrayList<Product> listProduct = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Lays");
        product1.setPrice(50);
        listProduct.add(product1);
        Product product2 = new Product(2, "Lays", 10);
        listProduct.add(product2);
        Product product3 = new Product(3, "Lays", 5);
        listProduct.add(product3);
        Product product4 = new Product(4, "Lays", 30);
        listProduct.add(product4);
        Product product5 = new Product(5, "Lays", 70);
        listProduct.add(product5);


        Iterator iterator = listProduct.iterator();
        while(iterator.hasNext()) {
            System.out.println(((Product)iterator.next()).getId());
        }
    }
}
