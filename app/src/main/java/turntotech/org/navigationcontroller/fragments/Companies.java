package turntotech.org.navigationcontroller.fragments;

/**
 * Created by adityanarayan on 7/25/16.
 */
public class Companies {
    public String companyName;
    public String companyStockPrice;
    public int imageId;

    public Companies (int imageId, String companyName, String companyStockPrice){
        this.companyName = companyName;
        this.companyStockPrice = companyStockPrice;
        this.imageId = imageId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyStockPrice() {
        return companyStockPrice;
    }

    public void setCompanyStockPrice(String companyStockPrice) {
        this.companyStockPrice = companyStockPrice;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
