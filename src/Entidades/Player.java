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

    public Player(GamePanel gamePanel,Inputs input){
        this.gamePanel=gamePanel;
        this.input=input;
        setDefautValues();
        getPlayerImage();
    }
    public void setDefautValues(){
        x=100;
        y=100;
        speed=2;
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
            y-=speed;
        }
        else if(input.downPressed){
            direction="down";
            y+=speed;

        }
        else if(input.rightPressed){
            direction="right";
            x+=speed;

        } else if (input.leftPressed) {
            direction="left";
            x-=speed;
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
        g2.drawImage(image,(int)x,(int)y,gamePanel.tileSize, gamePanel.tileSize, null);

    }
}
