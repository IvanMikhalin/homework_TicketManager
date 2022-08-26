import java.util.Arrays;

public class TicketManager {


    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket item) {
        repo.save(item);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        TicketRepository searchResult = new TicketRepository();

        for (Ticket ticket : repo.getItems()) {
            if (matches(ticket, from, to)) {
                searchResult.save(ticket);
                result = searchResult.getItems();
            }
        }
        return result;
    }


    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        return ticket.getFrom().contains(searchFrom) && ticket.getTo().contains(searchTo);
    }

    public Ticket[] getItems() {
        return repo.getItems();
    }


}
