import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Creates list that contains all unique(Non-Duplicate) items found in inventory.
 * Displays content of list.
 */
public class Inventory {

    private final ArrayList<Screen> listInventory = new ArrayList<>();                 // Array containing unique instances of Screen that exist in the inventory.
    private final SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");    // Simplified format in which to display the date in "printInventory" method.

    /**
     * @return The number of Screens in the inventory.
     */
    public int inventoryCount() {
        return listInventory.size();
    }

    /**
     * Checks if familiar instances exist already in <i>listInventory<i/>. If they exist, it throws an exception of type
     * <i>Exception</i> and message "<i>The inventory contains a similar Screen object<i/>". If they do not, it adds the
     * object in the list and returns true.
     * @param screen An object of class <i>Screen</i>.
     * @return True if new object added. False otherwise.
     * @throws Exception If familiar instance already exists in <i>listInventory</i>.
     */
    public boolean addToInventory(Screen screen) throws Exception {
        if (listInventory.contains(screen))
            throw new Exception("The inventory contains a similar Screen object");
        listInventory.add(screen);
        return true;
    }

    /**
     * @return A new list containing instances of supertype ComputerMonitor.
     */
    public ArrayList<ComputerMonitor> listComputerMonitor() {

        ArrayList<ComputerMonitor> tmp = new ArrayList<>();
        for (Screen monitor : listInventory  ) {
            if (monitor instanceof ComputerMonitor) {
                ComputerMonitor mon = (ComputerMonitor) monitor;
                tmp.add(mon);
            }
        }
        return tmp;
    }

    /**
     * @return A new list containing instances of supertype SmartTV.
     */
    public ArrayList<SmartTV> listSmartTV() {

            ArrayList<SmartTV> tmp = new ArrayList<>();
            for (Screen television : listInventory  ) {
                if (television instanceof SmartTV) {
                    SmartTV tv = (SmartTV) television;
                    tmp.add(tv);
                }
            }
            return tmp;
    }

    /**
     * Prints the header with the description of the categories displayed.
     */
    public void inventoryHeader(){
        System.out.format("+-------------+-------------+-------------+------------+--------------+----------+-------+------------+%n");
        System.out.format("|    Type     |      ID     |    Price    |  Make Date | Manufacturer |  Model   | Glass |     OS     |%n");
        System.out.format("+-------------+-------------+-------------+------------+--------------+----------+-------+------------+%n");
    }

    /**
     * Prints the information in "s" in a table format.
     * @param s An object of class Screen or one of its subclasses.
     */
    public void printProducts(Screen s) {

        if (s instanceof SmartTV) {
            SmartTV stv = (SmartTV) s;
            printProductSTV(stv);
        }
        else if (s instanceof CRT) {
            CRT crt = (CRT) s;
            printProductCRT(crt);
        }
        else if (s instanceof LED) {
            LED led = (LED) s;
            printProductLED(led);
        }
        else if (s instanceof ComputerMonitor) {
            ComputerMonitor cm = (ComputerMonitor) s;
            printProductCM(cm);
        }

        else {
            System.out.printf("%s %11s %s","|", s.toString(), "|");
            System.out.printf("%13s%s",  s.getId(), "|");
            System.out.printf("%12s %s", "$"+s.getPrice(), "|");
            System.out.printf("%11s %s", SDF.format(s.getMakeDate()), "|");
            System.out.printf("%13s %s", s.getManufacturer(), "|");
            System.out.format("%9s %s",  s.getModel(), "|");
            System.out.format("%8s", "|");
            System.out.format("%13s", "|");
        }


        System.out.format("%n+-------------+-------------+-------------+------------+--------------+----------+-------+------------+%n");

    }

    /**
     * Prints the information in "led" in a row.
     * @param led An instance of class LED.
     */
    public void printProductLED(LED led) {                                              //LED has neither "operatingSystem" nor "glassThickness"

        System.out.printf("%s %11s %s","|", led.toString(), "|");
        System.out.printf("%13s%s",  led.getId(), "|");
        System.out.printf("%12s %s", "$"+led.getPrice(), "|");
        System.out.printf("%11s %s", SDF.format(led.getMakeDate()), "|");
        System.out.printf("%13s %s", led.getManufacturer(), "|");
        System.out.format("%9s %s",  led.getModel(), "|");
        System.out.format("%8s", "|");
        System.out.format("%13s", "|");
    }
    /**
     * Prints the information in "cm" in a row.
     * @param cm An instance of class ComputerMonitor.
     */
    public void printProductCM(ComputerMonitor cm) {

        System.out.printf("%s %11s %s","|", cm.toString(), "|");
        System.out.printf("%13s%s",  cm.getId(), "|");
        System.out.printf("%12s %s", "$"+cm.getPrice(), "|");
        System.out.printf("%11s %s", SDF.format(cm.getMakeDate()), "|");
        System.out.printf("%13s %s", cm.getManufacturer(), "|");
        System.out.format("%9s %s",  cm.getModel(), "|");
        System.out.format("%8s", "|");
        System.out.format("%13s", "|");
    }
    /**
     * Prints the information in "stv" in a row.
     * @param stv An instance of class SmartTV.
     */
    public void printProductSTV(SmartTV stv){                                             //Only SmartTV has "operatingSystem"

        System.out.format("%s %11s %s","|", stv.toString(), "|");
        System.out.printf("%12s %s", stv.getId(), "|");
        System.out.printf("%12s %s", "$"+stv.getPrice(), "|");
        System.out.printf("%11s %s", SDF.format(stv.getMakeDate()), "|");
        System.out.printf("%13s %s", stv.getManufacturer(), "|");
        System.out.printf("%9s %s", stv.getModel(), "|");
        System.out.printf("%8s %10s %s","|",stv.getOperatingSystem(),"|");

    }
    /**
     * Prints the information in "crt" in a row.
     * @param crt An instance of class CRT.
     */
    public void printProductCRT(CRT crt){                                               //Only CRT has "glassThickness"
        System.out.printf("%s %11s %s" , "|", crt.toString()  , "|");
        System.out.printf("%12s %s",  crt.getId(), "|");
        System.out.printf("%12s %s", "$"+crt.getPrice(), "|");
        System.out.printf("%11s %s", SDF.format(crt.getMakeDate()), "|");
        System.out.printf("%13s %s", crt.getManufacturer(), "|");
        System.out.printf("%9s %s", crt.getModel(), "|");
        System.out.printf("%6s %s", crt.getGlassThickness(), "|");
        System.out.printf("%13s","|");

    }

    /**
     * Method that loops through "listInventory", printing each one of its elements in a table format.
     */
    public void printInventory() {

        inventoryHeader();
        for ( Screen s:listInventory ) {
                printProducts(s);
        }
    }



}
