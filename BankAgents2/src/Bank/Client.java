package Bank;

import java.util.Random;
import java.util.function.Supplier;

/**
 *
 */
public class Client implements Supplier {

    /**
     *
     */
    private String name;
    /**
     *
     */
    private int time;
    /**
     *
     */
    private int id;

    /**
     * @param name
     * @param id
     */
    public Client(String name, int id){
        Random rand = new Random();
        time = rand.nextInt(5000)+10000;
        this.name = name;
        this.id = id;
    }

    /**
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }


    /**
     * @return
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
