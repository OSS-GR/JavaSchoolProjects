import java.util.Date;

/**
 * Subclass of Screen. Included additional input <i>operatingSystem</i>.
 */
public class SmartTV extends Screen {

    private String operatingSystem;

    /**
     *
     * @param operatingSystem The name of the Operating System on the product.
     * @param id ID sequence of product.
     * @param price Price in US Dollars of product.
     * @param makeDate The date the product was manufactured.
     * @param manufacturer The manufacturer of the product.
     * @param model The model number of the product.
     */
    public SmartTV(String operatingSystem, long id, double price, Date makeDate, String manufacturer, String model) {

        super(id,price,makeDate,manufacturer, model);
        this.operatingSystem = operatingSystem;
    }

    //Setters

    /**
     *
     * @param operatingSystem Replaces the contents of operatingSystem.
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    //Getters

    /**
     *
     * @return Returns the contents of operatingSystem.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    /**
     * Returns string that contains the type of the object.
     */
    public String toString() {
        return String.format("SmartTV (2)");
    }

    @Override
    /**
     *
     * @param o An object of class Screen.
     * @return <b>true</b> if the two objects have the same <i>id, price and model.</i>
     */
    public boolean equals(Object o) {

        if (o == this)
            return true;

        if ((o != null) && (o instanceof SmartTV)){
            SmartTV s = (SmartTV) o;
            return (s.getPrice() == getPrice()) && (s.getId() == getId()) && (getModel().equals(s.getModel()));
        }

        return false;

    }


}