package Notpokemon;

import java.awt.*;
import java.util.ArrayList;

public class AdministradorEventos {
    GamePanel gamePanel;
    EventRect eventRect[][][];
    int eventoAnteriorX, eventoAnteriorY;
    boolean eventoActivo=true;
    int contadorEncuentro;
    ArrayList<ZonaEncuentro> zonasSalvajes = new ArrayList<>();

    public AdministradorEventos(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        //Lado isquierdo
        eventRect=new EventRect[gamePanel.mapaMax][gamePanel.maxWorldCol][gamePanel.maxWorldFila];
        zonasSalvajes.add(new ZonaEncuentro(0, 18, 14, 20, 14, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 17, 15, 21, 15, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 15, 16, 19, 16, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 29, 10, 29, 15, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 16, 5, 21, 5, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 21, 6, 21, 8, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 19, 9, 20, 9, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 15, 9, 15, 11, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 18, 6, 18, 8, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 14, 8, 14, 12, gamePanel.tileSize));

        //Lado derecho
        zonasSalvajes.add(new ZonaEncuentro(0, 30, 12, 31, 12, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 30, 16, 31, 16, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 32, 13, 32, 15, gamePanel.tileSize));
        zonasSalvajes.add(new ZonaEncuentro(0, 33, 15, 34, 15, gamePanel.tileSize));




        int map=0;
        int col=0;
        int fila=0;
        while(map<gamePanel.mapaMax && col<gamePanel.maxWorldCol && fila<gamePanel.maxWorldFila){
            eventRect[map][col][fila]=new EventRect();
            eventRect[map][col][fila].x=23;
            eventRect[map][col][fila].y=23;
            eventRect[map][col][fila].width=2;
            eventRect[map][col][fila].height=2;
            eventRect[map][col][fila].eventRectDefaultX=eventRect[map][col][fila].x;
            eventRect[map][col][fila].eventRectDefaultY=eventRect[map][col][fila].y;

            col++;
            if(col==gamePanel.maxWorldCol){
                col=0;
                fila++;
            }
            if(fila==gamePanel.maxWorldFila){
                fila=0;
                map++;
            }

        }
    }
    public void checkZonasSalvajes() {
        for (ZonaEncuentro zona : zonasSalvajes) {
            if (zona.mapa == gamePanel.mapaActual && zona.activa) {
                Rectangle playerArea = new Rectangle(
                        gamePanel.jugador.worldX + gamePanel.jugador.solidBox.x,
                        gamePanel.jugador.worldY + gamePanel.jugador.solidBox.y,
                        gamePanel.jugador.solidBox.width,
                        gamePanel.jugador.solidBox.height
                );
                if (playerArea.intersects(zona.area)) {
                    encuentroSalvaje();
                    break;
                }
            }
        }
    }
    public void checkEvento() {
        int xDistance = Math.abs(gamePanel.jugador.worldX - eventoAnteriorX);
        int yDistance = Math.abs(gamePanel.jugador.worldY - eventoAnteriorY);
        int distancia = Math.max(xDistance, yDistance);
        if (distancia > gamePanel.tileSize) {
            eventoActivo = true;

        }
        if (eventoActivo == true) {
            //fila

            if (hit(0, 31, 21, "any")) {
                System.out.println("loading spamton...");
                gamePanel.sonidoE.setFile(4);
                gamePanel.sonidoE.play();
                teleport(1, 7, 7);
                gamePanel.objetivoStatus=1;

            } else if (hit(1, 7, 7, "any")) {
                System.out.println("Bye bye spamton");
                gamePanel.sonidoE.setFile(4);
                gamePanel.sonidoE.play();
                teleport(0, 31, 22);

            }




        }
        checkZonasSalvajes();
    }

    public boolean hit(int map,int col,int fila,String direction){
        boolean hit=false;

        if(map==gamePanel.mapaActual){
            gamePanel.jugador.solidBox.x=gamePanel.jugador.worldX+gamePanel.jugador.solidBox.x;
            gamePanel.jugador.solidBox.y=gamePanel.jugador.worldY+gamePanel.jugador.solidBox.y;
            eventRect[map][col][fila].x=col*gamePanel.tileSize+eventRect[map][col][fila].x;
            eventRect[map][col][fila].y=fila*gamePanel.tileSize+eventRect[map][col][fila].y;

            if(gamePanel.jugador.solidBox.intersects(eventRect[map][col][fila])&& eventRect[map][col][fila].eventoFini==false){
                if(gamePanel.jugador.direction.contentEquals(direction)|| direction.contentEquals("any")){
                    hit=true;
                    eventoAnteriorX=gamePanel.jugador.worldX;
                    eventoAnteriorY=gamePanel.jugador.worldY;
                    System.out.print("Evento!");

                }

            }
            gamePanel.jugador.solidBox.x=gamePanel.jugador.areaSolidaDefaultX;
            gamePanel.jugador.solidBox.y=gamePanel.jugador.areaSolidaDefaultY;
            eventRect[map][col][fila].x=eventRect[map][col][fila].eventRectDefaultX;
            eventRect[map][col][fila].y=eventRect[map][col][fila].eventRectDefaultY;

        }


        return hit;

    }
    public void teleport(int map,int col,int fila){

        gamePanel.mapaActual=map;
        gamePanel.jugador.worldX=gamePanel.tileSize*col;
        gamePanel.jugador.worldY=gamePanel.tileSize*fila;
        eventoAnteriorX=gamePanel.jugador.worldX;
        eventoAnteriorY=gamePanel.jugador.worldY;
        eventoActivo=false;

        if(gamePanel.mapaActual==1){
            gamePanel.sonido.stop();
            gamePanel.sonido.setFile(3);
            gamePanel.sonido.play();
            gamePanel.sonido.loop();
        }
        if(gamePanel.mapaActual==0){
            gamePanel.sonido.stop();
            gamePanel.sonido.setFile(0);
            gamePanel.sonido.play();
            gamePanel.sonido.loop();
        }



    }
    public void encuentroSalvaje() {
        if(contadorEncuentro!=0){
            System.out.println("cooldown..."+contadorEncuentro);
            contadorEncuentro--;
        }
        else{
            int probEncuento = (int) (Math.random() * 225) + 1;
            System.out.println(probEncuento);
            if(probEncuento>65){
                System.out.println("Nop fallo");
                contadorEncuentro=30;

            }
            if (probEncuento < 65) {
                contadorEncuentro = 75;
                System.out.println("Encuentro Salvaje!");
                gamePanel.gameState= gamePanel.combateState;
                eventoActivo=false;
                gamePanel.sonido.stop();
                gamePanel.sonido.setFile(5);
                gamePanel.sonido.play();


            }
        }

    }
}
