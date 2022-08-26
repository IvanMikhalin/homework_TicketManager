public class TicketRepository {

    private Ticket[] items = new Ticket[0];

    public Ticket[] findById(int id) {
        TicketRepository searchResult = new TicketRepository();
        for (Ticket ticket : getItems()) {
            if (ticket.getId() == id) {
                searchResult.save(ticket);
                return searchResult.getItems();
            }
        }
        return null;
    }

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Ticket[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "билет с " + id + " не найден"
            );
        }
        Ticket[] tmp = new Ticket[items.length - 1];
        int copyToIndex = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
        return tmp;
    }

    public Ticket[] getItems() {
        return items;
    }
}
