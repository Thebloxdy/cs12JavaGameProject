/* ShipEntity.java
 * March 27, 2006
 * Represents player's ship
 */
public class ShipEntity extends Entity {

  private Game game; // the game in which the ship exists

  /* construct the player's ship
   * input: game - the game in which the ship is being created
   *        ref - a string with the name of the image associated to
   *              the sprite for the ship
   *        x, y - initial location of ship
   */
  public ShipEntity(Game g, String r, int newX, int newY) {
    super(r, newX, newY);  // calls the constructor in Entity
    game = g;
  } // constructor

  /* move
   * input: delta - time elapsed since last move (ms)
   * purpose: move ship 
   */
  public void move (long delta){
    // stop at left side of screen
    if ((dx < 0) && (x < 10)) {
      return;
    } // if
    // stop at right side of screen
    if ((dx > 0) && (x > 750)) {
      return;
    } // if
    
    /*if ((dy < 0 ) && (y < 10))
    	return;
    */
    if ((dy > 0) && (y > 500) )
    	return;
    super.move(delta);  // calls the move method in Entity
  } // move
  
  public void gravity() {
	  System.out.println(this.getVerticalMovement());
	  if (this.getVerticalMovement() <= 2) {
		  this.setVerticalMovement(2);
		  return;
	  }
	  if (this.y > 500) {
		  this.y = 500;
		  return;
	  }
	  this.setVerticalMovement(this.getVerticalMovement() * 1.3);
  }
  
  
  /* collidedWith
   * input: other - the entity with which the ship has collided
   * purpose: notification that the player's ship has collided
   *          with something
   */
   public void collidedWith(Entity other) {
     if (other instanceof AlienEntity) {
        game.notifyDeath();
     } // if
   } // collidedWith    

} // ShipEntity class