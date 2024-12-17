import java.util.*;

public class Game{
    static int day = 0;
    static boolean stonksUp = false;
    static boolean daylightGivings = false;
    static Random rand = new Random();
    static boolean strangerHasCome = false;
    static Farmer player1;
    public static void main (String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println ("Type 911 to quit the game. \nHello " + name + ", and welcome to Nightmare Farm! You used to be a student at Stuyvesant High School, but then one day you were taken away. You're not quite sure what happened, but now you're here, and you want to leave as fast as possible.");
        System.out.println ("Unfortunately, the only way to escape is through the Super-Duper-Rico Train, which for some reason costs 100 gold coins. To make money, you need to work. The Super-Duper-Rico station opens every day at midnight, but at Nightmare Farm, something happens every day at 11 PM...");
        System.out.println ("What type of farmer will you be? \n1 for fruit farmer \n2 for grain farmer \n3 for veggie farmer");
        int farmerType = -1;
        while (farmerType == -1){
            try{ 
                farmerType = input.nextInt();
                if (farmerType < 1 || farmerType > 3){
                    farmerType = -1;
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Invalid response. Try again.");
                input.nextLine();
                continue;
            }
        }
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
                int move;
                player1.printStatus();
                try{
                System.out.println("What will you do next? \n1 to plant \n2 to water (water twice to ripen!) \n3 to harvest  \n4 to produce item \n5 to sell item"); 
                input.nextLine();
                move = input.nextInt();
                }catch (Exception e){
                    System.out.println("Invalid response. Try again.");  
                    continue;
                }
                if (move == 911){
                    System.exit(0);
                }
                turn(move);
                System.out.println();
            }
            stonksUp = false;
            daylightGivings = false;
            nightmare();
            System.out.println("Great day of work! These are your stats by the end of the day: ");
            player1.printStatus();
            player1.setTurns(5);
            if (daylightGivings){
                player1.setTurns(7);
            } 
            System.out.println();
        }
        System.out.println("You collected " + player1.getCoins() + " coins and bought a ticket home in " + day + " days.");
        System.out.println ("You take a seat on the Super-Duper-Rico train and breathe out a sigh of relief. The train hurtles out of the station, and you watch Nightmare Farm disappear into the distance outside the window. Soon enough, the steady jostling of the train puts you into a deep sleep, and hours later, you open your eyes to find that you are back in the comfort of your bed, safe within your home. Murky memories of a farm, and demons, and annoying mysterious men start to surface, but they fade quickly as you turn over and go back to sleep. What a strange dream! Or was it?");
    }
    public static void turn(int turnType){
        if (turnType == 1){
            player1.plant();
        }
        else if (turnType == 2){
            player1.water();
        }
        else if (turnType == 3){
            player1.harvest();
        }
        else if (turnType == 4){
            player1.produce();
        }
        else if (turnType == 5){
            player1.sell(stonksUp);
        }
        else {
            System.out.println ("Invalid input");
        }
    }

    public static void nightmare(){
        int nightmareType = rand.nextInt(22) + 1;
        if (1 <= nightmareType && nightmareType <= 3){
            System.out.println("Last night, a tornado visits your farm. Your farmhouse is in pieces. Your inventory is now size 0.");
            player1.emptyInventory();
        }
        if (nightmareType == 4){
            System.out.println("Overnight, the stonk market goes up. Tomorrow, your " + player1.getProduce() + " sells for double coins. Hooray!");
            stonksUp = true;
        }
        if (5 <= nightmareType && nightmareType <= 7){
            int lossPercent = (rand.nextInt(5)+ 1) * 10;
            System.out.println("At night, Jim the Mild Demon visits your farm and helps himself to some yummy coins. You lose " + lossPercent+ "% of your coins. Unfortunate.");
            player1.setCoins((int) Math.round(player1.getCoins() * (1-lossPercent*0.01)));
        }
        if (8 <= nightmareType && nightmareType <= 10){
            int lossPercent = (rand.nextInt(5)+ 6) * 10;
            System.out.println("At night, Jennifer the Spicy Demon visits your farm. You lose " + lossPercent+ "% of your coins. Unfortunate.");
            player1.setCoins((int) Math.round(player1.getCoins() * (1-lossPercent*0.01)));
        }
        if (nightmareType == 11){
            System.out.println("At night, Mira the Chill Demon visits your farm. She takes 25% of your coins and buys a Gracie Abrams concert ticket. Thanks!");
            player1.setCoins((int) Math.round(player1.getCoins() * 0.75));
        }
        if (12 <= nightmareType && nightmareType <= 14){
            System.out.println("At night, Jack the Hungry Demon visits your farm. He eats all of the crops from your farm. Yum! Your farm is now size 0...");
            player1.emptyFarm();
        }
        if (15 <= nightmareType && nightmareType <= 17){
            if (player1.getFarmSize() == 0){
                System.out.println("At night, Jill the Angry Demon visits your farm. She was hoping to take a little snack from your farm, but it was empty so she left hangry. How disappointing.");
            }
            else{ 
                int numLost = rand.nextInt(player1.getFarmSize())+1;
                System.out.println("At night, Jill the Angry Demon visits your farm. She eats " + numLost + " of your plants from your farm. ");
                player1.removeFarm(numLost);
            }
        }
        if (18 <= nightmareType && nightmareType <= 20){
            if (strangerHasCome){
                if (player1.getCoins() >= 10){
                    System.out.println("At night, the mysterious stranger returns and asks for more money. You refuse, so he beats you up and takes 10 coins.");
                    player1.setCoins((int) Math.round(player1.getCoins() - 10));
                }
                else {
                    System.out.println ("At night, the mysterious stranger returns and asks for more money. You show him your utterly empty wallet, and he feels so bad for you that he donates you 1 coin.");
                    player1.setCoins (player1.getCoins() + 1);
                }
            }
            else { 
                if (player1.getCoins() >= 10) {
                    System.out.println("At night, a mysterious injured stranger visits your farm. You pay 10 coins for his medical bills, and send him on his way.");
                    player1.setCoins((int) Math.round(player1.getCoins() - 10));
                    strangerHasCome = true;
                }
                else {
                    System.out.println ("At night, a mysterious injured stranger visits your farm, asking for 10 coins for medical treatment. You show him your utterly empty wallet, and he feels so bad for you that he donates you 1 coin.");
                    player1.setCoins (player1.getCoins() + 1);
                }
            }
        }
        if (nightmareType == 21){ 
            System.out.println("At night, a mysterious lottery ticket appears in your mailbox. You check the winning numbers and you won 20 coins!");
            player1.setCoins((int) Math.round(player1.getCoins() + 20));
        }
        if (nightmareType == 22){
            System.out.println("You wake up oddly early to the sun in your face. Daylight gainings is today! You get 2 extra moves. Spend them wisely...");
            daylightGivings = true;
        }
    }       
}
