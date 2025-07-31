package Entidades;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NpcGuy extends Entidad {
    int kidMeet=0;

    public NpcGuy(GamePanel gamePanel) {
        super(gamePanel);

        direction = "idle";
        speed = 2;
        getNpcImage();
        setDialogos();
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
    public void setDialogos(){
        if(kidMeet==0){
            dialogoEx[0]="¿Eh? ¿Rodriguito que haces despierto a esta hora?";
            dialogoEx[1]="No me digas, ¿otro trabajo aburido del profe?";
            dialogoEx[2]="Se siente genial ser niño";
            dialogoEx[3]="Ah si lo buscas esta en su laboratorio";
            dialogoEx[4]="bueno bye bye";
        }
        dialogosNpc[0]="Otro bonito dia.";
        dialogosNpc[1]="Porque la gente habla tanto de los vaporeons?\n no son nada especiales";
        dialogosNpc[2]="Oye! as oido de este pequeño juego Llamado \n Dragon ball legends?";
        dialogosNpc[3]="no lo jueges";
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
                idleFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Niño/AbajoNiño" + (2) + ".png"));
            }



        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void speak(){
        gamePanel.objetivoStatus=1;
        gamePanel.npcId = 0;
        if(kidMeet==0){
            gamePanel.ui.dialogoActual = dialogoEx[dialogoIndex];
            dialogoIndex++;
            // Si se acabaron, pasar a los normales
            if (dialogoIndex >= dialogoEx.length || dialogoEx[dialogoIndex] == null) {
                kidMeet = 1;
                dialogoIndex = 0;
            }
        }else{
            gamePanel.sonidoE.setFile(7);
            gamePanel.sonidoE.play();
            gamePanel.npcId = 0;
            if(dialogosNpc[dialogoIndex]==null){
                dialogoIndex=0;
            }
            gamePanel.ui.dialogoActual=dialogosNpc[dialogoIndex];
            dialogoIndex++;
        }

        switch(gamePanel.jugador.direction){
            case "up":
                direction="down";
                break;
            case "down":
                direction="up";
                break;
            case "left":
                direction="right";
                break;
            case "right":
                direction="left";
                break;
        }

    }
}
