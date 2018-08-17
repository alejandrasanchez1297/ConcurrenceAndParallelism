package Bank;

/**
 *  Represents a bank agent with the role of being a supervisor
 */
public class Supervisor extends Attendant{

    /**
     * Creates a new supervisor with the given name
     * @param name Name of the supervisor
     */
    public Supervisor(String name) {
        super(name);
        setType(AgentType.SUPERVISOR);
    }
}
