package Bank;

/**
 *  Represents a bank agent with the role of being a director.
 */
public class Director extends Attendant{


    /**
     * Creates a new director with the given name.
     * @param name Name of the director.
     */
    public Director(String name) {
        super(name);
        setType(AgentType.DIRECTOR);
    }
}
