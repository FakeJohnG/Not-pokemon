package Notpokemon;

public class AdministradorEventos {
    GamePanel gamePanel;
    EventRect eventRect[][][];
    int eventoAnteriorX, eventoAnteriorY;
    boolean eventoActivo=true;
    int contadorEncuentro;

    public AdministradorEventos(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        eventRect=new EventRect[gamePanel.mapaMax][gamePanel.maxWorldCol][gamePanel.maxWorldFila];
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

            } else if (hit(0, 20, 14, "any")) {
                System.out.println("encuentro salvaje 1?");
                encuentroSalvaje();

            }else if (hit(0, 20, 12, "any")) {
                System.out.println("encuentro salvaje 2?");
                encuentroSalvaje();

            }



        }
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
