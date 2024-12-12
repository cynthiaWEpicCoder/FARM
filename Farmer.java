// Collaborators:
import java.util.*;

public abstract class Farmer{
  private String name;
  private int coins;
  private ArrayList<Integer> inv = ArrayList<Integer>();
  private String type;

  /*There is no no-arg constructor. Be careful with your subclass constructors.*/
  
  public Farmer(String name, String type){
    this.name = name;
    this.coins = 0;
    this.type = type;
  }

  
}
