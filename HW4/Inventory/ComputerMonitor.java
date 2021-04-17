import java.util.Date;

/**
 * Subclass of Screen and Superclass of LED & CRT.
 */
public abstract class ComputerMonitor extends Screen {
    /**
     *
     * @param id ID sequence of product.
     * @param price Price in US Dollars of product.
     * @param makeDate The date the product was manufactured.
     * @param manufacturer The manufacturer of the product.
     * @param model The model number of the product.
     */
    public ComputerMonitor(long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
    }

    @Override
    /**
     *
     * Returns string that contains the type of the object.
     */
    public String toString() {
        return String.format("ComputerMonitor (2)");
    }

    @Override
    /**
     *
     * @param o An object of class Screen.
     * @return <b>true</b> if the two objects have the same <i>id.</i>
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if ((o != null) && (o instanceof ComputerMonitor)){
            ComputerMonitor cm = (ComputerMonitor) o;
            return (getId() == cm.getId());
        }

        return false;




    }


}
