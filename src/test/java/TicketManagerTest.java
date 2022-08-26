import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);


    Ticket item1 = new Ticket(1, 10, "SOC", "VKO", 80);
    Ticket item2 = new Ticket(2, 20, "SVO", "DOM", 190);
    Ticket item3 = new Ticket(3, 30, "VKO", "SKT", 100);
    Ticket item4 = new Ticket(4, 50, "DOM", "AMS", 240);
    Ticket item5 = new Ticket(5, 40, "AMS", "DOM", 240);
    Ticket item6 = new Ticket(6, 60, "LAX", "VKO", 600);
    Ticket item7 = new Ticket(7, 10, "SOC", "VKO", 300);

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);

    }

    @Test
    public void shouldShowAllTickets() {
        Arrays.sort(repo.getItems());
        Ticket[] expected = {item1, item7, item2, item3, item5, item4, item6};
        Ticket[] actual = manager.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsByMatches() {
        Arrays.sort(repo.getItems());
        Ticket[] expected = {item1, item7};
        Ticket[] actual = manager.searchBy("SOC", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

}
