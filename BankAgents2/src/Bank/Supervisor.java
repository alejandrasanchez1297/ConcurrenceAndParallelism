package Bank;

/**
 *
 */
public class Supervisor extends Attendant{

    /**
     * @param name
     */
    public Supervisor(String name) {
        super(name);
        setType(AgentType.SUPERVISOR);
    }
}
