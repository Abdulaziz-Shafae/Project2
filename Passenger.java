import java.util.ArrayList;

public abstract class Passenger {


    public static final String MAIN        = "\u001B[97m";
    public static final String BG_YELLOW   = "\u001B[43m";
    public static final String BOLD        = "\u001B[1m";
    public static final String RESET       = "\u001B[0m";
    public static final String BG_GREEN    = "\u001B[42m";


    private String name;
    private String id;
    private Car car;
    private double tripCost;

//here we store the trips of the passenger
    public ArrayList<String> trips= new ArrayList<>();

//here we store the done trips of the passenger
    public ArrayList<String> doneTrips= new ArrayList<>();


    public Passenger() {
        System.out.print(MAIN);
    }
    public Passenger(String name, String id) {
        System.out.print(MAIN);
        this.name = name;
        this.id = id;
    }

    abstract void reserveCar(Car car );

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public ArrayList<String> getTrips() {
        return trips;
    }


    //check if the capacity in not 0 and if it not full
    protected boolean checkCap(Car car){

        boolean checkCap=true;

        try {

            if(car.getMaxPassengers()==0){
                checkCap=false;
                throw new Exception(" The car can't accept passengers ");
            }else if (car.getMaxPassengers()<=car.getCurPassengers()){
                checkCap=false;
                throw new Exception(" The car is full ");
            }else {
                car.addPass();
                System.out.println("\n"+BG_GREEN + MAIN + BOLD + " ^^\\ The car successfully reserved /^^ " + RESET+MAIN);
            }

        }catch (Exception e){
            System.out.println("\n"+BG_YELLOW + MAIN + BOLD + e.getMessage() + RESET+MAIN);
        }
        return checkCap;
    }

}
