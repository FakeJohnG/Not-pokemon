package Notpokemon;

import Objetos.Gema;
import Pokes.Pikachu;
import Pokes.Poke;
import Pokes.Porygon;
import Pokes.Scorbunny;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

//Dibuja los distintos elementos del juego
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
    BufferedImage heartDelta;
    BufferedImage spamShop;
    BufferedImage utp;
    BufferedImage fiscLogo;
    public int numCommando=0;
    public int uiState=0;
    public int bigshotState=0;
    public int movUsado,movUsadoE;
    public int dañoCausado;

    public InterfazUsuario(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        this.arial_40=new Font("Arial",Font.BOLD,20);
        InputStream is = getClass().getResourceAsStream("/font/spamton.ttf");
        InputStream is2= getClass().getResourceAsStream("/font/pokemon_fire_red.ttf");


        try {
            //Aqui se sacan las fuentes de las imagenes para la interfaz de combate e otros
            fondoCombate= ImageIO.read(getClass().getResourceAsStream("/otros/fondo de combate.png"));
            textBoxCombate= ImageIO.read(getClass().getResourceAsStream("/otros/textBoxCombate.png"));
            textBoxOpcion= ImageIO.read(getClass().getResourceAsStream("/otros/TextBoxOpcion.png"));
            flechitaS= ImageIO.read(getClass().getResourceAsStream("/otros/flechitaS.png"));
            moveBox=ImageIO.read(getClass().getResourceAsStream("/otros/moveBox.png"));
            statusBox=ImageIO.read(getClass().getResourceAsStream("/otros/statusBox.png"));
            statusBoxJ=ImageIO.read(getClass().getResourceAsStream("/otros/statusBoxJ.png"));
            heartDelta=ImageIO.read(getClass().getResourceAsStream("/otros/heartdelta.png"));
            spamShop=ImageIO.read(getClass().getResourceAsStream("/otros/spamShop.jpg"));
            utp=ImageIO.read(getClass().getResourceAsStream("/otros/utpLogo.png"));
            fiscLogo=ImageIO.read(getClass().getResourceAsStream("/otros/fiscLogo.png"));


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
        //Este metodo dibuja las diferentes partes de la interfaz, dependiendo del estado de juego
        this.g2=g2;
        if(gamePanel.objetivoStatus==1){
            g2.setFont(arial_40);
            g2.setColor(Color.black);
            g2.drawImage(imagenGema,gamePanel.tileSize/2,gamePanel.tileSize/2,gamePanel.tileSize,gamePanel.tileSize,null);
            g2.drawString("Gemas X "+gamePanel.jugador.cantMcguffin,50,50);


        }
        else if(gamePanel.objetivoStatus==0&& gamePanel.gameState!=gamePanel.tituloState){
            g2.setFont(arial_40);
            g2.setColor(Color.black);
            g2.drawString("Habla con el profe!",50,50);
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
        //Estado de tienda
        if(gamePanel.gameState==gamePanel.statusTienda){
            drawTienda();
        }





    }
    public void drawTienda() {
        if (bigshotState == 0) {

            drawCajaDialogo(); //Para que se muestre su dialogo antes de selecionar la opcion
            drawSubCaja(100, 210, 220, 100);
            g2.drawImage(heartDelta, 120, 245, 15, 15, null);
            g2.setColor(Color.yellow);
            g2.drawString("SE UN [BIG SHOT]", 140, 260);

        }
        else if (bigshotState == 1) {
            g2.drawImage(spamShop, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);
            g2.setColor(Color.yellow);
            g2.drawString("TU DINERO: "+gamePanel.jugador.dinero,300,30);
            g2.drawString("SOLO 1 A LA VES, SIN REMBOLSOS",200,500);
            if(bigshotState==2){
                g2.setColor(Color.yellow);
                g2.drawString("HEY YA LO TIENES! ",200,300);
            }

            int x = 70;   //Posición X del primer pokemon
            int y = 70;   //Posición Y del primer pokemon
            int separacion = 130;//Espacio entre cada Pokémon
            int max = 5;//maxima cantidad de pokemon en cada fila
            int contador=0;


            //For loop para dibujar cada imagen de pokemon + su nombre
            for (int i=0; i< gamePanel.spam.inventario.size();i++) {
                Poke poke= gamePanel.spam.inventario.get(i);
                if (poke.Pokeimagen != null) {
                    g2.drawImage(poke.Pokeshop, x, y, 96, 96, null);
                    g2.setColor(Color.white);
                    g2.drawString(poke.name, x, y + 110);
                }
                if(i==numCommando){
                    g2.setColor(Color.YELLOW);
                    g2.drawString("Precio: $" + poke.precio, x, y );
                }
                x += separacion;
                contador++;
                if (contador == max) {
                    x = 50;
                    y += 150;
                }


            }

//Forma más elegante de dibujar el cursor sin un pocoton de ifs

            int columna = numCommando % max;
            int fila = numCommando / max;

            int cursorX = 60 + columna * separacion - 10;
            int cursorY = 70 + fila * 150 + 30;

            g2.drawImage(heartDelta, cursorX, cursorY, 30, 20, null);


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
        if(uiState!=5){
            g2.drawImage(gamePanel.pokeJugador.Pokeimagen, 125, 270, 196, 196, null);
        }

        if(uiState!=4){
            g2.drawImage(gamePanel.pokeEnemigo.Pokeimagen2, 460, 30, 216, 216, null);
        }
        g2.drawImage(statusBox,100,20,300,100, null);
        g2.drawImage(statusBoxJ,450,351,300,100, null);
        g2.drawString(gamePanel.pokeJugador.name,475,390);
        g2.drawString(gamePanel.pokeEnemigo.name,120,55);
        g2.drawString("pv"+gamePanel.pokeJugador.pv,475,420);
        g2.drawString("pv"+gamePanel.pokeEnemigo.pv,120,80);

        if(uiState==0){
            g2.setColor(Color.white);
            g2.drawImage(textBoxCombate,0,450,775,130,null);
            g2.drawImage(textBoxOpcion,425,450,350,130,null);
            g2.drawString("Que deberia hacer "+gamePanel.pokeJugador.name+" ?",50,510);
            if(numCommando==0){
                g2.drawImage(flechitaS,440,482,30,30,null);
            }
            if(numCommando==1){
                g2.drawImage(flechitaS,600,482,30,30,null);
            }
            if(numCommando==2){
                g2.drawImage(flechitaS,440,530,30,30,null);
            }
            if(numCommando==3){
                g2.drawImage(flechitaS,600,530,30,30,null);

            }

        }
        if(uiState==1){
            g2.setColor(Color.black);
            g2.drawImage(moveBox,0,450,770,135,null);
            g2.drawString(""+gamePanel.pokeJugador.ppMax,580,510);
            g2.drawString(gamePanel.pokeJugador.movimientos[0].nombre, 85, 500);
            g2.drawString(gamePanel.pokeJugador.movimientos[1].nombre, 85, 547);
            g2.drawString(gamePanel.pokeJugador.movimientos[2].nombre, 300, 500);
            g2.drawString(gamePanel.pokeJugador.movimientos[3].nombre, 300, 547);


            if(numCommando==0){
                g2.drawImage(flechitaS,50,475,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[0].tipoImagen,620,525,100,30,null);
            }
            if(numCommando==1){
                g2.drawImage(flechitaS,50,525,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[1].tipoImagen,620,525,100,30,null);
            }
            if(numCommando==2){
                g2.drawImage(flechitaS,270,475,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[2].tipoImagen,620,525,100,30,null);

            }
            if(numCommando==3){
                g2.drawImage(flechitaS,270,525,30,30,null);
                g2.drawImage(gamePanel.pokeJugador.movimientos[3].tipoImagen,620,525,100,30,null);
            }
        }

        if(uiState==2){
            g2.setColor(Color.white);
            g2.drawImage(textBoxCombate,0,450,775,135,null);
            g2.drawString(gamePanel.pokeJugador.name+" usa "+gamePanel.pokeJugador.movimientos[movUsado].nombre,50,510);
            g2.drawString("Causo "+dañoCausado+" puntos de dano!",50,550);

        }
        if(uiState==3){
            g2.setColor(Color.white);
            g2.drawImage(textBoxCombate,0,450,775,135,null);
            g2.drawString(gamePanel.pokeEnemigo.name+" usa "+gamePanel.pokeEnemigo.movimientos[movUsadoE].nombre,50,510);
            g2.drawString(gamePanel.pokeJugador.name+" recibio "+dañoCausado+" puntos de dano!",50,550);

        }
        if(uiState==4){
            g2.drawImage(textBoxCombate,0,450,775,135,null);
            g2.drawString(gamePanel.pokeJugador.name+" usa "+gamePanel.pokeJugador.movimientos[movUsado].nombre,50,510);
            g2.drawString("El "+gamePanel.pokeEnemigo.name+" fue derrotado!",50,550);


        }
        if(uiState==5){
            g2.drawImage(textBoxCombate,0,450,775,135,null);
            g2.drawString(gamePanel.pokeEnemigo.name+" usa "+gamePanel.pokeEnemigo.movimientos[movUsado].nombre,50,510);
            g2.drawString(gamePanel.pokeJugador.name+" fue derrotado! CORRE!",50,550);

        }



    }
    public void drawPantallaTitulo(){
        g2.setFont(arial_40);
        g2.drawImage(utp,90,40,100,100,null);
        g2.drawImage(fiscLogo,570,40,100,100,null);
        String texto="POKEMON'T";
        int x=gamePanel.tileSize*6;
        int y=gamePanel.tileSize*5;
        g2.setColor(Color.white);
        g2.drawString(texto,x,y);
        int x2=gamePanel.tileSize*5;
        int y2=gamePanel.tileSize*7;
        g2.drawString("Presiona Enter!",x2+10,y2);
        g2.drawString("Juan Delgado",600,500);
        g2.drawString("Ian Vasquez",470,500);
        g2.drawString("Aaliyah Chase",330,500);
        g2.drawString("Iveth Vega",210,500);
        g2.drawString("Gabriela Suazo",50,500);

    }
    public void drawCajaDialogo(){
        //parametros de la ventana
        int x=gamePanel.tileSize*2;
        int y=gamePanel.tileSize/2;
        int ancho=gamePanel.screenWidth -(gamePanel.tileSize*4);
        int alto=gamePanel.tileSize*4;

        drawSubCaja(x,y,ancho,alto);
        if(gamePanel.npcId==1){
            g2.setFont(spamton);
            g2.setColor(Color.white);
        }


        x+=gamePanel.tileSize;
        y+=gamePanel.tileSize;

        for(String linia: dialogoActual.split("\n")){

            g2.drawString(linia,x,y);
            y+=40;
        }


    }
    public void drawSubCaja(int x,int y,int ancho,int alto){
        //Fondo de la caja
        Color c=new Color(243, 252, 255);
        g2.setColor(c);
        g2.fillRoundRect(x,y,ancho,alto,35,35);

        //linea de la caja
        c=new Color(10, 43, 74);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x,y,ancho,alto,25,25);

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
