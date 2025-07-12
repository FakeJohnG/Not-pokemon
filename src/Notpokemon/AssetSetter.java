package Notpokemon;

import Entidades.NpcGuy;
import Objetos.Gema;

public class AssetSetter {
    GamePanel gamepanel;

    public AssetSetter(GamePanel gamepanel){
        this.gamepanel=gamepanel;
    }
    public void setObjecto(){
        int mapNum=0;
        gamepanel.obj[mapNum][0]=new Gema();
        gamepanel.obj[mapNum][0].worldX=gamepanel.tileSize*28;
        gamepanel.obj[mapNum][0].worldY=gamepanel.tileSize*22;

        mapNum=1;
        gamepanel.obj[mapNum][1]=new Gema();
        gamepanel.obj[mapNum][1].worldX=gamepanel.tileSize*7;
        gamepanel.obj[mapNum][1].worldY=gamepanel.tileSize*6;
    }
    public void setNpc(){
        int mapNum=0;
        gamepanel.npc[mapNum][0]=new NpcGuy(gamepanel);
        gamepanel.npc[mapNum][0].worldX=gamepanel.tileSize*25;
        gamepanel.npc[mapNum][0].worldY=gamepanel.tileSize*24;

    }
}
