public class Ticket implements Comparable<Ticket>{
    public Ticket(int id, int cost, String from, String to, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    protected int id;
    protected int cost;
    protected String from;
    protected String to;
    protected int travelTime;

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        }
        if (this.cost > o.cost) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
