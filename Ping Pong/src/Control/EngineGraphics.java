
package Control;

import clases.Pelota;
import clases.Tablero;

public class EngineGraphics extends Thread{
    
    private final Tablero canvas;
    
    public EngineGraphics(Tablero canvas){
        this.canvas = canvas;
    }
    
    @Override
    public void run(){
        while(!Pelota.finJuego){
            canvas.repaint();
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                System.out.println("error in graphics engine: "+ex.getMessage());
            }
        }
    }
}

