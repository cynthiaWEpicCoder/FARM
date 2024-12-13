import java.util.*;

public class Driver{
    public static void main (String[] args){
        Farmer player1 = new FruitFarmer ("Aud");
        public void printMsg (){
    System.out.println ("Hello __, and welcome to Nightmare Farm! You used to be a student at Stuyvesant High School, but then one day you were taken away. You're not quite sure what happened, but now you're here, and you want to leave as fast as possible.");
    System.out.println ("Unfortunately, the only way to escape is through the Super-Duper-Rico Train, which for some reason costs 100 gold coins. To make money, you need to work.");
    System.out.println ("What type of farmer will you be? \n1 for fruit farmer \n2 for grain farmer \n3 for veggie farmer");
  }
        player1.plant();
        player1.water();
        player1.water();
        System.out.println(player1.getFarm());
        player1.harvest();
        System.out.println(player1.getInv());
        player1.produce();
        System.out.println(player1.getInv());
        player1.sell();
        System.out.println(player1.getInv());
        System.out.println(player1.getCoins());u

        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        
        while (player1.getCoins() < 100){
            while (player1.getTurns() > 0){
                System.out.println("What will you do next? \n1 to plant \n2 to water \n3 to harvest \n4 to produce item \n5 to sell item");
                int move = input.nextInt();
                turn(move);
            }
            System.out.println("You are out of moves today. Great day of work! Goodnight.");
            player1.setTurns(5);
        }
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
