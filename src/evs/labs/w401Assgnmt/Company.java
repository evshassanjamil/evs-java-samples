package evs.labs.w401Assgnmt;

/**
 * Abstract class implemented just to implement its limited function with {@link Product} class
 * Because each product contains company details (e.g. companyName, brandName, since, location)
 */
abstract class Company {
    int cid;
    String companyName, brandName, since, location;

    abstract void setCompanyId(int cid);
    abstract void setCompany(int id, String cName, String bName, String since, String location);
}
