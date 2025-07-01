package Notpokemon;

import Objetos.Gema;

public class AssetSetter {
    GamePanel gamepanel;

    public AssetSetter(GamePanel gamepanel){
        this.gamepanel=gamepanel;
    }
    public void setObjecto(){
        gamepanel.obj[0]=new Gema();
        gamepanel.obj[0].worldX=gamepanel.tileSize*24;
        gamepanel.obj[0].worldY=gamepanel.tileSize*22;

        gamepanel.obj[1]=new Gema();
        gamepanel.obj[1].worldX=gamepanel.tileSize*25;
        gamepanel.obj[1].worldY=gamepanel.tileSize*22;
    }
}
