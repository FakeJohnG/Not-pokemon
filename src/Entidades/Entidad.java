package Entidades;

import Notpokemon.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entidad {
 GamePanel gamePanel;
 public int worldX, worldY;
 public int speed;
 public int frameIndex = 0;
 public int frameCounter = 0;
 public double frameDelay = 0.1;
 public String direction;
 public Rectangle solidBox=new Rectangle(0,0,48,48);
 public int areaSolidaDefaultX, areaSolidaDefaultY;
 public boolean collisionOn=false;
 public int contAccion=0;

 public BufferedImage[] idleFrames;
 public BufferedImage[] upFrames;
 public BufferedImage[] downFrames;
 public BufferedImage[] leftFrames;
 public BufferedImage[] rightFrames;

 public Entidad(GamePanel gamePanel){
  this.gamePanel=gamePanel;

 }
 public void setComportamiento(){

 }
 public void update(){
  setComportamiento();
  //Sistema de collision
  collisionOn=false;
  gamePanel.managerC.checkTile(this);
  if(collisionOn==false){
   switch(direction){
    case"up":worldY -=speed;break;
    case"down":worldY +=speed;break;
    case"right":worldX +=speed;break;
    case"left":worldX -=speed;break;
   }
  }
  gamePanel.eventos.checkEvento();
  //Sistema para usar los otros frames
  frameCounter++;
  if (frameCounter > frameDelay) {
   frameIndex++;
   frameCounter = 0;
  }else{
   frameIndex=0;
  }



 }
 public void draw(Graphics2D g2){
  BufferedImage image=null;
  int screenX =worldX-gamePanel.player.worldX + gamePanel.player.screenX;
  int screenY=worldY-gamePanel.player.worldY + gamePanel.player.screenY;
  //Mejora de rendimiento?
  if(worldX + gamePanel.tileSize>gamePanel.player.worldX-gamePanel.player.screenX &&
          worldX- gamePanel.tileSize <gamePanel.player.worldX+gamePanel.player.screenX &&
          worldY + gamePanel.tileSize>gamePanel.player.worldY- gamePanel.player.screenY &&
          worldY - gamePanel.tileSize<gamePanel.player.worldY+ gamePanel.player.screenY){
   switch(direction){
    case "up":
     image= upFrames[frameIndex % upFrames.length];
     break;
    case "right":
     image=rightFrames[frameIndex % rightFrames.length];
     break;
    case "down":
     image= downFrames[frameIndex % downFrames.length];
     break;
    case "left":
     image= leftFrames[frameIndex % leftFrames.length];
     break;
    case "idle":
     image= idleFrames[frameIndex % idleFrames.length];
     break;
   }
   g2.drawImage(image,screenX,screenY, gamePanel.tileSize, gamePanel.tileSize, null);
  }

 }


}
