class LivestockFarmer implements Farmer{
  public FruitFarmer(String name){
    super(name);
  }
  public String getCrop(){
    return "milk";
  }

  public String getProduce(){
    return "cheese";
  }
}
