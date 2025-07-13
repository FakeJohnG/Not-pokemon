package Entidades;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NpcGuy extends Entidad {

    public NpcGuy(GamePanel gamePanel) {
        super(gamePanel);

        direction = "idle";
        speed = 2;
        getNpcImage();
    }
    public void setComportamiento(){
        contAccion++;
        if(contAccion==120){
            Random aleatorio=new Random();
            int i=aleatorio.nextInt(125)+1;
            if(i<=25){
                direction="up";

            }
            if(i>25 && i<=50){
                direction="down";
            }
            if(i>50 && i<=75 ){
                direction="left";
            }
            if(i>75 && i<=100){
                direction="right";
            }
            if(i>100 && i<=124){
                direction="idle";
            }
            contAccion=0;

        }


    }

    public void getNpcImage(){
        try{
            rightFrames = new BufferedImage[3];
            for (int i = 0; i < rightFrames.length; i++) {
                rightFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Niño/DerNiño" + (i + 1) + ".png"));
            }
            upFrames = new BufferedImage[3];
            for (int i = 0; i < upFrames.length; i++) {
                upFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Niño/ArribaNiño" + (i + 1) + ".png"));
            }
            downFrames = new BufferedImage[3];
            for (int i = 0; i < downFrames.length; i++) {
                downFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Niño/AbajoNiño" + (i + 1) + ".png"));
            }
            leftFrames = new BufferedImage[3];
            for (int i = 0; i < leftFrames.length; i++) {
                leftFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Niño/IzqNiño" + (i + 1) + ".png"));
            }
//Si solo es un frame cuando esta en reposo, okay
            idleFrames = new BufferedImage[1];
            for (int i = 0; i < idleFrames.length; i++) {
                idleFrames[i] = ImageIO.read(getClass().getResourceAsStream("/Entrenador1/Abajo" + (2) + ".png"));
            }



        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
