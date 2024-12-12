class GrainFarmer implements Farmer{
  public GrainFarmer(String name){
    super(name);
    System.out.println ("You start your journey at Nightmare Farm as a grain farmer. Your goal is to earn 100 coins and escape the farm.");
    System.out.println ("Each turn, you will have 5 moves. You can use one move to plant one grain, water all of your seeds once, harvest one wheat, create one bread, or sell one bread.");
    System.out.println ("At the end of each turn, a nightmare will happen. Have fun!");
  }
  public String getCrop(){
    return "wheat";
  }

  public String getProduce(){
    return "bread";
  }
}
