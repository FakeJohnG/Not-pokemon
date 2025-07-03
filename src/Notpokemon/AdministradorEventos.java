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
    public void checkEvento(){
        int xDistance=Math.abs(gamePanel.player.worldX-eventoAnteriorX);
        int yDistance=Math.abs(gamePanel.player.worldY-eventoAnteriorY);
        int distancia=Math.max(xDistance,yDistance);
        if(distancia>gamePanel.tileSize){
            eventoActivo=true;

        }
        if(eventoActivo==true){
           //fila

            if(hit(0,19,33,"any")){
                System.out.println("loading spamton...");
                teleport(1,7,7);

            }
            else if(hit(1,7,7,"any")){
                System.out.println("Bye bye spamton");
                teleport(0,19,34);

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
}
