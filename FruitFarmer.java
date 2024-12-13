class FruitFarmer extends Farmer{
  public FruitFarmer(String name){
    super(name);
    System.out.println ("You start your journey at Nightmare Farm as a fruit farmer. Your goal is to earn 100 coins and escape the farm.");
    System.out.println ("Each turn, you will have 5 moves. You can use one move to plant one apple seed, water all of your seeds once, harvest one ripe apple, create one apple pie, or sell one apple pie.");
    System.out.println ("At the end of each turn, a nightmare will happen. Have fun!");
  }
  public String getCrop(){
    return "apple";
  }
  public String getProduce(){
    return "pie";
  }
}
  
