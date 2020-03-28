package evs.labs.w301Assgnmt;

/**
 * Class to represent a product extends with an abstract class {@link Company}
 */
class Product extends Company {

    private String id;
    private String name;
    private String category;
    private int price;
    private String details;
    private String addedDate;
    private String addedBy;
    private String expiryDate;

    /**
     * Default Constructor of {@link Product} class
     */
    Product() {
    }

    /**
     * Parametric Constructor of {@link Product} class
     *
     * @param id         product id
     * @param name       product name
     * @param category   e.g. cosmetics, commodities, bath etc.
     * @param price      in PKR (numbers)
     * @param details    additional details
     * @param addedDate  date in pattern "yyyy-MM-dd HH:mm:ss"
     * @param addedBy    added by e.g. user1234
     * @param expiryDate date in pattern "yyyy-MM-dd"
     */
    Product(String id, String name, String category, int price, String details, String addedDate, String addedBy,
            String expiryDate) {
        setProductMembers(id, name, category, price, details, addedDate, addedBy, expiryDate);
    }

    /**
     * Parametric Constructor of {@link Product} class to set data members of {@link Company} and {@link Product}
     * classes
     *
     * @param companyName company name e.g. Unilever
     * @param brandName   brand name e.g. Colgate, Power, NDURE  etc.
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
    Product(String companyName, String brandName, String since, String location,
            String id, String name, String category, int price, String details,
            String addedDate, String addedBy, String expiryDate) {
        setCompanyName(companyName);
        setBrandName(brandName);
        setSince(since);
        setLocation(location);
        setProductMembers(id, name, category, price, details, addedDate, addedBy, expiryDate);
    }

    /**
     * Method to set data members of {@link Product} class
     *
     * @param id         product id
     * @param name       product name
     * @param category   e.g. cosmetics, commodities, bath etc.
     * @param price      in PKR (numbers)
     * @param details    additional details
     * @param addedDate  date in pattern "yyyy-MM-dd HH:mm:ss"
     * @param addedBy    added by e.g. user1234
     * @param expiryDate date in pattern "yyyy-MM-dd"
     */
    private void setProductMembers(String id, String name, String category, int price, String details,
                                   String addedDate, String addedBy, String expiryDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.details = details;
        this.addedDate = addedDate;
        this.addedBy = addedBy;
        this.expiryDate = expiryDate;
    }

    /*
    SETTER AND GETTER METHODS
     */
    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getCategory() {
        return category;
    }

    void setCategory(String category) {
        this.category = category;
    }

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    String getDetails() {
        return details;
    }

    void setDetails(String details) {
        this.details = details;
    }

    String getAddedDate() {
        return addedDate;
    }

    void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    String getAddedBy() {
        return addedBy;
    }

    void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    String getExpiryDate() {
        return expiryDate;
    }

    void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    void setCompanyName(String name) {
        super.companyName = name;
    }

    String getCompanyName() {
        return super.companyName;
    }

    @Override
    void setBrandName(String name) {
        super.brandName = name;
    }

    String getBrandName() {
        return super.brandName;
    }

    @Override
    void setSince(String value) {
        super.since = value;
    }

    String getSince() {
        return super.since;
    }

    @Override
    void setLocation(String location) {
        super.location = location;
    }

    String getLocation() {
        return super.location;
    }

    /**
     * Get store tag stored in {@link Store#tag}
     *
     * @return {@link String} tag
     */
    String getStoreTag() {
        return Store.tag;
    }
}
