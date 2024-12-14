import java.util.*;

public class Driver{
    static int day = 0;
    static boolean stonksUp = false;
    static boolean daylightGivings = false;
    static Random rand = new Random();
    static boolean strangerHasCome = false;
    static Farmer player1;
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println ("Hello " + name + ", and welcome to Nightmare Farm! You used to be a student at Stuyvesant High School, but then one day you were taken away. You're not quite sure what happened, but now you're here, and you want to leave as fast as possible.");
        System.out.println ("Unfortunately, the only way to escape is through the Super-Duper-Rico Train, which for some reason costs 100 gold coins. To make money, you need to work.");
        System.out.println ("What type of farmer will you be? \n1 for fruit farmer \n2 for grain farmer \n3 for veggie farmer");
        int farmerType = input.nextInt();
        if (farmerType == 1){
            player1 = new FruitFarmer(name);
        }
        if (farmerType == 2){
            player1 = new GrainFarmer(name);
        }
        if (farmerType == 3){
            player1 = new VeggieFarmer(name);
        }
        while (player1.getCoins() < 100){
            day ++;
            System.out.println("~~~~~~~~ DAY " + day + " ~~~~~~~~");
            while (player1.getTurns() > 0){
                player1.printStatus();
                System.out.println("What will you do next? \n1 to plant \n2 to water \n3 to harvest \n4 to produce item \n5 to sell item");
                int move = input.nextInt();
                turn(move, player1);
            }
            stonksUp = false;
            daylightGivings = false;
            System.out.println("You are out of moves today. Great day of work! Goodnight.");
            nightmare();
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
            player1.sell(stonksUp);
        }
    }

    public static void nightmare(){
        int nightmareType = rand.nextInt(10) + 1;
        if (nightmareType == 1){
            System.out.println("A tornado visits your farm. All of your crops are gone. Your inventory is now size 0.");
            player1.emptyInventory();
        }
        if (nightmareType == 2){
            System.out.println("Overnight, the stonk market goes up. Tomorrow, your " + player1.getProduce() + " sells for double coins. Hooray!");
            stonksUp = true;
        }
        if (nightmareType == 3){
            int lossPercent = (rand.nextInt(5)+ 1) * 10;
            System.out.println("Jim the Mild Demon visits your farm and helps himself to some yummy coins. You lose " + lossPercent+ "% of your coins. Unfortunate.");
            player1.setCoins(player1.getCoins() * lossPercent*0.01);
        }
        if (nightmareType == 4){
            int lossPercent = (rand.nextInt(5)+ 6) * 10;
            System.out.println("Jennifer the Spicy Demon visits your farm. You lose " + lossPercent+ "% of your coins. Unfortunate.");
            player1.setCoins(player1.getCoins() * lossPercent*0.01);
        }
        if (nightmareType == 5){
            System.out.println("Mira the Chill Demon visits your farm. She takes 75% of your coins and buys a Gracie Abrams concert ticket. Thanks!");
            player1.setCoins(player1.getCoins() * 0.75);
        }
        if (nightmareType == 6){
            System.out.println("Jack the Hungry Demon visits your farm. He eats all of your plants. Your farm is now size 0.");
            player1.emptyFarm();
        }
        if (nightmareType == 7){
            int numLost = rand.nextInt(player1.getFarmSize());
            System.out.println("Jill the Angry Demon visits your farm. She eats " + numLost + " of your plants. ");
            player1.removeFarm(numLost);
        }
        if (nightmareType = 8){
            if (strangerHasCome){
                System.out.println("At night, the mysterious stranger returns and asks for more money. You refuse, so he beats you up and takes 10 coins.");
                player1.setCoins(player2.getCoins() - 10);
            }
            else { 
                System.out.println("At night, a mysterious injured stranger visits your farm. You pay 10 coins for his medical bills, and send him on his way.");
                player1.setCoins(player2.getCoins() - 10);
                strangerHasCome = true;
            }
        }
        if (nightmareType = 9){ 
            System.out.println("Congrats! You win 20 coins from a lottery somewhere.");
            player1.setCoins(player2.getCoins() + 20);
        }
        if (nightmareType = 10){
            System.out.println("Daylight gainings occurs. You get 2 extra moves tomorrow. Spend them wisely...");
            daylightGivings = true;
        }
    }       
}
