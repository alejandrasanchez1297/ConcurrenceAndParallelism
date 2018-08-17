package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Represents a dispatcher of the bank that assign a client to a attendant.
 */
public class Dispatcher{
    /**
     *  Executor
     */
    ExecutorService executor;
    /**
     * List of the attendants of the bank.
     */
    List<Attendant> attendants;


    /**
     * Creates a dispatcher who is able to attend 10 concurrent clients.
     */
    public Dispatcher(){
        attendants = new ArrayList<Attendant>();
        createSupervisors(3);
        createCashiers(6);
        createDirectors(1);
        executor= Executors.newFixedThreadPool(10);

        }

    /**
     * Creates the cashiers of the bank, the number is given by the parameter.
     * @param i The number of cashiers to be created.
     */
    private void createCashiers(int i){
        int count=1;
        while (count<=i) {
            attendants.add(new Cashier("Cashier "+count));
            count++;
        }
    }

    /**
     * Creates the supervisors of the bank, the number is given by the parameter.
     * @param i The number of cashiers to be created.
     */
    private void createSupervisors(int i){
        int count=1;
        while (count<=i) {
            attendants.add(new Supervisor("Supervisor "+count));
            count++;
        }
    }

    /**
     * Creates the directors of the bank, the number is given by the parameter.
     * @param i The number of cashiers to be created.
     */
    private void createDirectors(int i){
        int count=1;
        while (count<=i) {
            attendants.add(new Director("Director "+count));
            count++;
        }
    }

    /**
     * Gives the available attendant, looks first for an available cashier,
     * then for an available supervisor
     * and lastly for an available director.
     * @return The available attendant.
     */
    private Attendant availableAttendant(){
        return  attendants.stream()
                .filter(att->att.getType().equals(AgentType.CASHIER))
                .filter(att->att.isAvailable()).findAny()
                .orElse(attendants.stream()
                        .filter(att->att.getType().equals(AgentType.SUPERVISOR))
                        .filter(att->att.isAvailable()).findAny().orElse(attendants.stream()
                                .filter(att->att.getType().equals(AgentType.DIRECTOR))
                                .filter(att->att.isAvailable())
                                .findAny()
                                .orElse(null)));

    }

    /**
     * Assign the given client with the available attendant.
     * @param client The client to be attended.
     */
    public void attend(Client client)  {
        int indexAttendant = attendants.indexOf(availableAttendant());
        attendants.get(indexAttendant).attendClient(client);
        CompletableFuture
                .supplyAsync(attendants.get(indexAttendant).getClient(), executor)
                .thenAccept(response -> {
                    System.out.println(response);
                    attendants.get(indexAttendant).releaseClient();
                });

    }

    /**
     * Shuts down the executor.
     */
    public void shutDown(){
        executor.shutdown();
    }


}
