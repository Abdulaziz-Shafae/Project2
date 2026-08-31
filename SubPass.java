import java.util.ArrayList;

public class SubPass extends Passenger{


    public SubPass() {
        System.out.print(MAIN);
    }

    public SubPass(String name, String id) {
        super(name, id);
        System.out.print(MAIN);
    }

//reserve the car for the passenger, after checking the capacity
    public void reserveCar(Car car ){

        if(checkCap(car)){

            super.setCar(car);

            super.setTripCost(car.getRoute().getTripPrice() * .5);
            System.out.println("ID: " + getId()+
                    "\nName: " + getName()+
                    "\nCar code: " + car.getCode()+
                    "\nTrip cost: "+ ( super.getTripCost() )  );

//store the trip with the price
            trips.add("ID: " + getId()+
                    "\nName: " + getName()+
                    "\nCar code: " + car.getCode()+
                    "\nTrip cost: "+ ( super.getTripCost() )  );

        }
    }

//print the list of Passenger
    public String toString(){


        if (getCar() == null) {
            return "ID: " + getId() +
                    "\nName: " + getName() +
                    "\nCar: No reserved car" +
                    "\nTrip cost: " + getTripCost();
        }

        return "ID: " + getId() +
                "\nName: " + getName() +
                "\nCar code: " + getCar().getCode() +
                "\nTrip cost: " + getTripCost();
    }

}
