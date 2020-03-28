package evs.labs.w401Assgnmt;

/**
 * Class to represent a product extends with an abstract class {@link Company}
 */
class Product extends Company {

    private int pid, price;
    private String pName, category, details, addedDate, addedBy, expiryDate;

    /**
     * Default Constructor of {@link Product} class
     */
    Product() {
    }

    /**
     * Parametric Constructor of {@link Product} class to set data members of {@link Company} and {@link Product}
     * classes
     *
     * @param cid         int company id, should be unique
     * @param companyName company name e.g. Unilever
     * @param brandName   brand name e.g. Colgate, Power, NDURE  etc.
     * @param since       since e.g. 1990
     * @param location    location of the company mean address
     * @param pid          int product id, should be unique
     * @param pName        product name
     * @param category    product category e.g. cosmetics, commodities, bath etc.
     * @param price       integer product price in PKR
     * @param details     product additional details
     * @param addedDate   product added date in pattern "yyyy-MM-dd HH:mm:ss"
     * @param addedBy     product added by
     * @param expiryDate  date in pattern "yyyy-MM-dd"
     */
    Product(int cid, String companyName, String brandName, String since, String location,
            int pid, String pName, String category, int price, String details,
            String addedDate, String addedBy, String expiryDate) {
        setCompany(cid, companyName, brandName, since, location);
        setProductMembers(pid, pName, category, price, details, addedDate, addedBy, expiryDate);
    }

    /**
     * Parametric Constructor of {@link Product} class to set data members of {@link Company} and {@link Product}
     * classes
     *
     * @param cid         int company id, should be unique
     * @param pid          int product id, should be unique
     * @param pName        product name
     * @param category    product category e.g. cosmetics, commodities, bath etc.
     * @param price       integer product price in PKR
     * @param details     product additional details
     * @param addedDate   product added date in pattern "yyyy-MM-dd HH:mm:ss"
     * @param addedBy     product added by
     * @param expiryDate  date in pattern "yyyy-MM-dd"
     */
    Product(int cid, int pid, String pName, String category, int price, String details,
            String addedDate, String addedBy, String expiryDate) {
        setCompanyId(cid);
        setProductMembers(pid, pName, category, price, details, addedDate, addedBy, expiryDate);
    }

    Product(int pid, String pName) {
        setProductId(pid);
        setProductName(pName);
    }

    /**
     * Method to set data members of {@link Product} class
     *
     * @param pid         product id
     * @param name       product name
     * @param category   e.g. cosmetics, commodities, bath etc.
     * @param price      in PKR (numbers)
     * @param details    additional details
     * @param addedDate  date in pattern "yyyy-MM-dd HH:mm:ss"
     * @param addedBy    added by e.g. user1234
     * @param expiryDate date in pattern "yyyy-MM-dd"
     */
    private void setProductMembers(int pid, String name, String category, int price, String details,
                                   String addedDate, String addedBy, String expiryDate) {
        this.pid = pid;
        this.pName = name;
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
    int getProductId() {
        return pid;
    }

    void setProductId(int pid) {
        this.pid = pid;
    }

    String getProductName() {
        return pName;
    }

    void setProductName(String pName) {
        this.pName = pName;
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
    void setCompany(int cid, String cName, String bName, String since, String location) {
        super.cid = cid;
        super.companyName = cName;
        super.brandName = bName;
        super.since = since;
        super.location = location;
    }

    Company getCompany() {
        Company company = this;
        return company;
    }

    @Override
    void setCompanyId(int cid) {
        super.cid = cid;
    }

    int getCompanyId() {
        return super.cid;
    }

    String getCompanyName() {
        return super.companyName;
    }

    String getBrandName() {
        return super.brandName;
    }

    String getSince() {
        return super.since;
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
