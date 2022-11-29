package lambda;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();

        clients.add(new Client("Harry Potter", 15, true));
        clients.add(new Client("Adam Atkinson", 5, true));
        clients.add(new Client("Sam Ramie", 7, true));
        clients.add(new Client("Green Fergisson", 9, false));
        clients.add(new Client("Garry OldMan", 11, true));
        clients.add(new Client("Sarah Parker", 3, false));
        clients.add(new Client("Nelly Furtando", 5, true));
        clients.add(new Client("Jessica Simpson", 13, false));
        clients.add(new Client("Salma Hayek", 8, true));
        clients.add(new Client("Ray Woodstock", 18, true));
        clients.add(new Client("Roan Atkinson", 12, false));

        System.out.println(clients);

        clients.forEach(client -> client.setBalance(client.getBalance() - 1));

        System.out.println(clients);

        System.out.println("--------------------");

        int pay = clients.stream()
                .filter(client -> client.getBalance() > 10)
                .filter(client -> !client.isActive)
                .reduce(0, (integer, client) -> integer + client.getBalance(), Integer::sum);

        System.out.println(pay);

        // тот же кусок кода только циклом for
        int lay = 0;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getBalance() > 10 && !clients.get(i).isActive)
                lay += clients.get(i).getBalance();
        }
        System.out.println(lay);

        System.out.println("--------------------");

        clients.stream()
                .filter(client -> !client.isActive)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("--------------------");

        clients.stream()
                .filter(client -> client.getBalance() > 10)
                .peek(System.out::println)
                .collect(Collectors.toList());


    }
}

