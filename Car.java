public class Car {

    public static final String MAIN = "\u001B[97m";

    private String code;
    private Route route;
    private int maxPassengers;
    private int curPassengers=0;

    public Car() {
        System.out.print(MAIN);
    }

    public Car(int maxPassengers, Route route, String code) {
        System.out.print(MAIN);
        this.maxPassengers = maxPassengers;
        this.route = route;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getCurPassengers() {
        return curPassengers;
    }

    public void addPass(){
        curPassengers++;
    }

    public void removePass(){
        curPassengers--;
    }


    //show the cars
    public void display(){

        System.out.println("Car code:" + getCode()+
                "\nCurrent/Max passengers: " + getCurPassengers()+ "/" + getMaxPassengers()+
                "\nPick up address: "+ getRoute().getPickUp()+
                "\nDestination address: " + getRoute().getDestination()+
                "\nBase price: " + getRoute().getTripPrice());

    }
}
