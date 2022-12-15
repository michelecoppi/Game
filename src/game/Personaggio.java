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
public class Personaggio extends Component{
    private int x;
    private int y;
    private int speed;
    private int width=376;
    private int heigth=353;
    private int bordo=10;
    public int size;
    private Color color;
    
    public Personaggio(int x,int y,int speed){
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.size=10;
        this.color=Color.black;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
       
    
    public void moveUp(){
        y-=speed;
       if (y<bordo){
           y=bordo;
         }
    }
    
      public void moveDown(){
        y+=speed;
        if(y>heigth-10){
        y=heigth-10;
        }
    }
      
       public void moveLeft(){
        x-=speed;
        if (x<bordo){
           x=bordo;
         }
    }
    
         public void moveRight(){
        x+=speed;
        if(x>width-10){
        x=width-10;
        }
    }
         public void drawCharachter(Graphics g){
             g.setColor(this.color);
             g.fillRect(x, y, size, size);
         }
         
         
    // altri campi e metodi...

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
       
    }
    
 
}

         
         

