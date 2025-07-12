package Notpokemon;

import Entidades.Entidad;

public class CollisionManager {
    GamePanel gamePanel;

    public CollisionManager(GamePanel gamePanel){
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
                tileNum1=gamePanel.tileM.mapTileNum[entityLeftCol][entityUpRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityRightCol][entityUpRow];
                if(gamePanel.tileM.textura[tileNum1].collision==true|| gamePanel.tileM.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
            case"down":
                entityDownRow=(entityDownWorldY+ entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityLeftCol][entityDownRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityRightCol][entityDownRow];
                if(gamePanel.tileM.textura[tileNum1].collision==true|| gamePanel.tileM.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
            case"left":
                entityLeftCol=(entityLeftWorldX- entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityLeftCol][entityUpRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityLeftCol][entityDownRow];
                if(gamePanel.tileM.textura[tileNum1].collision==true|| gamePanel.tileM.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
            case"right":
                entityRightCol=(entityRightWorldX+ entidad.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityRightCol][entityUpRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityRightCol][entityDownRow];
                if(gamePanel.tileM.textura[tileNum1].collision==true|| gamePanel.tileM.textura[tileNum2].collision==true){
                    entidad.collisionOn=true;
                }
                break;
        }


    }
    public int checkObjeto(Entidad entidad,boolean player){
        int index=999;

        for(int i=0; i<gamePanel.obj.length;i++){
            if(gamePanel.obj[i]!=null){

                //Conseguir la posicion de la entidad
                entidad.solidBox.x= entidad.worldX+entidad.solidBox.x;
                entidad.solidBox.y= entidad.worldY+entidad.solidBox.y;
                //Conseguir la posicion del objeto
                gamePanel.obj[i].solidArea.x=gamePanel.obj[i].worldX+gamePanel.obj[i].solidArea.x;
                gamePanel.obj[i].solidArea.y=gamePanel.obj[i].worldY+gamePanel.obj[i].solidArea.y;

                switch(entidad.direction){
                    case "up":
                        entidad.solidBox.y-=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }

                        }
                        break;
                    case "down":
                        entidad.solidBox.y+=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }


                        }
                        break;
                    case "left":
                        entidad.solidBox.x-=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }


                        }
                        break;
                    case "right":
                        entidad.solidBox.x+=entidad.speed;
                        if(entidad.solidBox.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true) {
                                entidad.collisionOn = true;
                            }if(player==true){
                                index=i;
                            }


                        }
                        break;

                }

                entidad.solidBox.x=entidad.areaSolidaDefaultX;
                entidad.solidBox.y=entidad.areaSolidaDefaultY;
                gamePanel.obj[i].solidArea.x=gamePanel.obj[i].areaSolidaDefaultX;
                gamePanel.obj[i].solidArea.y=gamePanel.obj[i].areaSolidaDefaultY;
            }
        }

        return index;

    }
}

