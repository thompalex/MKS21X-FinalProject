public class Player extends Creature{
  private int babiesToCollect; //Will always satrt at 3 or more
  private int babiesCollected; //Will always staart at 0
  public Player(int h, int d, int x, int y, String n, char graph, int babiesToCollect){
    super(h, d, x, y, n, graph);//defines inherited variables
    this.babiesToCollect = babiesToCollect;
    babiesCollected = 0;
  }
  //getMethod for babiesCollected and babiesToCollect
  public int getBabiesCollected(){
    return babiesCollected;
  }
  public int getBabiesToCollect(){
    return babiesToCollect;
  }
  //Changes variables when baby is picked up
  public void pickUpBaby(){
    babiesToCollect--;
    babiesCollected++;
  }
}
