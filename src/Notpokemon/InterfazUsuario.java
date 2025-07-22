package Notpokemon;

import Objetos.Gema;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class InterfazUsuario {
    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40, spamton;
    public String dialogoActual;
    BufferedImage imagenGema;
    BufferedImage fondoCombate;
    BufferedImage textBoxCombate;

    public InterfazUsuario(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        this.arial_40=new Font("Arial",Font.BOLD,20);
        InputStream is = getClass().getResourceAsStream("/font/spamton.ttf");


        try {
            fondoCombate= ImageIO.read(getClass().getResourceAsStream("/otros/fondo de combate.png"));
            textBoxCombate= ImageIO.read(getClass().getResourceAsStream("/otros/textBoxCombate.png"));
            spamton = Font.createFont(Font.TRUETYPE_FONT, is);
            spamton = spamton.deriveFont(Font.PLAIN, 14f);


        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        //Estado de combate
        if(gamePanel.gameState==gamePanel.combateState){
            drawCombate();
        }
        //Estado de titulo
        if(gamePanel.gameState==gamePanel.tituloState){
            drawPantallaTitulo();
        }




    }
    public void drawCombate(){
        g2.drawImage(fondoCombate,0,0,gamePanel.screenWidth,gamePanel.screenHeight,null);
        g2.drawImage(textBoxCombate,100,350,500,100,null);


    }
    public void drawPantallaTitulo(){
        g2.setFont(arial_40);
        String texto="Pokemon't";
        int x=gamePanel.tileSize*3;
        int y=gamePanel.tileSize*3;
        g2.setColor(Color.white);
        g2.drawString(texto,x,y);
        int x2=gamePanel.tileSize*3;
        int y2=gamePanel.tileSize*4;
        g2.drawString("APRETA ENTER!",x2+10,y2);

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
