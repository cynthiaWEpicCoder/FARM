import java.util.*;

public class Driver{
    public static void main (String[] args){
        int day = 0;
        boolean stonksUp = false;
        boolean daylightGivings = false;

        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println ("Hello " + name + ", and welcome to Nightmare Farm! You used to be a student at Stuyvesant High School, but then one day you were taken away. You're not quite sure what happened, but now you're here, and you want to leave as fast as possible.");
        System.out.println ("Unfortunately, the only way to escape is through the Super-Duper-Rico Train, which for some reason costs 100 gold coins. To make money, you need to work.");
        System.out.println ("What type of farmer will you be? \n1 for fruit farmer \n2 for grain farmer \n3 for veggie farmer");
        int farmerType = input.nextInt();
        if (farmerType == 1){
            Farmer player1 = new FruitFarmer(name);
        }
        if (farmerType == 2){
            Farmer player1 = new GrainFarmer(name);
        }
        if (farmerType == 3){
            Farmer player1 = new VeggieFarmer(name);
        }
        while (player1.getCoins() < 100){
            day ++;
            System.out.println("~~~~~~~~ DAY " + day + " ~~~~~~~~");
            while (player1.getTurns() > 0){
                System.out.println("What will you do next? \n1 to plant \n2 to water \n3 to harvest \n4 to produce item \n5 to sell item");
                int move = input.nextInt();
                turn(move);
            }
            System.out.println("You are out of moves today. Great day of work! Goodnight.");
            player1.setTurns(5);
        }
        System.out.println("You collected " + player1.getCoins() + " coins and bought a ticket home.");
    }
    public static void turn(int turnType){
        if (turnType == 1){
            player1.plant();
        }
        if (turnType == 2){
            player1.water();
        }
        if (turnType == 3){
            player1.harvest();
        }
        if (turnType == 4){
            player1.produce();
        }
        if (turnType == 5){
            player1.sell();
        }
    }

    public static void nightmare(){

        
}
