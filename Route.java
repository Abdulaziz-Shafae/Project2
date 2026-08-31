public class Route {

    public static final String MAIN = "\u001B[97m";

    private String pickUp;
    private String destination;
    private double tripPrice;

    public Route() {
        System.out.print(MAIN);
    }

    public Route(String pickUp, String destination, double tripPrice) {
        System.out.print(MAIN);
        this.pickUp = pickUp;
        this.destination = destination;
        this.tripPrice = tripPrice;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = tripPrice;
    }

//show the routes
    public void display(){

        System.out.println("Pick up address: "+ getPickUp()+
                "\nDestination address: " + getDestination()+
                "\nBase price: " + getTripPrice());

    }



}
