
package clases;

import javax.swing.*;

import Control.EngineGraphics;

public class Ventana extends JFrame{
    
    Tablero canvas;
    Pelota p = new Pelota();
    
    public Ventana(){
        setTitle("PING PONG");
        setSize(800,500);
        setLocationRelativeTo(null);
        setResizable(false);
        canvas = new Tablero();
        add(canvas);
        
        addKeyListener(new EventosTeclado());
        new EngineGraphics(canvas).start();
        

    }

}
