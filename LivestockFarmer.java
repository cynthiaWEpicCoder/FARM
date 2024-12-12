class VeggieFarmer implements Farmer{
  public VeggieFarmer(String name){
    super(name);
  }
  public String getCrop(){
    return "lettuce";
  }

  public String getProduce(){
    return "salad";
  }
}
