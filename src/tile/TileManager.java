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
    public int mapaTexNum[][][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        //Aqui se indica cuantos tiles unicos tenemos,si se añade más incrementar numero.
        textura = new Textura[74];
        mapaTexNum = new int[gamePanel.mapaMax][gamePanel.maxWorldCol][gamePanel.maxWorldFila];
        getTileImage();
        loadMapData("/maps/testMapDataXL.txt",0);
        loadMapData("/maps/testMapData1.txt",1);



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
            textura[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/colisioncamino.png"));

            textura[12]=new Textura();
            textura[12].image= ImageIO.read(getClass().getResourceAsStream("/tiles/road2.png"));

            textura[13]=new Textura();
            textura[13].image= ImageIO.read(getClass().getResourceAsStream("/tiles/puente3.png"));

            textura[14]=new Textura();
            textura[14].image= ImageIO.read(getClass().getResourceAsStream("/tiles/buzon1.png"));
            textura[14].collision=true;

            textura[15]=new Textura();
            textura[15].image= ImageIO.read(getClass().getResourceAsStream("/tiles/buzon2.png"));
            textura[15].collision=true;

            textura[16]=new Textura();
            textura[16].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda1.png"));
            textura[16].collision=true;

            textura[17]=new Textura();
            textura[17].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda2.png"));
            textura[17].collision=true;

            textura[18]=new Textura();
            textura[18].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda3.png"));
            //Puerta de la tienda! no puede llevar collision


            textura[19]=new Textura();
            textura[19].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda4.png"));
            textura[19].collision=true;

            textura[20]=new Textura();
            textura[20].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda5.png"));
            textura[20].collision=true;

            textura[21]=new Textura();
            textura[21].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda6.png"));


            textura[22]=new Textura();
            textura[22].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda7.png"));


            textura[23]=new Textura();
            textura[23].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tienda8.png"));


            textura[24]=new Textura();
            textura[24].image= ImageIO.read(getClass().getResourceAsStream("/tiles/road1.png"));

            textura[25]=new Textura();
            textura[25].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass9.png"));
            textura[25].collision=true;

            textura[26]=new Textura();
            textura[26].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho1.png"));
            textura[26].collision=true;

            textura[27]=new Textura();
            textura[27].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho2.png"));
            textura[27].collision=true;

            textura[28]=new Textura();
            textura[28].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho3.png"));
            textura[28].collision=true;

            textura[29]=new Textura();
            textura[29].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho4.png"));
            textura[29].collision=true;

            textura[30]=new Textura();
            textura[30].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho5.png"));
            textura[30].collision=true;

            textura[31]=new Textura();
            textura[31].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho6.png"));
            textura[31].collision=true;

            textura[32]=new Textura();
            textura[32].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho7.png"));
            textura[32].collision=true;

            textura[33]=new Textura();
            textura[33].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tiendatecho8.png"));
            textura[33].collision=true;

            textura[34]=new Textura();
            textura[34].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa1.png"));
            textura[34].collision=true;

            textura[35]=new Textura();
            textura[35].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa234.png"));
            textura[35].collision=true;

            textura[36]=new Textura();
            textura[36].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa5.png"));
            textura[36].collision=true;

            textura[37]=new Textura();
            textura[37].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa6.png"));
            textura[37].collision=true;

            textura[38]=new Textura();
            textura[38].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa789.png"));
            textura[38].collision=true;

            textura[39]=new Textura();
            textura[39].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa10.png"));
            textura[39].collision=true;

            textura[40]=new Textura();
            textura[40].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa11.png"));
            textura[40].collision=true;

            textura[41]=new Textura();
            textura[41].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa12.png"));
            textura[41].collision=true;

            textura[42]=new Textura();
            textura[42].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa13.png"));
            textura[42].collision=true;

            textura[43]=new Textura();
            textura[43].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa14.png"));

            textura[44]=new Textura();
            textura[44].image= ImageIO.read(getClass().getResourceAsStream("/tiles/casa15.png"));
            textura[44].collision=true;

            textura[45]=new Textura();
            textura[45].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab1.png"));
            textura[45].collision=true;

            textura[46]=new Textura();
            textura[46].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab2.png"));
            textura[46].collision=true;

            textura[47]=new Textura();
            textura[47].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab3.png"));
            textura[47].collision=true;

            textura[48]=new Textura();
            textura[48].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab4.png"));
            textura[48].collision=true;

            textura[49]=new Textura();
            textura[49].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab5.png"));
            textura[49].collision=true;

            textura[50]=new Textura();
            textura[50].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab6.png"));
            textura[50].collision=true;

            textura[51]=new Textura();
            textura[51].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab7.png"));
            textura[51].collision=true;

            textura[52]=new Textura();
            textura[52].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab8.png"));
            textura[52].collision=true;

            textura[53]=new Textura();
            textura[53].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab9.png"));
            textura[53].collision=true;

            textura[54]=new Textura();
            textura[54].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab10.png"));
            textura[54].collision=true;

            textura[55]=new Textura();
            textura[55].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab11.png"));
            textura[55].collision=true;

            textura[56]=new Textura();
            textura[56].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab12.png"));
            textura[56].collision=true;

            textura[57]=new Textura();
            textura[57].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab13.png"));
            textura[57].collision=true;

            textura[58]=new Textura();
            textura[58].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab14.png"));
            textura[58].collision=true;

            textura[59]=new Textura();
            textura[59].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab15.png"));
            textura[59].collision=true;

            textura[60]=new Textura();
            textura[60].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab16.png"));
            textura[60].collision=true;

            textura[61]=new Textura();
            textura[61].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab17.png"));
            textura[61].collision=true;

            textura[62]=new Textura();
            textura[62].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab18.png"));

            textura[63]=new Textura();
            textura[63].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab19.png"));
            textura[63].collision=true;

            textura[64]=new Textura();
            textura[64].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab20.png"));
            textura[64].collision=true;

            textura[65]=new Textura();
            textura[65].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab21.png"));
            textura[65].collision=true;

            textura[66]=new Textura();
            textura[66].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab22.png"));
            textura[66].collision=true;

            textura[67]=new Textura();
            textura[67].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab23.png"));
            textura[67].collision=true;

            textura[68]=new Textura();
            textura[68].image= ImageIO.read(getClass().getResourceAsStream("/tiles/lab24.png"));
            textura[68].collision=true;

            textura[69]=new Textura();
            textura[69].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbusto1.png"));
            textura[69].collision=true;

            textura[70]=new Textura();
            textura[70].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbusto2.png"));
            textura[70].collision=true;

            textura[71]=new Textura();
            textura[71].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbusto3.png"));
            textura[71].collision=true;

            textura[72]=new Textura();
            textura[72].image= ImageIO.read(getClass().getResourceAsStream("/tiles/decoracion1.png"));
            textura[72].collision=true;

            textura[73]=new Textura();
            textura[73].image= ImageIO.read(getClass().getResourceAsStream("/tiles/decoracion2.png"));
            textura[73].collision=true;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMapData(String mapName,int numero){
        try{
            InputStream is =getClass().getResourceAsStream(mapName);
            BufferedReader reader =new BufferedReader(new InputStreamReader(is));
            int col=0;
            int fila=0;
            while(col <gamePanel.maxWorldCol && fila<gamePanel.maxWorldFila){
                String line= reader.readLine();

                while(col< gamePanel.maxWorldCol){
                    String numbers[]= line.split(" ");
                    int num = Integer.parseInt((numbers[col]));
                    mapaTexNum[numero][col][fila]=num;
                    col++;
                }
                if(col == gamePanel.maxWorldCol){
                    col=0;
                    fila++;
                }
            }
            reader.close();
        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2){
        int worldCol =0;
        int worldRow=0;

        while(worldCol<gamePanel.maxWorldCol && worldRow <gamePanel.maxWorldFila){
            int tileNum = mapaTexNum[gamePanel.mapaActual][worldCol][worldRow];
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