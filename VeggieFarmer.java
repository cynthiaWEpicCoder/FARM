class VeggieFarmer extends Farmer{
  public VeggieFarmer(String name){
    super(name);
    super.printMsg();
    System.out.println ("You start your journey at Nightmare Farm as a veggie farmer. Your goal is to earn 100 coins and escape the farm.");
    System.out.println ("Each turn, you will have 5 moves. You can use one move to plant one spinach plant, water all of your plants once, harvest one ripe spinach, create one salad, or sell one salad.");
    System.out.println ("At the end of each turn, a nightmare will happen. Have fun!");
  }
  public String getCrop(){
    return "lettuce";
  }

  public String getProduce(){
    return "salad";
  }
}
