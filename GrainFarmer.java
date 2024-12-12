class GrainFarmer implements Farmer{
  public GrainFarmer(String name){
    super(name);
  }
  public String getCrop(){
    return "wheat";
  }

  public String getProduce(){
    return "bread";
  }
}
