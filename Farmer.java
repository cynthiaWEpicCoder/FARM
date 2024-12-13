// Collaborators:
import java.util.*;

public abstract class Farmer{
  private String name;
  private int coins;
  private ArrayList<Integer> farm = new ArrayList<Integer>();
  private ArrayList<String> inv = new ArrayList<String>();
  private String type;
  private int turns = 5;

  /*There is no no-arg constructor. Be careful with your subclass constructors.*/
  
  public Farmer(String name){
    this.name = name;
    this.coins = 0;
  }

  public void printMsg (){
    System.out.println ("Hello __, and welcome to Nightmare Farm! You used to be a student at Stuyvesant High School, but then one day you were taken away. You're not quite sure what happened, but now you're here, and you want to leave as fast as possible.");
    System.out.println ("Unfortunately, the only way to escape is through the Super-Duper-Rico Train, which for some reason costs 100 gold coins. To make money, you need to work.");
    System.out.println ("What type of farmer will you be? \n1 for fruit farmer \n2 for grain farmer \n3 for veggie farmer");
  }
  public String getName (){
    return name;
  }

  public int getCoins (){
    return coins;
  }

  public ArrayList getInventory (){
    return inv;
  }

  
  public void setName (String newName){
    name = newName;
  }

  public void setCoins (int newCoins){
    coins = newCoins;
  }

  public String getInv(){
    return inv.toString();
  }

  public String getFarm(){
    return farm.toString();
  }

  public int getTurns(){
    return turns;
  }

  public void setTurns (int newTurns){
    turns = newTurns;
  }

  public abstract String getCrop();
  public abstract String getProduce();

  public void plant(){
    farm.add(0);
    turns -= 1;
    System.out.println("You planted one " + this.getCrop() + ".");
  }
  
  public void water(){
    for (int i = 0; i < farm.size(); i++){
      farm.set(i, farm.get(i)+1);
    }
    turns -= 1;
    System.out.println("You watered all your " + this.getCrop()+ "s.");
  }

  public void harvest(){
    int ripeInd = -1;
    for (int i = 0; i < farm.size(); i++){
      if (farm.get(i) >= 2){
        ripeInd = i;
        break;
      }
    }
    if (ripeInd == -1){
      System.out.println("You tried to harvest your crops but none were ripe.");
      turns -= 1;
    }
    if (ripeInd != -1){
      farm.remove(ripeInd);
      inv.add("Ripe " + this.getCrop());
      turns -= 1;
    }
  }

  public void produce(){
    int ripeInd = -1;
    for (int i = 0; i < inv.size(); i++){
      if (inv.get(i).equals("Ripe " + this.getCrop())){
        ripeInd = i;
        break;
      }
    }
    if (ripeInd == -1){
      System.out.println("You tried to produce a " + this.getProduce() + " but realized you had no ripe " + this.getCrop() + ".");
      turns -= 1;
    }
    if (ripeInd != -1){
      inv.remove(ripeInd);
      inv.add(this.getProduce());
      turns -= 1;
      System.out.print("You used a ripe " + this.getCrop() + " to produce a " + this.getProduce() + ".");
    }
  }
  
  public void sell(){
    int produceInd = -1;
    for (int i = 0; i< inv.size(); i++){
      if (inv.get(i).equals(this.getProduce())){
        produceInd = i;
        break;
      }
    }
    if (produceInd == -1){
      System.out.println("You went to the market to sell your goods but realized you had none.");
      turns -= 1;
    }
    if (produceInd != -1){
      inv.remove(produceInd);
      coins += 10;
      turns -= 1;
      System.out.println("You went to the market and sold a " + this.getProduce() + ".");
    }
  }
  
}
