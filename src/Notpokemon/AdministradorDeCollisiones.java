package Notpokemon;

import Entidades.Entidad;
//Esta clase maneja lo que es las collisiones en el juego

public class AdministradorDeCollisiones {
    GamePanel gamePanel;

    public AdministradorDeCollisiones(GamePanel gamePanel){

        this.gamePanel=gamePanel;
    }

    public void checkTile(Entidad entidad){
        int entityLeftWorldX= entidad.worldX+ entidad.solidBox.x;
        int entityRightWorldX= entidad.worldX+ entidad.solidBox.x+ entidad.solidBox.width;
        int entityUpWorldY= entidad.worldY+ entidad.solidBox.y;
        int entityDownWorldY= entidad.worldY+ entidad.solidBox.y+ entidad.solidBox.height;

        int entityLeftCol= entityLeftWorldX/gamePanel.tileSize;
        int entityRightCol=entityRightWorldX/gamePanel.tileSize;
        int entityUpRow=entityUpWorldY/gamePanel.tileSize;
        int entityDownRow=entityDownWorldY/gamePanel.tileSize;

        int tileNum1,tileNum2;
        switch(entidad.direction){
            case"up":
                entityUpRow=(entityUpWorldY- entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityLeftCol][entityUpRow];
                tileNum2=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityRightCol][entityUpRow];
                if(gamePanel.adminTextura.textura[tileNum1].collision==true|| gamePanel.adminTextura.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
            case"down":
                entityDownRow=(entityDownWorldY+ entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityLeftCol][entityDownRow];
                tileNum2=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityRightCol][entityDownRow];
                if(gamePanel.adminTextura.textura[tileNum1].collision==true|| gamePanel.adminTextura.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
            case"left":
                entityLeftCol=(entityLeftWorldX- entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityLeftCol][entityUpRow];
                tileNum2=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityLeftCol][entityDownRow];
                if(gamePanel.adminTextura.textura[tileNum1].collision==true|| gamePanel.adminTextura.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
            case"right":
                entityRightCol=(entityRightWorldX+ entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityRightCol][entityUpRow];
                tileNum2=gamePanel.adminTextura.mapaTexNum[gamePanel.mapaActual][entityRightCol][entityDownRow];
                if(gamePanel.adminTextura.textura[tileNum1].collision==true|| gamePanel.adminTextura.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
        }


    }
    public int checkObjeto(Entidad entidad,boolean player){
        int index=999;

        for(int i=0; i<gamePanel.obj[1].length;i++){
            if(gamePanel.obj[gamePanel.mapaActual][i]!=null){

                //Conseguir la posicion de la entidad
                entidad.solidBox.x= entidad.worldX+entidad.solidBox.x;
                entidad.solidBox.y= entidad.worldY+entidad.solidBox.y;
                //Conseguir la posicion del objeto
                gamePanel.obj[gamePanel.mapaActual][i].solidArea.x=gamePanel.obj[gamePanel.mapaActual][i].worldX+gamePanel.obj[gamePanel.mapaActual][i].solidArea.x;
                gamePanel.obj[gamePanel.mapaActual][i].solidArea.y=gamePanel.obj[gamePanel.mapaActual][i].worldY+gamePanel.obj[gamePanel.mapaActual][i].solidArea.y;

                switch(entidad.direction){
                    case "up":
                        entidad.solidBox.y-=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[gamePanel.mapaActual][i].solidArea)){
                            if (gamePanel.obj[gamePanel.mapaActual][i].collisionOn == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }

                        }
                        break;
                    case "down":
                        entidad.solidBox.y+=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[gamePanel.mapaActual][i].solidArea)){
                            if (gamePanel.obj[gamePanel.mapaActual][i].collisionOn == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }


                        }
                        break;
                    case "left":
                        entidad.solidBox.x-=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[gamePanel.mapaActual][i].solidArea)){
                            if (gamePanel.obj[gamePanel.mapaActual][i].collisionOn == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }


                        }
                        break;
                    case "right":
                        entidad.solidBox.x+=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[gamePanel.mapaActual][i].solidArea)){
                            if (gamePanel.obj[gamePanel.mapaActual][i].collisionOn == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }


                        }
                        break;

                }

                entidad.solidBox.x=entidad.areaSolidaDefaultX;
                entidad.solidBox.y=entidad.areaSolidaDefaultY;
                gamePanel.obj[gamePanel.mapaActual][i].solidArea.x=gamePanel.obj[gamePanel.mapaActual][i].areaSolidaDefaultX;
                gamePanel.obj[gamePanel.mapaActual][i].solidArea.y=gamePanel.obj[gamePanel.mapaActual][i].areaSolidaDefaultY;
            }
        }

        return index;

    }
    public int checkEntidad(Entidad entidad,Entidad[][] target){
        int index=999;

        for(int i=0; i<target[1].length;i++){
            if(target[gamePanel.mapaActual][i]!=null){

                //Conseguir la posicion de la entidad
                entidad.solidBox.x= entidad.worldX+entidad.solidBox.x;
                entidad.solidBox.y= entidad.worldY+entidad.solidBox.y;
                //Conseguir la posicion del npc
                target[gamePanel.mapaActual][i].solidBox.x=target[gamePanel.mapaActual][i].worldX+target[gamePanel.mapaActual][i].solidBox.x;
                target[gamePanel.mapaActual][i].solidBox.y=target[gamePanel.mapaActual][i].worldY+target[gamePanel.mapaActual][i].solidBox.y;

                switch(entidad.direction){
                    case "up":
                        entidad.solidBox.y-=entidad.speed;
                        if(entidad.solidBox.intersects(target[gamePanel.mapaActual][i].solidBox)){

                            entidad.collisionOn = true;

                            index=i;


                        }
                        break;
                    case "down":
                        entidad.solidBox.y+=entidad.speed;
                        if(entidad.solidBox.intersects(target[gamePanel.mapaActual][i].solidBox)){

                            entidad.collisionOn = true;

                            index=i;

                        }
                        break;
                    case "left":
                        entidad.solidBox.x-=entidad.speed;
                        if(entidad.solidBox.intersects(target[gamePanel.mapaActual][i].solidBox)){
                            entidad.collisionOn = true;

                            index=i;

                        }
                        break;
                    case "right":
                        entidad.solidBox.x+=entidad.speed;
                        if(entidad.solidBox.intersects(target[gamePanel.mapaActual][i].solidBox)){
                            entidad.collisionOn = true;

                            index=i;

                        }
                        break;

                }

                entidad.solidBox.x=entidad.areaSolidaDefaultX;
                entidad.solidBox.y=entidad.areaSolidaDefaultY;
                target[gamePanel.mapaActual][i].solidBox.x=target[gamePanel.mapaActual][i].areaSolidaDefaultX;
                target[gamePanel.mapaActual][i].solidBox.y=target[gamePanel.mapaActual][i].areaSolidaDefaultY;
            }
        }

        return index;


    }
    public void checkPlayer(Entidad entidad){
        //Conseguir la posicion de la entidad
        entidad.solidBox.x= entidad.worldX+entidad.solidBox.x;
        entidad.solidBox.y= entidad.worldY+entidad.solidBox.y;
        //Conseguir la posicion del jugador
        gamePanel.jugador.solidBox.x=gamePanel.jugador.worldX+gamePanel.jugador.solidBox.x;
        gamePanel.jugador.solidBox.y=gamePanel.jugador.worldY+gamePanel.jugador.solidBox.y;

        switch(entidad.direction){
            case "up":
                entidad.solidBox.y-=entidad.speed;
                if(entidad.solidBox.intersects(gamePanel.jugador.solidBox)){

                    entidad.collisionOn = true;

                }
                break;
            case "down":
                entidad.solidBox.y+=entidad.speed;
                if(entidad.solidBox.intersects(gamePanel.jugador.solidBox)){

                    entidad.collisionOn = true;



                }
                break;
            case "left":
                entidad.solidBox.x-=entidad.speed;
                if(entidad.solidBox.intersects(gamePanel.jugador.solidBox)){
                    entidad.collisionOn = true;


                }
                break;
            case "right":
                entidad.solidBox.x+=entidad.speed;
                if(entidad.solidBox.intersects(gamePanel.jugador.solidBox)){
                    entidad.collisionOn = true;


                }
                break;

        }

        entidad.solidBox.x=entidad.areaSolidaDefaultX;
        entidad.solidBox.y=entidad.areaSolidaDefaultY;
        gamePanel.jugador.solidBox.x=gamePanel.jugador.areaSolidaDefaultX;
        gamePanel.jugador.solidBox.y=gamePanel.jugador.areaSolidaDefaultY;
    }
}

