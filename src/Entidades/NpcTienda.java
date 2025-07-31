package Entidades;

import Notpokemon.GamePanel;
import Pokes.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class NpcTienda extends Entidad{
    public int spamMeet=0;
    public ArrayList<Poke> inventario = new ArrayList<>();
    public NpcTienda(GamePanel gamePanel) {
        super(gamePanel);
        //Pokemon que salen en la tienda
        inventario.add(new Scorbunny(gamePanel));
        inventario.add(new Porygon(gamePanel));
        inventario.add(new Gengar(gamePanel));
        inventario.add(new Snorlax(gamePanel));
        inventario.add(new Bulbasaur(gamePanel));
        inventario.add(new Meowth(gamePanel));
        inventario.add(new Charmander(gamePanel));
        inventario.add(new Lucario(gamePanel));

        direction = "idle";
        getNpcImage();
        setDialogos();
    }
    public void setDialogos(){
        if(spamMeet==0){
            dialogoEx[0]="*HOLA MUNDO   SOY    YO ";
            dialogoEx[1]="*[[Number 1 Rated Salesman1997]] ";
            dialogoEx[2]="*SPAMT";
            dialogoEx[3]="*SPAMTON G SPAMTON";
            dialogoEx[4]="*[[/sonidos/laughtTrack.wav]]";
            dialogoEx[5]="*OH !   PERO SI ES UN...";
            dialogoEx[6]="*OYE OYE ERES UN \n[[Tengo que ser siempre el mejor]] VERDAD?";
            dialogoEx[7]="*PARECE QUE ESTAS [[Solo un viernes en la noche]]";
            dialogoEx[8]="*AMIGOS TE DEJARON [[Bailando sola]] ?";
            dialogoEx[9]="*LAS VENTAS SE AN IDO POR EL\n [[Todo se derumboooo]]?";
            dialogoEx[10]="*VIVIENDO EN UN [[lind0 :)]] BA5URERO!1!";
            dialogoEx[11]="*PUES TENGO UNA [[0ferta de tiempo limitado]] \nPARA [[Corazones rotos]] COMO EL TUYO";
            dialogoEx[12]="*SI QUIERES VOLVER A CONTROLAR TU VIDA\n DEBES AGARRALA [[por los cuernos]]";
            dialogoEx[13]="*PARA QUE SER UN [[Combo cuarto de libra]] \nQUE ODIA SU [$6.75] VIDA";
            dialogoEx[14]="*CUANDO PUEDES SER UN...";
            dialogoEx[15]="*BIG SHOT!";
            dialogoEx[16]="*BIG SHOT! \n*BIG SHOT!!";
            dialogoEx[17]="*BIG SH0T! \n*BIG SHOT!! \n*BIG SHOT!!!";
            dialogoEx[18]="*ES TU OPORTUNIDAD DE SER UN [[BIG SHOT]]!";
            dialogoEx[19]="*PUES TENGO";
            dialogoEx[20]="*LA COSA";
            dialogoEx[21]="*QUE NECESITAS";
            dialogoEx[22]="*[[Hypervinculo bloqueado]]";
            dialogoEx[23]="*ASI ES TU QUIERES [[Hypervinculo bloqueado]]\n LO NECESITAS";
            dialogoEx[24]="*..........?";
            dialogoEx[25]="*.............................!";
            dialogoEx[26]="*SANTOS BACALADOS [MIKE] DONDE ESTA\n [[Hypervinculo bloqueado]]\n DONDE ESTA DONDE ESTA  ";
            dialogoEx[27]="*OYE OYE, NO TAN RAPIDO MI [[Skibbidi-sigma]]!";
            dialogoEx[28]="*TENGO OTRAS [[Fantasticas ofertas!]] PARA TI";
            dialogoEx[29]="*COMO POR EJEMPLO ESTOS [[Monstruos de bolsillo]] \nQUE ADQUERI POR \n[[medios 100% morales y nada illegales]]";
            dialogoEx[30]="*AL IGUAL QUE ESTA HUMILDE TIENDA\n [[100% real no fake, sin virus gratis2025]] ";
            dialogoEx[31]="*VERDAD [MIKE]!";
            dialogoEx[32]="*........";
            dialogoEx[33]="*AHAHAHAHAHA [MIKE] ERES TODO UN [[Don comedias]]";
            dialogoEx[34]="*ENTONCE2 QUE ME DICES LISTO PARA SER UN \n[BIG SHOT]? ";

        }
        dialogosNpc[0]="*BIG SHOT!";
        dialogosNpc[1]="*LA VERDAD NO SABEMOS COMO LLEGAMOS AQUI ";
        dialogosNpc[2]="*[[NOW`S YOUR CHANCE TO BE A BIG SHOT!!]]";
        dialogosNpc[3]="*Juegen [[DELTARUNE]] buen   ";
        dialogosNpc[4]="*VOY A TIRAR UN [[F A C T O]]\n Jeffrey epstein did not   !";


    }
    public void getNpcImage(){
        try{


            idleFrames=new BufferedImage[27];
            for(int i=0; i<idleFrames.length; i++){
                idleFrames[i] = ImageIO.read(getClass().getResourceAsStream("/spamton/spamton" + (i + 1) + ".png"));
            }



        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void speak() {
        gamePanel.npcId = 1;

        if (spamMeet == 0) {
            gamePanel.sonidoE.setFile(2);
            // Mostrar los diálogos especiales
            gamePanel.ui.dialogoActual = dialogoEx[dialogoIndex];
            dialogoIndex++;

            // Si se acabaron, pasar a los normales
            if (dialogoIndex >= dialogoEx.length || dialogoEx[dialogoIndex] == null) {
                spamMeet = 1;
                dialogoIndex = 0;
            }
        } else {
            // Mostrar los diálogos normales
            gamePanel.ui.dialogoActual = dialogosNpc[dialogoIndex];
            dialogoIndex++;


            if (dialogoIndex >= dialogosNpc.length || dialogosNpc[dialogoIndex] == null) {
                dialogoIndex = 0;
            }
            gamePanel.gameState=gamePanel.statusTienda;
        }
    }

}
