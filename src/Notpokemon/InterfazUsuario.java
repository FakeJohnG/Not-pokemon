package Notpokemon;

import Objetos.Gema;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InterfazUsuario {
    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40;
    BufferedImage imagenGema;

    public InterfazUsuario(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        this.arial_40=new Font("Arial",Font.BOLD,20);
        Gema gema=new Gema();
        imagenGema= gema.imagen;
    }
    public void draw(Graphics2D g2){
        if(gamePanel.objetivoStatus==1){
            g2.setFont(arial_40);
            g2.setColor(Color.black);
            g2.drawImage(imagenGema,gamePanel.tileSize/2,gamePanel.tileSize/2,gamePanel.tileSize,gamePanel.tileSize,null);
            g2.drawString("Gemas X "+gamePanel.player.cantMcguffin,50,50);


        }
        if(gamePanel.gameState==gamePanel.pauseState){
            g2.setFont(arial_40);
            g2.setColor(Color.black);
            g2.drawString("===Pausa===",320,250);
        }


    }

}
