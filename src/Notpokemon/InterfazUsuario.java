package Notpokemon;

import Objetos.Gema;
import Pokes.Pikachu;
import Pokes.Scorbunny;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class InterfazUsuario {
    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40, spamton,pokemon;
    public String dialogoActual;
    BufferedImage imagenGema;
    BufferedImage fondoCombate;
    BufferedImage textBoxCombate;
    BufferedImage textBoxOpcion;
    BufferedImage statusBox;
    BufferedImage statusBoxJ;
    BufferedImage flechitaS;
    BufferedImage moveBox;
    public int numCommando=0;
    public int uiState=0;
    public int movUsado,movUsadoE;

    public InterfazUsuario(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        this.arial_40=new Font("Arial",Font.BOLD,20);
        InputStream is = getClass().getResourceAsStream("/font/spamton.ttf");
        InputStream is2= getClass().getResourceAsStream("/font/pokemon_fire_red.ttf");


        try {
            fondoCombate= ImageIO.read(getClass().getResourceAsStream("/otros/fondo de combate.png"));
            textBoxCombate= ImageIO.read(getClass().getResourceAsStream("/otros/textBoxCombate.png"));
            textBoxOpcion= ImageIO.read(getClass().getResourceAsStream("/otros/TextBoxOpcion.png"));
            flechitaS= ImageIO.read(getClass().getResourceAsStream("/otros/flechitaS.png"));
            moveBox=ImageIO.read(getClass().getResourceAsStream("/otros/moveBox.png"));
            statusBox=ImageIO.read(getClass().getResourceAsStream("/otros/statusBox.png"));
            statusBoxJ=ImageIO.read(getClass().getResourceAsStream("/otros/statusBoxJ.png"));


            spamton = Font.createFont(Font.TRUETYPE_FONT, is);
            spamton = spamton.deriveFont(Font.PLAIN, 14f);

            pokemon=Font.createFont(Font.TRUETYPE_FONT, is2);
            pokemon = pokemon.deriveFont(Font.PLAIN, 35f);


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
            g2.drawString("Gemas X "+gamePanel.jugador.cantMcguffin,50,50);


        }
        //Estado de titulo
        if(gamePanel.gameState==gamePanel.tituloState){
            drawPantallaTitulo();
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





    }
    public void drawCombate(){


        if (gamePanel.pokeJugador == null) {
            gamePanel.pokeJugador = new Pikachu(gamePanel);
        }
        if(gamePanel.pokeEnemigo==null){
            gamePanel.pokeEnemigo=gamePanel.combate.generarPokeSalvaje();
        }
        g2.setFont(pokemon);
        g2.setColor(Color.BLACK);
        g2.drawImage(fondoCombate,0,-120,gamePanel.screenWidth,gamePanel.screenHeight,null);
        g2.drawImage(gamePanel.pokeJugador.Pokeimagen, 125, 270, 196, 196, null);
        g2.drawImage(gamePanel.pokeEnemigo.Pokeimagen2, 500, 30, 196, 196, null);
        g2.drawImage(statusBox,100,20,300,100, null);
        g2.drawImage(statusBoxJ,450,351,300,100, null);
        g2.drawString(gamePanel.pokeJugador.name,475,390);
        if(uiState==0){
            g2.setColor(Color.white);
            g2.drawImage(textBoxCombate,0,450,775,130,null);
            g2.drawImage(textBoxOpcion,425,450,350,130,null);
            g2.drawString("Que deberia hacer "+gamePanel.pokeJugador.name+" ?",60,522);
            if(numCommando==0){
                g2.drawImage(flechitaS,440,482,30,30,null);
            }
            if(numCommando==1){
                g2.drawImage(flechitaS,600,482,30,30,null);
            }
            if(numCommando==2){
                g2.drawImage(flechitaS,440,528,30,30,null);
            }
            if(numCommando==3){
                g2.drawImage(flechitaS,600,528,30,30,null);

            }

        }
        if(uiState==1){
            g2.setColor(Color.black);
            g2.drawImage(moveBox,0,450,770,135,null);
            g2.drawString(""+gamePanel.pokeJugador.ppMax,580,510);
            g2.drawString(gamePanel.pokeJugador.movimientos[0].nombre, 75, 500);
            g2.drawString(gamePanel.pokeJugador.movimientos[1].nombre, 75, 547);
            g2.drawString(gamePanel.pokeJugador.movimientos[2].nombre, 300, 500);
            g2.drawString(gamePanel.pokeJugador.movimientos[3].nombre, 300, 547);


            if(numCommando==0){
                g2.drawImage(flechitaS,40,475,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[0].tipoImagen,620,525,100,30,null);
            }
            if(numCommando==1){
                g2.drawImage(flechitaS,267,475,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[2].tipoImagen,620,525,100,30,null);

            }
            if(numCommando==2){
                g2.drawImage(flechitaS,40,525,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[1].tipoImagen,620,525,100,30,null);
            }
            if(numCommando==3){
                g2.drawImage(flechitaS,267,525,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[3].tipoImagen,620,525,100,30,null);
            }
        }

        if(uiState==2){
            g2.setColor(Color.white);
            g2.drawImage(textBoxCombate,0,450,775,135,null);
            g2.drawString(gamePanel.pokeJugador.name+" usa "+gamePanel.pokeJugador.movimientos[movUsado].nombre,60,520);

        }
        if(uiState==3){
            g2.setColor(Color.white);
            g2.drawImage(textBoxCombate,0,450,775,135,null);
            g2.drawString("El "+gamePanel.pokeEnemigo.name+" enemigo usa "+gamePanel.pokeEnemigo.movimientos[movUsadoE].nombre,60,520);


        }



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
        Color c=new Color(149, 63, 63);
        g2.setColor(c);
        g2.fillRoundRect(x,y,ancho,alto,35,35);

        //linea de la caja
        c=new Color(53, 2, 2);
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
