package Entidades;

import Notpokemon.GamePanel;
import Notpokemon.Inputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    Inputs input;
    public final int screenX;
    public final int screenY;


    public Player(GamePanel gamePanel,Inputs input){
        this.gamePanel=gamePanel;
        this.input=input;
        screenX= gamePanel.screenWidth/2 -(gamePanel.tileSize/2);
        screenY= gamePanel.screenHeight/2 -(gamePanel.tileSize/2);

        setDefautValues();
        getPlayerImage();
    }
    public void setDefautValues(){
        //Posicion default de jugador en mapa
        worldX =7; //gamePanel.tileSize*23;
        worldY =6;//gamePanel.tileSize*21;
        speed=5;
        direction="idle";
    }
    public void getPlayerImage(){
        try{
            rightFrames = new BufferedImage[12];
            for (int i = 0; i < rightFrames.length; i++) {
                rightFrames[i] = ImageIO.read(getClass().getResourceAsStream("/player1/Right" + (i + 1) + "mario.png"));
            }
            upFrames = new BufferedImage[12];
            for (int i = 0; i < upFrames.length; i++) {
                upFrames[i] = ImageIO.read(getClass().getResourceAsStream("/player1/Up" + (i + 1) + "mario.png"));
            }
            downFrames = new BufferedImage[12];
            for (int i = 0; i < downFrames.length; i++) {
                downFrames[i] = ImageIO.read(getClass().getResourceAsStream("/player1/Down" + (i + 1) + "mario.png"));
            }
            leftFrames = new BufferedImage[12];
            for (int i = 0; i < leftFrames.length; i++) {
                leftFrames[i] = ImageIO.read(getClass().getResourceAsStream("/player1/Left" + (i + 1) + "mario.png"));
            }

            idleFrames = new BufferedImage[14];
            for (int i = 0; i < idleFrames.length; i++) {
                idleFrames[i] = ImageIO.read(getClass().getResourceAsStream("/player1/Idle" + (i + 1) + "mario.png"));
            }



        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(input.upPressed){
            direction="up";
            worldY -=speed;
        }
        else if(input.downPressed){
            direction="down";
            worldY +=speed;

        }
        else if(input.rightPressed){
            direction="right";
            worldX +=speed;

        } else if (input.leftPressed) {
            direction="left";
            worldX -=speed;
        }
        else {
            direction="idle";
        }
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
        // g2.setColor(Color.CYAN);
        //g2.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize);
        BufferedImage image=null;
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
        g2.drawImage(image,screenX,screenY,gamePanel.tileSize, gamePanel.tileSize, null);

    }
}