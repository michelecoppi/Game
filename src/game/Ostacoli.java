/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.*;

/**
 *
 * @author michele2306
 */
public class Ostacoli extends Component{
     private int x;
     private int y;
     private int width;
     private int heigth;

    public Ostacoli(int x, int y) {
        this.x = x;
        this.y = y;
        this.width=10;
        this.heigth=10;
    }
    
      public Ostacoli(int x, int y,int width,int heigth) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.heigth=heigth;
    }
     
        public void draw(Graphics g){
             g.setColor(Color.red);
             g.fillRect(x, y, width, heigth);
            
         }
        

    // altri campi e metodi...

  public boolean checkCollisionTop(Personaggio player) {
    // Calculate the x and y coordinates of the player's top edge
    int playerMinX = player.getX();
    int playerMaxX = player.getX() + player.size;
    int playerMinY = player.getY();
    int playerMaxY = player.getY() + player.size;

    // Calculate the x and y coordinates of the obstacle's bottom edge
    int obstacleMinX = x;
    int obstacleMaxX = x + width;
    int obstacleMinY = y;
    int obstacleMaxY = y + heigth;

    // If the player's top edge is at the same y-coordinate as the obstacle's bottom edge,
    // and the x-coordinates of the player and the obstacle overlap, there is a collision
    return playerMinY == obstacleMaxY && playerMinX < obstacleMaxX && playerMaxX > obstacleMinX;
}

  
 public boolean checkCollisionRight(Personaggio player) {
    // Calculate the x and y coordinates of the player's right edge
    int playerMinX = player.getX();
    int playerMinY = player.getY();
    int playerMaxY = player.getY() + player.size;
    int playerMaxX = player.getX() + player.size;

    // Calculate the x and y coordinates of the obstacle's left edge
    int obstacleMinX = x;
    int obstacleMinY = y;
    int obstacleMaxY = y + heigth;
    int obstacleMaxX = x + width;

    // If the player's right edge is at the same x-coordinate as the obstacle's left edge,
    // and the y-coordinates of the player and the obstacle overlap, there is a collision
    return playerMaxX == obstacleMinX && playerMinY < obstacleMaxY && playerMaxY > obstacleMinY;
}

public boolean checkCollisionLeft(Personaggio player) {
    // Calculate the x and y coordinates of the player's left edge
    int playerMinX = player.getX();
    int playerMinY = player.getY();
    int playerMaxY = player.getY() + player.size;
    int playerMaxX = player.getX() + player.size;

    // Calculate the x and y coordinates of the obstacle's right edge
    int obstacleMinX = x;
    int obstacleMinY = y;
    int obstacleMaxY = y + heigth;
    int obstacleMaxX = x + width;

    // If the player's left edge is at the same x-coordinate as the obstacle's right edge,
    // and the y-coordinates of the player and the obstacle overlap, there is a collision
    return playerMinX == obstacleMaxX && playerMinY < obstacleMaxY && playerMaxY > obstacleMinY;
}

public boolean checkCollisionBottom(Personaggio player) {
    // Calculate the x and y coordinates of the player's bottom edge
    int playerMinX = player.getX();
    int playerMaxX = player.getX() + player.size;
    int playerMinY = player.getY();
    int playerMaxY = player.getY() + player.size;

    // Calculate the x and y coordinates of the obstacle's top edge
    int obstacleMinX = x;
    int obstacleMaxX = x + width;
    int obstacleMinY = y;
    int obstacleMaxY = y + heigth;

    // If the player's bottom edge is at the same y-coordinate as the obstacle's top edge,
    // and the x-coordinates of the player and the obstacle overlap, there is a collision
    return playerMaxY == obstacleMinY && playerMinX < obstacleMaxX && playerMaxX > obstacleMinX;
}

}


     

