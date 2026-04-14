
public class PlatformEntity extends Entity{
	
	 private Game game;
	  public PlatformEntity(Game g, String r, int newX, int newY) {
		    super(r, newX, newY);  // calls the constructor in Entity
		    game = g;
	  } // constructor
	  @Override
	  public void collidedWith(Entity other) {
		// TODO Auto-generated method stub
		
	  }

}
