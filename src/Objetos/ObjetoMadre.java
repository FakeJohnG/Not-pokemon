package Objetos;

import Notpokemon.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjetoMadre {
    public BufferedImage imagen;
    public String nombre;
    public boolean collisionOn =false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int areaSolidaDefaultX=0;
    public int areaSolidaDefaultY=0;

    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX =worldX-gamePanel.jugador.worldX + gamePanel.jugador.screenX;
        int screenY=worldY-gamePanel.jugador.worldY + gamePanel.jugador.screenY;
        //Mejora de rendimiento?
        if(worldX + gamePanel.tileSize>gamePanel.jugador.worldX-gamePanel.jugador.screenX &&
                worldX- gamePanel.tileSize <gamePanel.jugador.worldX+gamePanel.jugador.screenX &&
                worldY + gamePanel.tileSize>gamePanel.jugador.worldY- gamePanel.jugador.screenY &&
                worldY - gamePanel.tileSize<gamePanel.jugador.worldY+ gamePanel.jugador.screenY){
            g2.drawImage(imagen,screenX,screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }

}
