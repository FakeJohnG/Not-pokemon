package Entidades;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NpcProf extends Entidad {
    int profMeet=0;

    public NpcProf(GamePanel gamePanel) {
        super(gamePanel);

        direction = "idle";
        speed = 2;
        getNpcImage();
        setDialogos();
    }

    public void setComportamiento(){
        direction = "idle";

    }
    public void setDialogos(){
        if(profMeet==0){
            dialogoEx[0]="Ah! llegaste muchacho";
            dialogoEx[1]="Justo a tiempo, eh?";
            dialogoEx[2]="Bien te tengo un trabajo para ti.";
            dialogoEx[3]="Osea una chamba,\n como los jovenes le dicen.";
            dialogoEx[4]="*AHEM* como decia...";
            dialogoEx[5]="Anoche unas extrañas piedras descendieron del cielo \n al rededor de la aldea.";
            dialogoEx[6]="Necesito que colectes todas, pueden ser peligrosas.";
            dialogoEx[7]="Y por supuesto,te pagaré";
            dialogoEx[8]="Recuerda tratar de no molestar a los pokémon'ts del\n alrededor ¿ok?";
            dialogoEx[9]="Buena suerte muchacho";

        }
        dialogosNpc[0]="Yo debo quedarme aqui a seguir con mis\n investigaciones la ciencia nunca para.";
        dialogosNpc[1]="Esto para ti sera pan comido, lo se";
        dialogosNpc[2]="Oye sabes algo de la Sra Aaliyah?\n no la e visto en dias";
        dialogosNpc[3]="¿Porque no pasas por su tienda a ver si esta?";
    }


    public void getNpcImage(){
        try{
            rightFrames = new BufferedImage[1];
            for (int i = 0; i < rightFrames.length; i++) {
                rightFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Profesor/ProfesorDer.png"));
            }
            upFrames = new BufferedImage[4];
            for (int i = 0; i < upFrames.length; i++) {
                upFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Profesor/ProfesorArriba.png"));
            }
            downFrames = new BufferedImage[4];
            for (int i = 0; i < downFrames.length; i++) {
                downFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Profesor/ProfesorAbajo.png"));
            }
            leftFrames = new BufferedImage[4];
            for (int i = 0; i < leftFrames.length; i++) {
                leftFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Profesor/ProfesorIzq.png"));
            }
//Si solo es un frame cuando esta en reposo, okay
            idleFrames = new BufferedImage[1];
            for (int i = 0; i < idleFrames.length; i++) {
                idleFrames[i] = ImageIO.read(getClass().getResourceAsStream("/NPCs/Profesor/ProfesorAbajo.png"));
            }



        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void speak(){
        gamePanel.objetivoStatus=1;
        gamePanel.npcId = 0;
        if(profMeet==0){
            gamePanel.ui.dialogoActual = dialogoEx[dialogoIndex];
            dialogoIndex++;
            // Si se acabaron, pasar a los normales
            if (dialogoIndex >= dialogoEx.length || dialogoEx[dialogoIndex] == null) {
                profMeet = 1;
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
