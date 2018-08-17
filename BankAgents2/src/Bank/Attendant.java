package Bank;

/**
 * Represents an bank Attendant(Agent).
 * It can be attending a client or not,
 * which means that sometimes will be busy and other times available.
 */
public abstract class Attendant {

    /**
     * Type of attendant.
     * It is the role of the attendant, it could be a cashier, a supervisor or a director.
     */
    private AgentType type;
    /**
     * The identification name for the attendant.
     */
    private String name;
    /**
     * The client that the agent will attend or is attending.
     */
    private Client client;
    /**
     * The availability of the attendant.
     */
    private boolean availability;

    /**
     * Creates a new attendant with the given name.
     * When it's created the Attendant is available so it does not have a client.
     * @param name The identification name for the attendant.
     */
    public Attendant (String name){
        availability = true;
        this.name = name;
    }

    /**
     * Gives the name of the attendant
     * @return This attendant name
     */
    public String getName(){

        return this.name;
    }

    /**
     * Gives the type/role of the attendant
     * @return
     */
    public AgentType getType(){

        return this.type;
    }

    /**
     * Set the type of the attendant (agent)
     * @param type
     */
    public void setType(AgentType type){
        this.type=type;
    }

    /**
     * Set the availability of the agent as false which means that is busy.
     */
    public void setBusy(){
        availability = false;
    }

    /**
     * Gets the availability of this attendant.
     * @return the availability of this attendant
     */
    public boolean isAvailable(){

        return availability;
    }

    /**
     * Gets the client who is going to be attended by this agent.
     * @return the assigned client
     */
    public Client getClient() {

        return client;
    }

    /**
     * Attend a client, so this agent gets busy and the client is set.
     * @param client Client who is going to be attended
     */
    public void attendClient(Client client){
        this.client = client;
        setBusy();
        //System.out.println(this.name+" is busy");

        System.out.println("The client "
                +client.getName()+" with ID: "+client.getId()+" is assigned to the " +this.name);

    }

    /**
     * Stops attending the client and is now available.
     */
    public void releaseClient(){
        this.client = null;
        this.availability = true;
        //System.out.println(this.name+" is not busy");

    }
}
