// Collaborators:
import java.util.*;

public abstract class Farmer{
  private String name;
  private int coins;
  private ArrayList<Integer> inv = ArrayList<Integer>();
  private String type;

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
}
