package tile;



import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    public Textura[] textura;
    public int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        //Aqui se indica cuantos tiles unicos tenemos,si se añade más incrementar numero.
        textura = new Textura[25];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMapData("/maps/testMapDataXL.txt");
        //Escribir entre las comillas el mapa que quieras cargar.
        //OJO, el mapa xl es más grande y podria presentar problemas de rendimiento.


    }
    public void getTileImage(){
        try{

            //pasto verde basico grass1
            textura[0]=new Textura();
            textura[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass1.png"));

            //pasto verde con una florecita gigante grass2
            textura[1]=new Textura();
            textura[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass2.png"));

            textura[2]= new Textura();
            textura[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass3.png"));

            textura[3]= new Textura();
            textura[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass4.png"));

            textura[4]= new Textura();
            textura[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass4.png"));
            textura[4].collision=true;

            textura[5]=new Textura();
            textura[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass5.png"));
            textura[5].collision=true;

            textura[6]=new Textura();
            textura[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass6.png"));


            textura[7]=new Textura();
            textura[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass7.png"));
            textura[7].collision=true;

            textura[8]=new Textura();
            textura[8].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass8.png"));

            textura[9]=new Textura();
            textura[9].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water1.png"));
            textura[9].collision=true;

            textura[10]=new Textura();
            textura[10].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water2.png"));
            textura[10].collision=true;


            //partes del puente
            textura[11]=new Textura();
            textura[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente2.png"));

            textura[12]=new Textura();
            textura[12].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente1.png"));

            textura[13]=new Textura();
            textura[13].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente3.png"));

            textura[14]=new Textura();
            textura[14].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente4.png"));

            textura[15]=new Textura();
            textura[15].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente5.png"));

            textura[16]=new Textura();
            textura[16].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda1.png"));
            textura[16].collision=true;

            textura[17]=new Textura();
            textura[17].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda2.png"));
            textura[17].collision=true;

            textura[18]=new Textura();
            textura[18].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda3.png"));


            textura[19]=new Textura();
            textura[19].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda4.png"));
            textura[19].collision=true;

            textura[20]=new Textura();
            textura[20].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda5.png"));

            textura[21]=new Textura();
            textura[21].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda6.png"));
            //Puerta de la tienda! no puede llevar collision

            textura[22]=new Textura();
            textura[22].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda7.png"));
            textura[22].collision=true;

            textura[23]=new Textura();
            textura[23].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda8.png"));
            textura[23].collision=true;

            textura[24]=new Textura();
            textura[24].image= ImageIO.read(getClass().getResourceAsStream("/tiles/road1.png"));






        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMapData(String mapName){
        try{
            InputStream is =getClass().getResourceAsStream(mapName);
            BufferedReader reader =new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;
            while(col <gamePanel.maxWorldCol && row<gamePanel.maxWorldRow){
                String line= reader.readLine();

                while(col< gamePanel.maxWorldCol){
                    String numbers[]= line.split(" ");
                    int num = Integer.parseInt((numbers[col]));
                    mapTileNum[col][row]=num;
                    col++;
                }
                if(col == gamePanel.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            reader.close();
        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2){
        int worldCol =0;
        int worldRow=0;

        while(worldCol<gamePanel.maxWorldCol && worldRow <gamePanel.maxWorldRow){
            int tileNum =mapTileNum[worldCol][worldRow];
            int worldX=worldCol*gamePanel.tileSize;
            int worldY=worldRow* gamePanel.tileSize;
            int screenX =worldX-gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY=worldY-gamePanel.player.worldY + gamePanel.player.screenY;
            //Mejora de rendimiento?
            if(worldX + gamePanel.tileSize>gamePanel.player.worldX-gamePanel.player.screenX &&
                    worldX- gamePanel.tileSize <gamePanel.player.worldX+gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize>gamePanel.player.worldY- gamePanel.player.screenY &&
                    worldY - gamePanel.tileSize<gamePanel.player.worldY+ gamePanel.player.screenY){
                g2.drawImage(textura[tileNum].image,screenX,screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }
            worldCol++;


            if(worldCol == gamePanel.maxWorldCol){
                worldCol =0;
                worldRow++;

            }
        }
        //g2.drawImage(tile[0].image,0,0, gamePanel.tileSize, gamePanel.tileSize, null);
        //g2.drawImage(tile[1].image,100,100, gamePanel.tileSize, gamePanel.tileSize, null);




    }
}
