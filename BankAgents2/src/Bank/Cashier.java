package Bank;

/**
 *
 */
public class Cashier extends Attendant{


    /**
     * @param name
     */
    public Cashier(String name) {
        super(name);
        setType(AgentType.CASHIER);
    }


}
