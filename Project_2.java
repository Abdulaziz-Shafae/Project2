import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project_2 {

//if create an acc the system will check if the user have a discount code
    static  ArrayList<String> discounts= new ArrayList<>();
    static Scanner s = new Scanner(System.in);


    public static final String MAIN        = "\u001B[97m";
    public static final String BG_YELLOW   = "\u001B[43m";
    public static final String BG_GREEN     = "\u001B[42m";
    public static final String BOLD        = "\u001B[1m";
    public static final String RESET       = "\u001B[0m";
    public static final String GRAY1 = "\u001B[90m";
    public static final String ITALIC        = "\u001B[3m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";


    public static void main(String[] args) throws InterruptedException {
        System.out.print(MAIN);

//adding the discount
        discounts.add("shefo");
        discounts.add("majd");
        discounts.add("renad");
        discounts.add("turki");

//adding the main data

        Route r1 = new Route("Tuwaiq" , "Roshan Front" , 55);
        Route r2 = new Route("Roshan Front", "Tuwaiq" , 50);

        Car c1 = new Car(2,r1,"123");
        Car c2 = new Car(0,r2,"111");

        ArrayList<Passenger> passenger= new ArrayList<>();

        SubPass sp1= new SubPass("shefo","1234");
        SubPass sp2= new SubPass("yara","1233");
        NonSubPass nsp1= new NonSubPass("khalid","1232",false);
        NonSubPass nsp2= new NonSubPass("njoud","1231",true);

        passenger.add(sp1);
        passenger.add(nsp1);
        passenger.add(sp2);
        passenger.add(nsp2);


//data-base
        ArrayList<Route> routes= new ArrayList<>();
        Route r3 = new Route("Tuwaiq" , "LEAP" , 90);
        Route r4 = new Route("LEAP" , "Tuwaiq" , 95);
        Route r5 = new Route("LEAP" , "Roshan Front" , 100);

        routes.add(r1);
        routes.add(r2);
        routes.add(r3);
        routes.add(r4);
        routes.add(r5);

        ArrayList<Car> cars= new ArrayList<>();
        Car c3 = new Car(1,r3,"222");
        Car c4 = new Car(5,r4,"333");
        Car c5 = new Car(6,r5,"444");
        Car c6 = new Car(8,r5,"555");

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);
        cars.add(c6);

        int choice;
        Passenger curP = null;
        NonSubPass curPN = null;

        System.out.println(BOLD+ITALIC+"------ "+CYAN+"Car Pooling System"+MAIN+" ------"+RESET+MAIN);

        do{

            System.out.print(BOLD+"\n------ "+CYAN+"Main menu"+MAIN+" ------"+RESET+MAIN +
                    "\n1.Show the main data" +
                    "\n2.Sign in" +
                    "\n3.Create account" +
                    "\n4.Exit" +
                    "\nChoose a number: ");
            try {
                choice=s.nextInt();

            }catch(InputMismatchException e){
                s.nextLine();
                choice=9;
            }

            switch (choice){

                case 1:

                    sp1.reserveCar(c1);
                    Thread.sleep(1500);

                    sp2.reserveCar(c6);
                    Thread.sleep(1500);

                    nsp2.reserveCar(c6);
                    Thread.sleep(1500);

                    nsp1.reserveCar(c2);
                    Thread.sleep(1500);


                    int i =1;
                    for ( Passenger p : passenger){
                        System.out.println("\n----- "+GREEN+"Passenger "+i+MAIN+" -----");
                        System.out.println(p.toString());
                        Thread.sleep(1500);
                        i++;
                    }

                    break;

//sign in
                case 2:
                    System.out.print("\n-----------------------" +
                            "\nEnter you ID "+GRAY1+"(valid test 1234): "+MAIN);
                    s.nextLine();
                    String tempID=s.nextLine();

                    boolean check=false;
                    for ( Passenger p : passenger){

                        if(p.getId().equals(tempID)){
                            if(p.getId().equals("1234")){
                                sp1.reserveCar(c1);
                                sp1.reserveCar(c1);
                                sp1.reserveCar(c3);
                                sp1.reserveCar(c5);
                                sp1.reserveCar(c5);
                                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            }

                            System.out.println("\n\n----- "+ITALIC+CYAN+"Welcome "+ p.getName() +RESET+MAIN+" -----");
                            curP=p;
                            check=true;
                            choice=4;
                            break;
                        }
                    }


                    if(!check)
                        System.out.println("\n"+BG_YELLOW + MAIN + BOLD + " The ID is wrong " + RESET + MAIN);

                    break;

//create acc
                case 3:

                    System.out.print("Enter your name: ");
                    s.nextLine();
                    String tempN=s.nextLine();

                    System.out.print("Enter your id (____): ");
                    String tempI=s.nextLine();

//check if the id 4 numbers
                    try{
                    //this will check if it is numbers
                        Integer.parseInt(tempI);
                    //this will check if it is 4 numbers
                        if(tempI.length()==4){
                    //this will check if it is not taken
                            for (Passenger p : passenger){
                                if(tempI.equals(p.getId())){
                                    throw new Exception(" This ID is taken ");
                                }
                            }

                            curPN = new NonSubPass();
                            curP = curPN;

                            curP.setName(tempN);
                            curP.setId(tempI);
                            System.out.print("Do you have Discount code? y-n: ");
                            if(s.nextLine().equalsIgnoreCase("y")){

                            //check if the discount code is from the list
                                System.out.print("Enter the Discount code: ");
                                curPN.setDiscountCoupon(checkDiscount(s.nextLine()));
                            }
                            passenger.add(curP);
                            choice=4;
                            Thread.sleep(1500);

                            sp1.reserveCar(c1);
                            sp2.reserveCar(c1);
                            sp2.reserveCar(c3);
                            nsp1.reserveCar(c5);
                            nsp2.reserveCar(c5);

                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("\n\n----- "+ITALIC+CYAN+"Welcome "+ curP.getName() +RESET+MAIN+" -----");

                        }else {
                            System.out.println("\n"+BG_YELLOW + MAIN + BOLD + " Enter valid id must be 4 numbers " + RESET + MAIN);
                        }
                    }catch (NumberFormatException e){
                        System.out.println("\n"+BG_YELLOW + MAIN + BOLD + " Enter valid id must be 4 numbers " + RESET + MAIN);
                    }catch (Exception e1){
                    //error msg if not only numbers
                        System.out.println("\n"+BG_YELLOW + MAIN + BOLD + e1.getMessage() + RESET + MAIN);

                    }

                    break;

                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n"+BG_YELLOW + MAIN + BOLD + " Enter valid number " + RESET + MAIN);

            }

        }while (choice!=4);


        int choiceU;
        int i;
        do {
            System.out.print(BOLD+"\n------ "+CYAN+"User menu"+MAIN+" ------"+RESET+MAIN +
                    "\n1.Show routes" +
                    "\n2.Show cars" +
                    "\n3.Reserved trips" +
                    "\n4.Reserve a car" +
                    "\n5."+ ((curP instanceof SubPass )? "UnSubscribe" : "Subscribe") +
                    "\n6.Exit" +
                    "\nChoose a number: ");
            try {
                choiceU=s.nextInt();

            }catch(InputMismatchException e){
                s.nextLine();
                choiceU=9;
            }

            switch (choiceU) {

                case 1:

                    i = 1;
                    for (Route r : routes) {
                        System.out.println("\n----- "+GREEN+"Route " + i +MAIN+ " -----");
                        r.display();
                        Thread.sleep(1500);

                        i++;
                    }

                    break;

                case 2:

                    i = 1;
                    for (Car c : cars) {
                        System.out.println("\n----- "+GREEN+"Car " + i +MAIN+ " -----");
                        c.display();
                        Thread.sleep(1500);
                        i++;
                    }

                    break;
                case 3:

                    i=1;
                    for( String t : curP.trips ){
                        System.out.println("\n----- "+GREEN+"Trip " + i +MAIN+ " -----");
                        System.out.println(t);
                        Thread.sleep(1500);
                        i++;
                    }

                    break;

                case 4:

                    i=1;
                    for(Car r : cars){
                        System.out.println("\n----- "+GREEN+"Car " + i +MAIN+ " -----");
                        i++;
                        System.out.println("Car code:" + r.getCode()+
                                "\nPick up address: "+ r.getRoute().getPickUp()+
                                "\nDestination address: " + r.getRoute().getDestination()+
                                "\nBase price: " + r.getRoute().getTripPrice());
                        Thread.sleep(1500);

                    }
                    boolean check;
                    do {
                        System.out.print("Enter the car code: ");
                        s.nextLine();
                        String tempCode = s.nextLine();
                        check = false;
                        for (Car r : cars) {
                            if (r.getCode().equals(tempCode)) {
                                curP.reserveCar(r);
                                check = true;
                                break;
                            }
                        }

                        if (!check) {
                            System.out.println("\n" + BG_YELLOW + MAIN + BOLD + " Invalid car code " + RESET + MAIN);
                        }

                    }while (!check);

                    break;

                case 5:
                    int index = passenger.indexOf(curP);

                    if (curP instanceof SubPass){

                        NonSubPass removeSub = new NonSubPass(curP.getName(), curP.getId(),true);

                        removeSub.trips.addAll(curP.trips);
                        removeSub.setCar(curP.getCar());
                        removeSub.setTripCost(curP.getTripCost());

                        passenger.set(index, removeSub);

                        curP = removeSub;

                        System.out.println("\n" + BG_GREEN + MAIN + BOLD + " UnSubscribed Successfully " + RESET + MAIN);


                    }else {

                        SubPass newSub = new SubPass(curP.getName(), curP.getId());

                        newSub.trips.addAll(curP.trips);
                        newSub.setCar(curP.getCar());
                        newSub.setTripCost(curP.getTripCost());

                        passenger.set(index, newSub);

                        curP = newSub;

                        System.out.println("\n" + BG_GREEN + MAIN + BOLD + " Subscribed Successfully " + RESET + MAIN);

                    }

                    break;

                case 6:
                    break;

                default:
                    System.out.println("\n" + BG_YELLOW + MAIN + BOLD + " Enter valid number " + RESET + MAIN);

            }
        }while (choiceU!=6);


    }

//check the discount code
    public static boolean checkDiscount(String input){


        for(String i : discounts){

            if(input.equalsIgnoreCase(i)){
                System.out.println("\n" + BG_GREEN + MAIN + BOLD + " The discount code applied " + RESET + MAIN);
                return true;
            }

        }
        System.out.println("\n" + BG_YELLOW + MAIN + BOLD + " The discount code is wrong " + RESET + MAIN);
        System.out.print("\nRetry y-n: ");
        if(s.nextLine().equalsIgnoreCase("y")){
            System.out.print("Enter the Discount code: ");
            return checkDiscount(s.nextLine());
        }else return false;

    }

}
