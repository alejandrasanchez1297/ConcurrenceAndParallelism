package Bank;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Ana Afanador",123445);
        Client client2 = new Client("Beatriz Borbón",223445);
        Client client3 = new Client("Celeste Corredor",323445);
        Client client4 = new Client("Daniela Duran",423445);
        Client client5 = new Client("Elena E",523445);
        Client client6 = new Client("Fabian Flores",623445);
        Client client7 = new Client("Gertrudis Giraldo",723445);
        Client client8 = new Client("Horacio Horan",823445);
        Client client9 = new Client("Ignacio Iglesias",923445);
        Client client10 = new Client("Juliana Jupiter",923445);

        Dispatcher dispatcher = new Dispatcher();

        dispatcher.attend(client1);
        dispatcher.attend(client2);
        dispatcher.attend(client3);
        dispatcher.attend(client4);
        dispatcher.attend(client5);
        dispatcher.attend(client6);
        dispatcher.attend(client7);
        dispatcher.attend(client8);
        dispatcher.attend(client9);
        dispatcher.attend(client10);
        dispatcher.shutDown();



    }
}
