package Bank;

/**
 *
 */
public class Director extends Attendant{


    /**
     * @param name
     */
    public Director(String name) {
        super(name);
        setType(AgentType.DIRECTOR);
    }
}
