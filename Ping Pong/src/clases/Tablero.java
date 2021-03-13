
package clases;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Tablero extends JPanel{

    Raqueta R1 = new Raqueta(10,200);
    Raqueta R2 = new Raqueta(794-10-Raqueta.ANCHO,200);
    Pelota p = new Pelota();
    
    public Tablero(){
        this.setBackground(Color.BLACK);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        dibujarPuntaje(g2);
        draw(g2);

    }
    
    private void draw(Graphics2D g){
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());
        g.draw(linea);

        g.fill(R1.getRaqueta());
        update();
        g.fill(R2.getRaqueta());
        update();
        g.fill(p.getShape());
        update();

    }
    
    public void update(){
        p.move(getBounds(),colision(R1.getRaqueta()),colision(R2.getRaqueta()));
        R1.moverR1(getBounds());
        R2.moverR2(getBounds());
    }
    
    private boolean colision(Rectangle2D r){
        return p.getShape().intersects(r);
    }
    
    public void dibujarPuntaje(Graphics2D g){
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        
        g1.drawString(Integer.toString(p.getScore1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(p.getScore2()), (float) getBounds().getCenterX() + 25, 30);
        
        if(p.getScore1() == 5){
            g.drawString("GANÓ EL JUGADOR 1", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
        if(p.getScore2() == 5){
            g.drawString("GANÓ EL JUGADOR 2", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
    }
    
    public void iGame(){
        while(true){
            repaint();
            try {
                Thread.sleep(6);
            } catch (Exception ex) {
                Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
