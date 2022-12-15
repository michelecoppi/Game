/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.*;

/**
 *
 * @author Super
 */
public class Traguardo extends Component{
    private int x;
    private int y;
    private int width;
    private int heigth;

    public Traguardo(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.heigth = 10;
    }
    
     public void draw(Graphics g){
             g.setColor(Color.green);
             g.fillRect(x, y, width, heigth);
            
         }

    @Override
    public Rectangle getBounds() {
     return new Rectangle(x, y, width, heigth); 
    }
     
     
    
}
