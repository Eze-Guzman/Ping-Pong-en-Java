
package clases;

import ObtenerRecursos.Audio;
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;


public class Pelota {
     private static final int TAMX = 15;
     private static final int TAMY = 15;
     private double x = 0;
     private static double y = 0;
     private double dx = 1;
     private double dy = 1;
     
     public Integer score1 = 0, score2 = 0;
     public static boolean finJuego = false;
     
        Audio audio = new Audio();
        AudioClip rebote_1 = audio.getAudio("/Recursos/rebote_pelota1.wav");
        AudioClip rebote_2 = audio.getAudio("/Recursos/rebote_pelota2.wav");
        AudioClip falta    = audio.getAudio("/Recursos/falta.wav");
        
     public Rectangle2D getShape(){
         return new Rectangle2D.Double(x,y,TAMX,TAMY);
     }
     
     public void move(Rectangle limites, boolean colisionR1, boolean colisionR2){
         x += dx;
         y += dy;
         
         if(colisionR1){
             dx = -dx;
             x = 20;
             rebote_1.play();
         }
         if(colisionR2){
             dx = -dx;
             x = 755;
             rebote_1.play();
         }
         if(x < limites.getMinX()){
             score2++;
             
             x = limites.getCenterX();
             y = limites.getCenterY();
             dx = -dx;
             falta.play();
         }
         
         if(x + TAMX >= limites.getMaxX()){
             score1++;
             
             x = limites.getCenterX();
             y = limites.getCenterY();
             dx = -dx;
             audio.getAudio("/recursos/falta.wav").play();
         }
         
         if(y < limites.getMinY()){
             
             y = limites.getMinY();
             
             dy = -dy;
             rebote_2.play();
         }
         
         if(y + TAMY >= limites.getMaxY()){
             
             y = limites.getMaxY() - TAMY;
             
             dy = -dy;
             rebote_2.play();
         }
         
     }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}
