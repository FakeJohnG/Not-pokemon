package Entidades;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
 public int worldX, worldY;
 public int speed;
 public int frameIndex = 0;
 public int frameCounter = 0;
 public double frameDelay =0.1;
 public String direction;
 public Rectangle solidBox;
 public boolean collisionOn=false;

 public BufferedImage[] idleFrames;
 public BufferedImage[] upFrames;
 public BufferedImage[] downFrames;
 public BufferedImage[] leftFrames;
 public BufferedImage[] rightFrames;


}
