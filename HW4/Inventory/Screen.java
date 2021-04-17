import java.util.Date;

/**
 * Direct superclass of SmartTV & ComputerMonitor and indirect superclass of LED & CRT.
 */
public abstract class Screen {

    private long id;
    private double price;
    private Date makeDate;
    private String manufacturer;
    private String model;

    /**
     *
     * @param id ID sequence of product.
     * @param price Price in US Dollars of product.
     * @param makeDate The date the product was manufactured.
     * @param manufacturer The manufacturer of the product.
     * @param model The model number of the product.
     */
    public Screen( long id, double price, Date makeDate, String manufacturer, String model){
        this.id = id;
        this.price = price;
        this.makeDate = makeDate;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    //Getters

    /**
     *
     * @return Returns the contents of id.
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return Returns the contents of price.
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return Returns the contents of makeDate.
     */
    public Date getMakeDate() {
        return makeDate;
    }

    /**
     *
     * @return Returns the contents of manufacturer.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *
     * @return Returns the contents of model.
     */
    public String getModel() {
        return model;
    }

    //Setters
    /**
     *
     * @param id Replaces the contents of id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @param price Replaces the contents of price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param makeDate Replaces the contents of makeDate.
     */
    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    /**
     *
     * @param manufacturer Replaces the contents of manufacturer.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     *
     * @param model Replaces the contents of model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * Returns string that contains the type of the object.
     */
    @Override
    public String toString() {
        return String.format("Screen (1)");
    }

    /**
     * To be used by subclasses, to make sure they all create their own concrete implementations.
     * @param o An object of class Screen.
     * @return
     */
    @Override
    public abstract boolean equals(Object o);

}