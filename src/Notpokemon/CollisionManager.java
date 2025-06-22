package Notpokemon;

import Entidades.Entity;

public class CollisionManager {
    GamePanel gamePanel;

    public CollisionManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX= entity.worldX+entity.solidBox.x;
        int entityRightWorldX= entity.worldX+entity.solidBox.x+entity.solidBox.width;
        int entityUpWorldY= entity.worldY+entity.solidBox.y;
        int entityDownWorldY=entity.worldY+entity.solidBox.y+entity.solidBox.height;

        int entityLeftCol= entityLeftWorldX/gamePanel.tileSize;
        int entityRightCol=entityRightWorldX/gamePanel.tileSize;
        int entityUpRow=entityUpWorldY/gamePanel.tileSize;
        int entityDownRow=entityDownWorldY/gamePanel.tileSize;

        int tileNum1,tileNum2;
        switch(entity.direction){
            case"up":
                entityUpRow=(entityUpWorldY-entity.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityLeftCol][entityUpRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityRightCol][entityUpRow];
                if(gamePanel.tileM.tile[tileNum1].collision==true|| gamePanel.tileM.tile[tileNum2].collision==true){
                    entity.collisionOn=true;
                }
                break;
            case"down":
                entityDownRow=(entityDownWorldY+entity.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityLeftCol][entityDownRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityRightCol][entityDownRow];
                if(gamePanel.tileM.tile[tileNum1].collision==true|| gamePanel.tileM.tile[tileNum2].collision==true){
                    entity.collisionOn=true;
                }
                break;
            case"left":
                entityLeftCol=(entityLeftWorldX-entity.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityLeftCol][entityUpRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityLeftCol][entityDownRow];
                if(gamePanel.tileM.tile[tileNum1].collision==true|| gamePanel.tileM.tile[tileNum2].collision==true){
                    entity.collisionOn=true;
                }
                break;
            case"right":
                entityRightCol=(entityRightWorldX+entity.speed)/gamePanel.tileSize;
                tileNum1=gamePanel.tileM.mapTileNum[entityRightCol][entityUpRow];
                tileNum2=gamePanel.tileM.mapTileNum[entityRightCol][entityDownRow];
                if(gamePanel.tileM.tile[tileNum1].collision==true|| gamePanel.tileM.tile[tileNum2].collision==true){
                    entity.collisionOn=true;
                }
                break;
        }


    }
}

