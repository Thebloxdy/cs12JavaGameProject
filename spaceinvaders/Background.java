/* Background.java
 * Creates an scrolling background.
 * Modified from - https://www.nutt.net/create-scrolling-background-java/
 * this version requires a 1920x1080 horizonally tiled image called
 * background.jpg saved in the same folder as the class files. 
 * This may be changed.
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Background {
	  private Image image; //backgroud image
	  private Game game; // the game in which the alien exists
    private int x; //x coordinate
    private int y; //y coordinate
    public boolean atBottom;

 
    //constructor
    public Background(Game g) {
        this(g,0,0);
    }//Background
 
    //initializes constructor
    public Background(Game g, int x, int y) {
        this.x = x;
        this.y = y;
 
        // try to open the background image file 
        try {
        	image = ImageIO.read(getClass().getClassLoader().getResource("bg1.png"));
        	System.out.println("here1");
        	draw(image.getGraphics());
        }
        catch (Exception e) { System.out.println(e); }
 
    }//Background
 
   	//method that draws the image onto the Graphics object passed
    public void draw(Graphics window) {
        //draw the image onto the Graphics reference
        window.drawImage(image, getX(), getY(), 1920, 15360, null);
 
        //move the x position left for next time
        this.y -= 18;
 
        //check to see if the image has gone off stage left
        if (this.x <= -1080) {
 
            //if it has, line it back up so that its left edge is lined up to the right side of the other background image
            this.x = this.y + 1080 * 2;
        }//if
 
    }//draw
   
    public void draw(Graphics window, double i ) {
    	
    	 window.drawImage(image, getX(), getY(), 1920, 15360, null);
    	 
    	 if (i == 1.0){
    		 //not moving
    		 return;
    	}
    	 
    	 if (i == 2.0) {
    		 //down
    		 this.y += 12;
    		 atBottom = false;
	    	 if (this.y >= 1080) {
	    		 this.y = -1080;
	    	 }
	    	 return;
    	 }
    	 if ( i == 0.0) {
    		 //up
	    	 this.y -= 12;
	    	 atBottom = false;
	    	 if (this.y <= -1 * (15360 - 1080)) {
	    		 this.y = -1 * (15360 - 1080);
	    		 atBottom = true;
	    		 return;
	    	 }
    	 }
    	 /*if (i == 3.0) {
    		 //sidesway right
    		 this.x += 12;
    		 
    		 if (this.x >= 1920) {
    			 this.x = - 1920;
    		 }
    		 return;
    	 }
    	 if (i == 4.0) {
    		 //sidesway left
    		 this.x -= 12;
    		 
    		 if (this.x <= -1920) {
    			 this.x =  1920;
    		 }
    		 return;
    	 }*/
    	 
    }
   
 
    public void setX(int x) {
        this.x = x;
    }//setX
    public int getX() {
        return this.x;
    }//getX
    public int getY() {
        return this.y;
    }//getY
    public int getImageWidth() {
        return 1920;
    }//getImageWidth
    
}//class Background