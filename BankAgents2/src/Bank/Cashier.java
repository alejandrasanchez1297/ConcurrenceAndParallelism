package Bank;

/**
 * Represents a bank agent with the role of being a cashier.
 */
public class Cashier extends Attendant{


    /**
     * Creates a new cashier with the given name.
     * @param name Name of the cashier.
     */
    public Cashier(String name) {
        super(name);
        setType(AgentType.CASHIER);
    }


}
