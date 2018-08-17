package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 *
 */
public class Dispatcher{
    /**
     *
     */
    ExecutorService executor;
    /**
     *
     */
    List<Attendant> attendants;


    /**
     *
     */
    public Dispatcher(){
        attendants = new ArrayList<Attendant>();
        createSupervisors(3);
        createCashiers(6);
        createDirectors(1);
        executor= Executors.newFixedThreadPool(10);

        }

    /**
     * @param i
     */
    private void createCashiers(int i){
        int count=1;
        while (count<=i) {
            attendants.add(new Cashier("Cashier "+count));
            count++;
        }
    }

    /**
     * @param i
     */
    private void createSupervisors(int i){
        int count=1;
        while (count<=i) {
            attendants.add(new Supervisor("Supervisor "+count));
            count++;
        }
    }

    /**
     * @param i
     */
    private void createDirectors(int i){
        int count=1;
        while (count<=i) {
            attendants.add(new Director("Director "+count));
            count++;
        }
    }

    /**
     * @return
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
     * @param client
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
     *
     */
    public void shutDown(){
        executor.shutdown();
    }


}
