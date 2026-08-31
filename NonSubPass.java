public class NonSubPass extends Passenger{

    private boolean discountCoupon=false;

    public NonSubPass() {
    }

    public NonSubPass(boolean discountCoupon) {
        System.out.print(MAIN);
        this.discountCoupon = discountCoupon;
    }

    public NonSubPass(String name, String id, boolean discountCoupon) {
        super(name, id);
        System.out.print(MAIN);
        this.discountCoupon = discountCoupon;
    }

    public void setDiscountCoupon(boolean discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    public boolean getDiscountCoupon() {
        return discountCoupon;
    }

    //reserve the car for the passenger, after checking the capacity
    public void reserveCar(Car car ){

        if(checkCap(car)){

            super.setCar(car);

            super.setTripCost(discountCoupon? (car.getRoute().getTripPrice() * .9) : (car.getRoute().getTripPrice()));

            System.out.println("ID: " + getId()+
                    "\nName: " + getName()+
                    "\nCar code: " + car.getCode()+
                    "\nTrip cost: "+ super.getTripCost() );

//store the trip with the price
            trips.add("ID: " + getId()+
                    "\nName: " + getName()+
                    "\nCar code: " + car.getCode()+
                    "\nTrip cost: "+ super.getTripCost() );
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
