
package model;

import java.awt.Color;
import java.awt.Graphics;

public class Linea {
    private int x1,y1,x2,y2;

    public Linea(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void pintarLinea(Graphics g){
        g.setColor(Color.BLUE);
        g.drawLine(x1, y1, x2, y2);
    }
    
    
}
