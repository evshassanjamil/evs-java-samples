package evs.labs.w301Assgnmt;

/**
 * Abstract class implemented just to implement its limited function with {@link Product} class
 * Because each product contains company details (e.g. companyName, brandName, since, location)
 */
abstract class Company {
    String companyName, brandName, since, location;

    abstract void setCompanyName(String name);

    abstract void setBrandName(String name);

    abstract void setSince(String value);

    abstract void setLocation(String location);
}
