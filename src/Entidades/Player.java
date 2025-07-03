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
        solidBox = new Rectangle();
        solidBox.x=8;
        solidBox.y=16;
        solidBox.width=32;
        solidBox.height=32;

        setDefautValues();
        getPlayerImage();
    }
    public void setDefautValues(){
        //Posicion default de jugador en mapa
        //Valores para mapXL: worldX =gamePanel.tileSize*23;,worldY =gamePanel.tileSize*21;
        //Valores para mapTest1: worldX =gamePanel.tileSize*7;,worldY =gamePanel.tileSize*7
        worldX =gamePanel.tileSize*23;
        worldY =gamePanel.tileSize*21;
        speed=6;
        direction="idle";
    }
    public void getPlayerImage(){
        try{
            rightFrames = new BufferedImage[3];
            for (int i = 0; i < rightFrames.length; i++) {
                rightFrames[i] = ImageIO.read(getClass().getResourceAsStream("/Entrenador1/Der" + (i + 1) + ".png"));
            }
            upFrames = new BufferedImage[3];
            for (int i = 0; i < upFrames.length; i++) {
                upFrames[i] = ImageIO.read(getClass().getResourceAsStream("/Entrenador1/Arriba" + (i + 1) + ".png"));
            }
            downFrames = new BufferedImage[3];
            for (int i = 0; i < downFrames.length; i++) {
                downFrames[i] = ImageIO.read(getClass().getResourceAsStream("/Entrenador1/Abajo" + (i + 1) + ".png"));
            }
            leftFrames = new BufferedImage[3];
            for (int i = 0; i < leftFrames.length; i++) {
                leftFrames[i] = ImageIO.read(getClass().getResourceAsStream("/Entrenador1/Izq" + (i + 1) + ".png"));
            }
//Si solo es un frame cuando esta en reposo, okay
            idleFrames = new BufferedImage[1];
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

        }
        else if(input.downPressed){
            direction="down";


        }
        else if(input.rightPressed){
            direction="right";


        } else if (input.leftPressed) {
            direction="left";

        }
        else {
            direction="idle";
        }
        //Verificar collision
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