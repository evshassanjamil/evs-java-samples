package evs.labs.w301Assgnmt;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Class to execute/consume the system's functionality, owner can execute the functionality inside
 * {@link TestW301Assignment#main(String[])} function mentioned in the
 * <a href="https://drive.google.com/open?id=13uDnJkMPYw4H3h64Vz5N7T92SW8nTfje">assignment</a>
 */
public class TestW301Assignment {
    /**
     * List (Collection) of products and the program will manipulate its data of {@link Product}s
     */
    private static ArrayList<Product> listProducts = new ArrayList<>();

    /**
     * Function to test the functionality of the system in console
     */
    public static void main(String[] args) {
        // Assigning tag of store name
        Store.tag = "PCC";

        // Adding Products
        addProduct("Pepsico", "Lays", "1950", "Islamabad",
                "p101", "Lays Family Pack", "Snack", 20, "Spicy",
                "2019-11-01 18:02:30", "Hassan", "2021-01-01");

        addProduct("Pepsico", "Lays", "1950", "Islamabad",
                "p102", "Lays Family Pack", "Snacks", 31, "Spicy",
                "2019-11-18 18:02:30", "Hassan", "2021-02-01");

        addProduct("Coke", "Lays", "1950", "Islamabad",
                "p103", "Lays Family Pack", "Snack", 45, "Spicy",
                "2019-11-01 18:02:30", "Hassan", "2021-03-01");

        addProduct("Pepsico", "Lays", "1950", "Islamabad",
                "p104", "Lays Family Pack", "Snacks", 12, "Spicy",
                "2019-11-25 18:02:30", "Hassan", "2021-04-01");

        addProduct("Pepsico", "Lays", "1950", "Islamabad",
                "p105", "Lays Family Pack", "Snacks", 5, "Spicy",
                "2019-11-14 22:02:30", "Hassan", "2020-12-01");

        // Getting store tag for a product from list
        int index = 1;
        Product pr = listProducts.get(index);
        System.out.print("Store Tag: " + pr.getStoreTag());

        // Getting Company Name using Polymorphism for a product from list
        lineBreak();
        lineDivider();
        Company c = pr;
        System.out.print("Company Name: " + c.companyName);

        // Displaying Products entered in the list
        lineBreak();
        lineDivider();
        System.out.print("Products Entered: ");
        for (Product product : listProducts) {
            System.out.print(product.getId() + ", ");
        }

        // Getting and displaying list of Products for category and their count
        lineBreak();
        lineDivider();
        String category = "snacks";
        ArrayList<Product> listCatProducts = getListProductsForCategory(category);
        System.out.println("Products for category " + category + " count = " + listCatProducts.size());
        for (Product product : listCatProducts) {
            System.out.print(product.getId() + ", ");
        }

        lineDivider();
        lineDivider();
        Store.tag = "MMart";
        System.out.println("Store Tag " + listProducts.get(2).getStoreTag());
        lineDivider();
        lineDivider();

        // Getting and displaying list of Products for company name and their count
        lineBreak();
        lineDivider();
        String companyName = "coke";
        ArrayList<Product> listCompanyProducts = getListProductsForCompanyName(companyName);
        System.out.println("Products for company name " + companyName + " count = " + listCompanyProducts.size());
        for (Product product : listCompanyProducts) {
            System.out.print(product.getId() + ", ");
        }

        // Getting and displaying Products lesser than the price entered and their count
        lineBreak();
        lineDivider();
        int price = 25;
        ArrayList<Product> listProductsLessThanPrice = getListProductsLessThanPrice(price);
        System.out.println("Products for lesser price than " + price + " count = " + listProductsLessThanPrice.size());
        for (Product product : listProductsLessThanPrice) {
            System.out.print(product.getId() + ", ");
        }

        // Getting and displaying Products till added date and their count
        lineBreak();
        lineDivider();
        String tillAddedDate = "2019-11-15 00:00:00";
        ArrayList<Product> listProductsForAddedDate = getListProductsForAddedDate(tillAddedDate);
        System.out.println("Products Added till " + tillAddedDate + " count = " + listProductsForAddedDate.size());
        for (Product product : listProductsForAddedDate) {
            System.out.print(product.getId() + ", ");
        }

        // Getting and displaying Total Products Count
        lineBreak();
        lineDivider();
        System.out.print("Total Products count = " + listProducts.size());

        // Editing a product name against its product Id
        lineBreak();
        lineDivider();
        String proId = "p101";
        String name = "Wavy Small Pack";
        System.out.println("Editing Product Name (" + name + ") for id: " + proId);
        for (Product product : editProductName(proId, name)) {
            System.out.print(product.getId() + ":" + product.getName() + ", ");
        }

        // Deleting a product against its product Id, from list
        lineBreak();
        lineDivider();
        String pId = "p101";
        System.out.println("Deleting Product for id: " + pId);
        for (Product product : deleteProduct(pId)) {
            System.out.print(product.getId() + ":" + product.getName() + ", ");
        }

        // Getting and displaying Expired Products till date
        lineBreak();
        lineDivider();
        String tillExpiryDate = "2020-12-30";
        ArrayList<Product> listProductsExpired = getListProductsExpired(tillExpiryDate);
        System.out.println("Products Expired till " + tillExpiryDate + " count = " + listProductsExpired.size());
        for (Product product : listProductsExpired) {
            System.out.print(product.getId() + ", ");
        }

        // Getting and displaying added Products within date range from start to end date
        lineBreak();
        lineDivider();
        String from = "2019-11-15 00:00:00";
        String to = "2019-11-30 00:00:00";
        ArrayList<Product> listProductsForDateRange = getListProductsForDateRange(from, to);
        System.out.println("Products Added from " + from + " to " + to + " count = " + listProductsForDateRange.size());
        for (Product product : listProductsForDateRange) {
            System.out.print(product.getId() + ", ");
        }

        lineBreak();
        lineDivider();
    }

    /**
     * Function add products to an {@link ArrayList<Product>} (Collection)
     *
     * @param companyName company name e.g. Unilever, Bata
     * @param brandName   brand name e.g. Colgate, Power etc.
     * @param since       since e.g. 1990
     * @param location    location of the company mean address
     * @param id          product id, should be unique (as per your desire)
     * @param name        product name
     * @param category    product category e.g. cosmetics, commodities, bath etc.
     * @param price       integer product price in PKR
     * @param details     product additional details
     * @param addedDate   product added date in pattern "yyyy-MM-dd HH:mm:ss"
     * @param addedBy     product added by
     * @param expiryDate  date in pattern "yyyy-MM-dd"
     */
    private static void addProduct(String companyName, String brandName, String since, String location,
                                   String id, String name, String category, int price, String details,
                                   String addedDate, String addedBy, String expiryDate) {
        listProducts.add(new Product(companyName, brandName, since, location, id, name, category, price, details,
                addedDate, addedBy, expiryDate));
    }

    /**
     * Function to get sublist for category param.
     *
     * @param category case-insensitive category of product
     * @return Sublist ({@code ArrayList<Product>}) having the category
     */
    private static ArrayList<Product> getListProductsForCategory(String category) {
        return (ArrayList<Product>) listProducts.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase((category)))
                .collect(Collectors.toList());
    }

    /**
     * Function to get sublist for companyName param.
     *
     * @param companyName case-insensitive company name of product
     * @return Sublist ({@code ArrayList<Product>}) associated the company name
     */
    private static ArrayList<Product> getListProductsForCompanyName(String companyName) {
        return (ArrayList<Product>) listProducts.stream()
                .filter(p -> p.getCompanyName().equalsIgnoreCase((companyName)))
                .collect(Collectors.toList());
    }

    /**
     * Function to get sublist for price lesser than the price param.
     *
     * @param price case-insensitive integer price of product
     * @return Sublist ({@code ArrayList<Product>}) having lesser price than price param
     */
    private static ArrayList<Product> getListProductsLessThanPrice(int price) {
        return (ArrayList<Product>) listProducts.stream()
                .filter(p -> p.getPrice() < price)
                .collect(Collectors.toList());
    }

    /**
     * Function to get sublist of products before tillAddedDate param.
     *
     * @param tillAddedDate case-insensitive till date in pattern "yyyy-MM-dd HH:mm:ss" e.g. 2019-11-29 13:07:10
     * @return Sublist ({@code ArrayList<Product>}) for products added tillAddedDate param
     */
    private static ArrayList<Product> getListProductsForAddedDate(String tillAddedDate) {
        return (ArrayList<Product>) listProducts.stream()
                .filter(p -> DateTimeUtils.dateTimeBeforeStartDate(tillAddedDate, p.getAddedDate()))
                .collect(Collectors.toList());
    }

    /**
     * Function to get sublist of products expired for tillDate param.
     *
     * @param tillDate case-insensitive till date in pattern "yyyy-MM-dd HH:mm:ss" e.g. 2019-11-29 13:07:10
     * @return Sublist ({@link ArrayList<Product>}) of products expired for tillDate param
     */
    private static ArrayList<Product> getListProductsExpired(String tillDate) {
        return (ArrayList<Product>) listProducts.stream()
                .filter(p -> DateTimeUtils.dateBeforeStartDate(tillDate, p.getExpiryDate()))
                .collect(Collectors.toList());
    }

    /**
     * Function to get sublist of products added in date range, interval (start, end) mean start<date<end.
     *
     * @param start case-insensitive date in pattern "yyyy-MM-dd HH:mm:ss" e.g. 2019-01-29 00:00:00
     * @param end   case-insensitive date in pattern "yyyy-MM-dd HH:mm:ss" e.g. 2019-12-31 00:00:00
     * @return Sublist ({@link ArrayList<Product>}) of products whose added date lies in params interval/range
     */
    private static ArrayList<Product> getListProductsForDateRange(String start, String end) {
        return (ArrayList<Product>) listProducts.stream()
                .filter(p -> DateTimeUtils.dateTimeBetweenStartAndEndDates(start, p.getAddedDate(), end))
                .collect(Collectors.toList());
    }

    /**
     * Function to edit a product for its product name against id param.
     *
     * @param id   product id of the product which needs to be edited
     * @param name edited name of the product
     * @return Sublist ({@link ArrayList<Product>}) of all products(edit/non-edited) for their id and names
     */
    private static ArrayList<Product> editProductName(String id, String name) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId().equalsIgnoreCase(id)) {
                listProducts.get(i).setName(name);
            }
        }
        return listProducts;
    }

    /**
     * Function to delete a product against product id.
     *
     * @param id product id of the product which needs to be deleted
     * @return Sublist ({@link ArrayList<Product>}) of all products(remained) for their id and names
     */
    private static ArrayList<Product> deleteProduct(String id) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId().equalsIgnoreCase(id)) {
                listProducts.remove(i);
                return listProducts;
            }
            System.out.println(i);
        }
        return new ArrayList<>();
    }

    /*
     * UTILITY FUNCTIONS
     */

    /**
     * Function to place a line break.
     */
    private static void lineBreak() {
        System.out.print("\n");
    }

    /**
     * Function to place a line divider containing stream of character '-'.
     */
    private static void lineDivider() {
        System.out.println("--------------------------");
    }


}
