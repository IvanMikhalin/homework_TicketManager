import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket item1 = new Ticket(1, 10, "SOC", "VKO", 80);
    Ticket item2 = new Ticket(2, 20, "SVO", "DOM", 190);
    Ticket item3 = new Ticket(3, 30, "VKO", "SKT", 100);
    Ticket item4 = new Ticket(4, 40, "DOM", "AMS", 240);
    Ticket item5 = new Ticket(5, 50, "AMS", "DOM", 240);
    Ticket item6 = new Ticket(6, 60, "LAX", "VKO", 600);
    Ticket item7 = new Ticket(7, 70, "BNU", "SVO", 300);

    TicketRepository repo = new TicketRepository();


    @Test
    public void shouldDeleteTicketById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        Ticket[] expected = {item1, item3, item4};
        Ticket[] actual = repo.removeById(2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowErrorMessageIfnoSuchTicket() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(44);
        });
    }

    @Test
    public void shouldDeleteTicket() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.removeById(item3.getId());

        Ticket[] expected = {item1, item2, item4};
        Ticket[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewTicket() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = {item1, item2, item3, item4};
        Ticket[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = {item1};
        Ticket[] actual = repo.findById(1);

        Assertions.assertArrayEquals(expected, actual);

    }
}
