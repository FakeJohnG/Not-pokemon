package Notpokemon;

import Entidades.NpcGuy;
import Entidades.NpcTienda;
import Objetos.Gema;

public class AssetSetter {
    GamePanel gamepanel;

    public AssetSetter(GamePanel gamepanel){
        this.gamepanel=gamepanel;
    }
    public void setObjecto(){
        int mapNum=0;
        gamepanel.obj[mapNum][0]=new Gema();
        gamepanel.obj[mapNum][0].worldX=gamepanel.tileSize*43;
        gamepanel.obj[mapNum][0].worldY=gamepanel.tileSize*12;

        gamepanel.obj[mapNum][1]=new Gema();
        gamepanel.obj[mapNum][1].worldX=gamepanel.tileSize*38;
        gamepanel.obj[mapNum][1].worldY=gamepanel.tileSize*46;

        gamepanel.obj[mapNum][2]=new Gema();
        gamepanel.obj[mapNum][2].worldX=gamepanel.tileSize*14;
        gamepanel.obj[mapNum][2].worldY=gamepanel.tileSize*11;


    }
    public void setNpc(){
        int mapNum=0;
        gamepanel.npc[mapNum][0]=new NpcGuy(gamepanel);
        gamepanel.npc[mapNum][0].worldX=gamepanel.tileSize*25;
        gamepanel.npc[mapNum][0].worldY=gamepanel.tileSize*24;

        mapNum=1;
        gamepanel.npc[mapNum][1]=new NpcTienda(gamepanel);
        gamepanel.npc[mapNum][1].worldX=gamepanel.tileSize*7;
        gamepanel.npc[mapNum][1].worldY=gamepanel.tileSize*6;

    }
}
