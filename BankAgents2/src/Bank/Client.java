package Bank;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Represents a client of the bank
 */
public class Client implements Supplier {

    /**
     * The name of the client
     */
    private String name;
    /**
     * The time of the process that the client needs to do
     */
    private int time;
    /**
     * The identification number of the client
     */
    private int id;

    /**
     * Creates a new client with the name and id given.
     * @param name The name of the new client.
     * @param id The id of the new Client.
     */
    public Client(String name, int id){
        Random rand = new Random();
        time = rand.nextInt(5000)+10000;
        this.name = name;
        this.id = id;
    }

    /**
     * Gives the name of this client.
     * @return The client name.
     */
    public String getName(){
        return name;
    }

    /**
     * Gives the number identification of this client.
     * @return The client ID.
     */
    public int getId() {
        return id;
    }


    /**
     *  Overrides the method get of the supplier interface.
     * @return A string with this client information and how long the process was.
     */
    @Override
    public String get() {
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "The client "
                +this.name+" with ID : "+this.id+" was attended and the operation lasted "+(this.time)+" mili seconds.";
    }
}
