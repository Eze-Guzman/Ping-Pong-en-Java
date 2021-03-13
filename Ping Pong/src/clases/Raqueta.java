
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raqueta {
    
    private int x, y;
    static final int ANCHO = 10, ALTO = 40;
    
    public Raqueta(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x,y,ANCHO,ALTO);
    }
    
    public void moverR1(Rectangle limites){
        if(EventosTeclado.w && y > limites.getMinY()){
            y--;
        }
        if(EventosTeclado.s && y < limites.getMaxY()-ALTO){
            y++;
        }
    }
    public void moverR2(Rectangle limites){
        if(EventosTeclado.up && y > limites.getMinY()){
            y--;
        }
        if(EventosTeclado.down && y < limites.getMaxY()-ALTO){
            y++;
        }
    }
}
