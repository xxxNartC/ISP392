package Model;

public class Table {
    private int TableNumber;
    private int Seats;
    private String Status;

    public Table() {}

    public Table(int TableNumber, int Seats, String Status) {
        this.TableNumber = TableNumber;
        this.Seats = Seats;
        this.Status = Status;
    }

    public int getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(int TableNumber) {
        this.TableNumber = TableNumber;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
