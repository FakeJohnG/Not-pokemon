package Notpokemon;

public class AdministradorEventos {
    GamePanel gamePanel;
    EventRect eventRect[][][];
    int eventoAnteriorX, eventoAnteriorY;
    boolean eventoActivo=true;

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
        int xDistance = Math.abs(gamePanel.player.worldX - eventoAnteriorX);
        int yDistance = Math.abs(gamePanel.player.worldY - eventoAnteriorY);
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

            } else if (hit(0, 21, 12, "any")) {
                System.out.println("encuentro salvaje?");
                encuentroSalvaje();

            }else if (hit(0, 20, 12, "any")) {
                System.out.println("encuentro salvaje?");
                encuentroSalvaje();

            }



        }
    }

    public boolean hit(int map,int col,int fila,String direction){
        boolean hit=false;

        if(map==gamePanel.mapaActual){
            gamePanel.player.solidBox.x=gamePanel.player.worldX+gamePanel.player.solidBox.x;
            gamePanel.player.solidBox.y=gamePanel.player.worldY+gamePanel.player.solidBox.y;
            eventRect[map][col][fila].x=col*gamePanel.tileSize+eventRect[map][col][fila].x;
            eventRect[map][col][fila].y=fila*gamePanel.tileSize+eventRect[map][col][fila].y;

            if(gamePanel.player.solidBox.intersects(eventRect[map][col][fila])&& eventRect[map][col][fila].eventoFini==false){
                if(gamePanel.player.direction.contentEquals(direction)|| direction.contentEquals("any")){
                    hit=true;
                    eventoAnteriorX=gamePanel.player.worldX;
                    eventoAnteriorY=gamePanel.player.worldY;
                    System.out.print("Evento!");

                }

            }
            gamePanel.player.solidBox.x=gamePanel.player.areaSolidaDefaultX;
            gamePanel.player.solidBox.y=gamePanel.player.areaSolidaDefaultY;
            eventRect[map][col][fila].x=eventRect[map][col][fila].eventRectDefaultX;
            eventRect[map][col][fila].y=eventRect[map][col][fila].eventRectDefaultY;

        }


        return hit;

    }
    public void teleport(int map,int col,int fila){

        gamePanel.mapaActual=map;
        gamePanel.player.worldX=gamePanel.tileSize*col;
        gamePanel.player.worldY=gamePanel.tileSize*fila;
        eventoAnteriorX=gamePanel.player.worldX;
        eventoAnteriorY=gamePanel.player.worldY;
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
        //Esto sirvira para los encuentros salvajes, aun estoy viendo las probabilidades but its a start.
        int probEncuento = (int) (Math.random() * 225) + 1;
        System.out.println(probEncuento);
        if (probEncuento < 65) {
            System.out.println("Encuentro Salvaje!");
            eventoActivo=false;
            gamePanel.sonido.stop();
            gamePanel.sonido.setFile(5);
            gamePanel.sonido.play();


        }
    }
}
