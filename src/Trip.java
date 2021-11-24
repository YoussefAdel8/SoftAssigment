public class Trip {
    String source , destination;
    double price ;
    Passenger passenger;
    Driver driver ;

    public Trip(String source, String destination)
    {
        this.destination= destination;
        this.source = source ;

    };

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
