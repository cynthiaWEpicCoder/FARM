public class Driver{
    public static void main (String[] args){
        Farmer player1 = new FruitFarmer ("Aud");
        player1.plant();
        player1.water();
        player1.water();
        System.out.println(player1.getFarm);
        player1.harvest();
        System.out.println(player1.getInv());
        player1.produce();
        System.out.println(player1.getInv());
        player1.sell();
        System.out.println(player1.getInv());
        System.out.println(player1.getCoins());
    }
}
