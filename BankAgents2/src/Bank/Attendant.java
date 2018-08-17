package Bank;

/**
 * Represents an bank Agent or Attendant.
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
     *
     * @return
     */
    public AgentType getType(){

        return this.type;
    }

    /**
     * @param type
     */
    public void setType(AgentType type){
        this.type=type;
    }

    /**
     *
     */
    public void setBusy(){
        availability = false;
    }

    /**
     * @return
     */
    public boolean isAvailable(){
        return availability;
    }

    /**
     * @return
     */
    public Client getClient() {

        return client;
    }

    /**
     * @param client
     */
    public void attendClient(Client client){
        this.client = client;
        setBusy();
        //System.out.println(this.name+" is busy");

        System.out.println("The client "
                +client.getName()+" with ID: "+client.getId()+" is assigned to the " +this.name);

    }

    /**
     *
     */
    public void releaseClient(){
        this.client = null;
        this.availability = true;
        //System.out.println(this.name+" is not busy");

    }
}
