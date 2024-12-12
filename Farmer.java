// Collaborators:
import java.util.*;

public abstract class Farmer{
  private String name;
  private int coins;
  private ArrayList<Integer> farm = ArrayList<Integer>();
  private ArrayList<String> inv = ArrayList<String>();
  private String type;
  private int turns = 5;

  /*There is no no-arg constructor. Be careful with your subclass constructors.*/
  
  public Farmer(String name){
    this.name = name;
    this.coins = 0;
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

  public abstract String getCrop();
  public abstract String getProduce();

  public void plant(){
    farm.add(0);
    turns -= 1;
    System.out.println("You planted one " + this.getCrop() + ".");
  }
  
  public void water(){
    for (int i = 0; i < farm.getSize(); i++){
      farm.set(i, farm.get(i)+1);
    }
    turns -= 1;
    System.out.println("You watered all your" + this.getCrop()+ "s.");
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

  public void sell(){
    int produceInd = -1;
    for (int i = 0; i< inv.size(); i++){
      if (inv.get(i).equals(this.getProduce())){
        produceInd = i;
        break;
      }
    }
    if (ripeInd != 
  
}
