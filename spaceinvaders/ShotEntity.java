/* ShotEntity.java
 * March 27, 2006
 * Represents player's ship
 */
public class ShotEntity extends Entity {

  private double moveSpeed = -300; // vert speed shot moves
  private boolean used = false; // true if shot hits something
  private Game game; // the game in which the ship exists

  /* construct the shot
   * input: game - the game in which the shot is being created
   *        ref - a string with the name of the image associated to
   *              the sprite for the shot
   *        x, y - initial location of shot
   */
  public ShotEntity(Game g, String r, int newX, int newY) {
    super(r, newX, newY);  // calls the constructor in Entity
    game = g;
    dy = moveSpeed;
  } // constructor
  
  public ShotEntity(Game g, String r, int newX, int newY, double dx, double dy) {
	    super(r, newX, newY);  // calls the constructor in Entity
	    game = g;
	    dy = dy;
	    dx = dx;
	  } // constructor

  /* move
   * input: delta - time elapsed since last move (ms)
   * purpose: move shot
   */
  public void move (long delta){
     // calls the move method in Entity
    // if shot moves off top of screen, remove it from entity list
    if (y < -100) {
      game.removeEntity(this);
    } // if

  } // move
  
  public void move(int shipX, int shipY, int turretX, int turretY,  long delta) {
	  	
		double diffX = shipX - turretX;
		double diffY = shipY - turretY;
		double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
		
		dx = (diffX / distance) * delta;
	    dy = (diffY / distance) * delta;
	    
	    super.move(delta);
		if (y < -100) {
		      game.removeEntity(this);
		} // if
	}


  /* collidedWith
   * input: other - the entity with which the shot has collided
   * purpose: notification that the shot has collided
   *          with something
   */
   public void collidedWith(Entity other) {
     // prevents double kills
     if (used) {
       return;
     } // if
     
     // if it has hit an alien, kill it!
     if (other instanceof AlienEntity) {
       // remove affect entities from the Entity list
       game.removeEntity(this);
       game.removeEntity(other);
       
       // notify the game that the alien is dead
       game.notifyAlienKilled();
       used = true;
     } // if

   } // collidedWith

} // ShipEntity class