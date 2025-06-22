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
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        //Aqui se indica cuantos tiles unicos tenemos,si se añade más incrementar numero.
        tile = new Tile[17];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMapData("/maps/testMapDataXL.txt");
        //Escribir entre las comillas el mapa que quieras cargar.
        //OJO, el mapa xl es bastante grande, para ver texturas mejor usar el mapa testMapData1

    }
    public void getTileImage(){
        try{

            //pasto verde basico grass1
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass1.png"));

            //pasto verde con una florecita gigante grass2
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass2.png"));

            tile[2]= new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass3.png"));

            tile[3]= new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass4.png"));

            tile[4]= new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass4.png"));

            tile[5]=new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass5.png"));

            tile[6]=new Tile();
            tile[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass6.png"));

            tile[7]=new Tile();
            tile[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass7.png"));

            tile[8]=new Tile();
            tile[8].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass8.png"));

            tile[9]=new Tile();
            tile[9].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water1.png"));

            tile[10]=new Tile();
            tile[10].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water2.png"));

            //partes del puente
            tile[11]=new Tile();
            tile[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente2.png"));

            tile[12]=new Tile();
            tile[12].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente1.png"));

            tile[13]=new Tile();
            tile[13].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente3.png"));

            tile[14]=new Tile();
            tile[14].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente4.png"));

            tile[15]=new Tile();
            tile[15].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente5.png"));

            tile[16]=new Tile();
            tile[16].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charizard-megax.gif"));



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

            g2.drawImage(tile[tileNum].image,screenX,screenY, gamePanel.tileSize, gamePanel.tileSize, null);
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
