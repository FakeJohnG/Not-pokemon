package Notpokemon;

import Objetos.Gema;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InterfazUsuario {
    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40;
    public String dialogoActual;
    BufferedImage imagenGema;

    public InterfazUsuario(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        this.arial_40=new Font("Arial",Font.BOLD,20);
        Gema gema=new Gema();
        imagenGema= gema.imagen;
    }
    public void draw(Graphics2D g2){
        this.g2=g2;
        if(gamePanel.objetivoStatus==1){
            g2.setFont(arial_40);
            g2.setColor(Color.black);
            g2.drawImage(imagenGema,gamePanel.tileSize/2,gamePanel.tileSize/2,gamePanel.tileSize,gamePanel.tileSize,null);
            g2.drawString("Gemas X "+gamePanel.player.cantMcguffin,50,50);


        }
        if(gamePanel.gameState==gamePanel.pauseState){
            g2.setFont(arial_40);
            g2.setColor(Color.black);
            g2.drawString("===Pausa===",320,250);
        }
        //Estado de dialogo
        if(gamePanel.gameState== gamePanel.yapperState){
            drawCajaDialogo();
        }


    }
    public void drawCajaDialogo(){
        //parametros de la ventana
        int x=gamePanel.tileSize*2;
        int y=gamePanel.tileSize/2;
        int ancho=gamePanel.screenWidth -(gamePanel.tileSize*4);
        int alto=gamePanel.tileSize*4;

        drawSubCaja(x,y,ancho,alto);


        x+=gamePanel.tileSize;
        y+=gamePanel.tileSize;

        for(String linia: dialogoActual.split("\n")){

            g2.drawString(linia,x,y);
            y+=40;
        }


    }
    public void drawSubCaja(int x,int y,int ancho,int alto){
        //Fondo de la caja
        Color c=new Color(225,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,ancho,alto,35,35);

        //linea de la caja
        c=new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,ancho-10,alto-10,25,25);

        if(gamePanel.npcId==1){
            c=new Color(0,0,0);
            g2.setColor(c);
            g2.fillRect(x,y,ancho,alto);

            c=new Color(255,255,255);
            g2.setColor(c);
            g2.drawRect(x+5,y+5,ancho-10,alto-10);


        }


    }



}
