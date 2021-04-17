import java.util.Date;

/**
 * Subclass of ComputerMonitor.
 */
public class CRT extends ComputerMonitor {

    private double glassThickness;

    /**
     *
     * @param glassThickness The thickness of the glass of the CRT instance.
     * @param id ID sequence of product.
     * @param price Price in US Dollars of product.
     * @param makeDate The date the product was manufactured.
     * @param manufacturer The manufacturer of the product.
     * @param model The model number of the product.
     */
    public CRT(double glassThickness, long id, double price, Date makeDate, String manufacturer, String model) {
        super(id, price, makeDate, manufacturer, model);
        this.glassThickness = glassThickness;
    }

    /**
     *
     * @return Returns the contents of <i>glassThickness.</i>
     */
    public double getGlassThickness() {
        return glassThickness;
    }

    /**
     *
     * @param glassThickness Replaces the contents of <i>glassThickness.</i>
     */
    public void setGlassThickness(double glassThickness) {
        this.glassThickness = glassThickness;
    }

    @Override
    /**
     *
     * Returns string that contains the type of the object.
     */
    public String toString() {
        return String.format("CRT (3)");
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

        if ((o != null) && (o instanceof CRT)){
            CRT c = (CRT) o;
            return ( getId() == c.getId() ) && ( getModel().equals(c.getModel()) );
        }

        return false;

    }


}