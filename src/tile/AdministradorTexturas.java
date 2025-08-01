package tile;



import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdministradorTexturas {
    GamePanel gamePanel;
    public Textura[] textura;
    public int mapaTexNum[][][];

    public AdministradorTexturas(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        //Aqui se indica cuantos tiles unicos tenemos,si se añade más incrementar numero.
        textura = new Textura[332];
        mapaTexNum = new int[gamePanel.mapaMax][gamePanel.maxWorldCol][gamePanel.maxWorldFila];
        getTileImage();
        //Mapas en el juego, se debe incluir el file path del archivo y un numero unico para el mapa
        loadMapData("/maps/testMapDataXL.txt",0);
        loadMapData("/maps/testMapData1.txt",1);
        loadMapData("/maps/testMapData2.txt",2);
        loadMapData("/maps/testMapitaData3.txt",3);




    }
    public void getTileImage(){
        //Aqui se consigue de la carpeta res todas las texturas que el juego debe dibujar
        //Añadiendo el atributo .collision=true se le dice al juego que tiene collision esa textura
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

            //Arbol
            textura[4]= new Textura();
            textura[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass4.png"));
            textura[4].collision=true;

            textura[5]=new Textura();
            textura[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass5.png"));
            textura[5].collision=true;

            textura[6]=new Textura();
            textura[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass6.png"));


            textura[7]=new Textura();
            textura[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/letrero.png"));
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
            textura[11].collision=true;

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


            //EDIFICIOS
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
            textura[43].collision=true;

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

            textura[74]=new Textura();
            textura[74].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino1.png"));

            textura[75]=new Textura();
            textura[75].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino2.png"));

            textura[76]=new Textura();
            textura[76].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino3.png"));

            textura[77]=new Textura();
            textura[77].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino4.png"));

            textura[78]=new Textura();
            textura[78].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino5.png"));

            textura[79]=new Textura();
            textura[79].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino6.png"));

            textura[80]=new Textura();
            textura[80].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino7.png"));

            textura[81]=new Textura();
            textura[81].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Camino8.png"));

            textura[82]=new Textura();
            textura[82].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbol1.png"));
            textura[82].collision=true;

            textura[83]=new Textura();
            textura[83].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbol2.png"));
            textura[83].collision=true;

            textura[84]=new Textura();
            textura[84].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbol3.png"));
            textura[84].collision=true;

            textura[85]=new Textura();
            textura[85].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbol4.png"));
            textura[85].collision=true;

            textura[86]=new Textura();
            textura[86].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbol5.png"));
            textura[86].collision=true;

            textura[87]=new Textura();
            textura[87].image= ImageIO.read(getClass().getResourceAsStream("/tiles/arbol6.png"));
            textura[87].collision=true;

            textura[88]=new Textura();
            textura[88].image= ImageIO.read(getClass().getResourceAsStream("/tiles/agua3.png"));
            textura[88].collision=true;

            textura[89]=new Textura();
            textura[89].image= ImageIO.read(getClass().getResourceAsStream("/tiles/agua4.png"));
            textura[89].collision=true;

            textura[90]=new Textura();
            textura[90].image= ImageIO.read(getClass().getResourceAsStream("/tiles/agua5.png"));
            textura[90].collision=true;

            textura[91]=new Textura();
            textura[91].image= ImageIO.read(getClass().getResourceAsStream("/tiles/muelle1.png"));

            textura[92]=new Textura();
            textura[92].image= ImageIO.read(getClass().getResourceAsStream("/tiles/muelle2.png"));

            textura[93]=new Textura();
            textura[93].image= ImageIO.read(getClass().getResourceAsStream("/tiles/muelle3.png"));

            textura[94]=new Textura();
            textura[94].image= ImageIO.read(getClass().getResourceAsStream("/tiles/muelle4.png"));
            textura[94].collision=true;

            textura[95]=new Textura();
            textura[95].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco1.png"));

            textura[96]=new Textura();
            textura[96].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco2.png"));

            textura[97]=new Textura();
            textura[97].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco3.png"));

            textura[98]=new Textura();
            textura[98].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco4.png"));

            textura[99]=new Textura();
            textura[99].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco5.png"));

            textura[100]=new Textura();
            textura[100].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco6.png"));

            textura[101]=new Textura();
            textura[101].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco7.png"));

            textura[102]=new Textura();
            textura[102].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco8.png"));

            textura[103]=new Textura();
            textura[103].image= ImageIO.read(getClass().getResourceAsStream("/tiles/charco9.png"));

            textura[104]=new Textura();
            textura[104].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Pidgey.png"));
            textura[104].collision=true;

            textura[105]=new Textura();
            textura[105].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Lapras.png"));
            textura[105].collision=true;

            textura[106]=new Textura();
            textura[106].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca1.png"));
            textura[106].collision=true;

            textura[107]=new Textura();
            textura[107].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca2.png"));
            textura[107].collision=true;

            textura[108]=new Textura();
            textura[108].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca3.png"));
            textura[108].collision=true;

            textura[109]=new Textura();
            textura[109].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca4.png"));
            textura[109].collision=true;

            textura[110]=new Textura();
            textura[110].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca5.png"));
            textura[110].collision=true;

            textura[111]=new Textura();
            textura[111].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca6.png"));
            textura[111].collision=true;

            textura[112]=new Textura();
            textura[112].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Roca7.png"));
            textura[112].collision=true;

            textura[113]=new Textura();
            textura[113].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra1.png"));

            textura[114]=new Textura();
            textura[114].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra2.png"));

            textura[115]=new Textura();
            textura[115].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra3.png"));

            textura[116]=new Textura();
            textura[116].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra4.png"));

            textura[117]=new Textura();
            textura[117].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra5.png"));

            textura[118]=new Textura();
            textura[118].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra6.png"));

            textura[119]=new Textura();
            textura[119].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra7.png"));

            textura[120]=new Textura();
            textura[120].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra8.png"));

            textura[121]=new Textura();
            textura[121].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Tierra9.png"));

            textura[122]=new Textura();
            textura[122].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Piedra.png"));
            textura[122].collision=true;

            textura[123]=new Textura();
            textura[123].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador0.png"));
            textura[123].collision=true;

            textura[124]=new Textura();
            textura[124].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador1.png"));
            textura[124].collision=true;

            textura[125]=new Textura();
            textura[125].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador2.png"));
            textura[125].collision=true;

            textura[126]=new Textura();
            textura[126].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador3.png"));
            textura[126].collision=true;

            textura[127]=new Textura();
            textura[127].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador4.png"));
            textura[127].collision=true;

            textura[128]=new Textura();
            textura[128].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador5.png"));
            textura[128].collision=true;

            textura[129]=new Textura();
            textura[129].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador6.png"));
            textura[129].collision=true;

            textura[130]=new Textura();
            textura[130].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador7.png"));
            textura[130].collision=true;

            textura[131]=new Textura();
            textura[131].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador8.png"));
            textura[131].collision=true;

            textura[132]=new Textura();
            textura[132].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador9.png"));
            textura[132].collision=true;

            textura[133]=new Textura();
            textura[133].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador10.png"));
            textura[133].collision=true;

            textura[134]=new Textura();
            textura[134].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador11.png"));
            textura[134].collision=true;

            textura[135]=new Textura();
            textura[135].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador12.png"));
            textura[135].collision=true;

            textura[136]=new Textura();
            textura[136].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador13.png"));
            textura[136].collision=true;

            textura[137]=new Textura();
            textura[137].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador14.png"));
            textura[137].collision=true;

            textura[138]=new Textura();
            textura[138].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador15.png"));
            textura[138].collision=true;

            textura[139]=new Textura();
            textura[139].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador16.png"));

            textura[140]=new Textura();
            textura[140].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador17.png"));
            textura[140].collision=true;

            textura[141]=new Textura();
            textura[141].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador18.png"));
            textura[141].collision=true;

            textura[142]=new Textura();
            textura[142].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CasaJugador19.png"));
            textura[142].collision=true;

            //APARTADO DE TILES PARA TIENDA
                //Pared-Objetos
            textura[143]=new Textura();
            textura[143].image= ImageIO.read(getClass().getResourceAsStream("/tiles/rellenoTienda.png"));
            textura[143].collision=true;

            textura[144]=new Textura();
            textura[144].image= ImageIO.read(getClass().getResourceAsStream("/tiles/VentilacionTienda1.png"));
            textura[144].collision=true;

            textura[145]=new Textura();
            textura[145].image= ImageIO.read(getClass().getResourceAsStream("/tiles/VentilacionTienda2.png"));
            textura[145].collision=true;

            textura[146]=new Textura();
            textura[146].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PuertaTienda1.png"));
            textura[146].collision=true;

            textura[147]=new Textura();
            textura[147].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PuertaTienda11.png"));
            textura[147].collision=true;

            textura[148]=new Textura();
            textura[148].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PuertaTienda12.png"));
            textura[148].collision=true;

            textura[149]=new Textura();
            textura[149].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PuertaTienda2.png"));
            textura[149].collision=true;

            textura[150]=new Textura();
            textura[150].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PuertaTienda21.png"));
            textura[150].collision=true;

            textura[151]=new Textura();
            textura[151].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PuertaTienda22.png"));
            textura[151].collision=true;

                //Pared-Pared
            textura[152]=new Textura();
            textura[152].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda1.png"));
            textura[152].collision=true;

            textura[153]=new Textura();
            textura[153].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda11.png"));
            textura[153].collision=true;

            textura[154]=new Textura();
            textura[154].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda12.png"));
            textura[154].collision=true;

            textura[155]=new Textura();
            textura[155].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda2.png"));
            textura[155].collision=true;

            textura[156]=new Textura();
            textura[156].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda21.png"));
            textura[156].collision=true;

            textura[157]=new Textura();
            textura[157].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda22.png"));
            textura[157].collision=true;

            textura[158]=new Textura();
            textura[158].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda3.png"));
            textura[158].collision=true;

            textura[159]=new Textura();
            textura[159].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda31.png"));
            textura[159].collision=true;

            textura[160]=new Textura();
            textura[160].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda32.png"));
            textura[160].collision=true;

            textura[161]=new Textura();
            textura[161].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda4.png"));
            textura[161].collision=true;

            textura[162]=new Textura();
            textura[162].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda41.png"));
            textura[162].collision=true;

            textura[163]=new Textura();
            textura[163].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda42.png"));
            textura[163].collision=true;

            textura[164]=new Textura();
            textura[164].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda5.png"));
            textura[164].collision=true;

            textura[165]=new Textura();
            textura[165].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda51.png"));
            textura[165].collision=true;

            textura[166]=new Textura();
            textura[166].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda52.png"));
            textura[166].collision=true;

            textura[167]=new Textura();
            textura[167].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda6.png"));
            textura[167].collision=true;

            textura[168]=new Textura();
            textura[168].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda61.png"));
            textura[168].collision=true;

            textura[169]=new Textura();
            textura[169].image= ImageIO.read(getClass().getResourceAsStream("/tiles/ParedTienda62.png"));
            textura[169].collision=true;

                //Piso-Piso
            textura[170]=new Textura();
            textura[170].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda1.png"));

            textura[171]=new Textura();
            textura[171].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda11.png"));

            textura[172]=new Textura();
            textura[172].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda12.png"));

            textura[173]=new Textura();
            textura[173].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda2.png"));

            textura[174]=new Textura();
            textura[174].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda21.png"));

            textura[175]=new Textura();
            textura[175].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda22.png"));

            textura[176]=new Textura();
            textura[176].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda3.png"));

            textura[177]=new Textura();
            textura[177].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda31.png"));

            textura[178]=new Textura();
            textura[178].image= ImageIO.read(getClass().getResourceAsStream("/tiles/PisoTienda32.png"));

                //Piso-Objetos
            textura[179]=new Textura();
            textura[179].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CounterTienda1.png"));
            textura[179].collision=true;

            textura[180]=new Textura();
            textura[180].image= ImageIO.read(getClass().getResourceAsStream("/tiles/CounterTienda2.png"));
            textura[180].collision=true;

            //Interior de casa del protagonista
            textura[181]=new Textura();
            textura[181].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa01.png"));
            textura[181].collision=true;

            textura[182]=new Textura();
            textura[182].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa02.png"));
            textura[182].collision=true;

            textura[183]=new Textura();
            textura[183].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa03.png"));
            textura[183].collision=true;

            textura[184]=new Textura();
            textura[184].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa04.png"));
            textura[184].collision=true;

            textura[185]=new Textura();
            textura[185].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa05.png"));
            textura[185].collision=true;

            textura[186]=new Textura();
            textura[186].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa06.png"));
            textura[186].collision=true;

            textura[187]=new Textura();
            textura[187].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa07.png"));
            textura[187].collision=true;

            textura[188]=new Textura();
            textura[188].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa08.png"));
            textura[188].collision=true;

            textura[189]=new Textura();
            textura[189].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa09.png"));
            textura[189].collision=true;

            textura[190]=new Textura();
            textura[190].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa10.png"));
            textura[190].collision=true;

            textura[191]=new Textura();
            textura[191].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa11.png"));
            textura[191].collision=true;

            textura[192]=new Textura();
            textura[192].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa12.png"));
            textura[192].collision=true;

            textura[193]=new Textura();
            textura[193].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa13.png"));
            textura[193].collision=true;

            textura[194]=new Textura();
            textura[194].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa14.png"));
            textura[194].collision=true;

            textura[195]=new Textura();
            textura[195].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa15.png"));
            textura[195].collision=true;

            textura[196]=new Textura();
            textura[196].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa16.png"));
            textura[196].collision=true;

            textura[197]=new Textura();
            textura[197].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa17.png"));
            textura[197].collision=true;

            textura[198]=new Textura();
            textura[198].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa18.png"));
            textura[198].collision=true;

            textura[199]=new Textura();
            textura[199].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa19.png"));
            textura[199].collision=true;

            textura[200]=new Textura();
            textura[200].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa20.png"));
            textura[200].collision=true;

            textura[201]=new Textura();
            textura[201].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa21.png"));
            textura[201].collision=true;

            textura[202]=new Textura();
            textura[202].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa22.png"));
            textura[202].collision=true;

            textura[203]=new Textura();
            textura[203].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa23.png"));
            textura[203].collision=true;

            textura[204]=new Textura();
            textura[204].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa24.png"));
            textura[204].collision=true;

            textura[205]=new Textura();
            textura[205].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa25.png"));
            textura[205].collision=true;

            textura[206]=new Textura();
            textura[206].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa26.png"));
            textura[206].collision=true;

            textura[207]=new Textura();
            textura[207].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa27.png"));
            textura[207].collision=true;

            textura[208]=new Textura();
            textura[208].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa28.png"));
            textura[208].collision=true;

            textura[209]=new Textura();
            textura[209].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa29.png"));
            textura[209].collision=true;

            textura[210]=new Textura();
            textura[210].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa30.png"));
            textura[210].collision=true;

            textura[211]=new Textura();
            textura[211].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa31.png"));
            textura[211].collision=true;

            textura[212]=new Textura();
            textura[212].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa32.png"));


            textura[213]=new Textura();
            textura[213].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa33.png"));
            textura[213].collision=true;

            textura[214]=new Textura();
            textura[214].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa34.png"));


            textura[215]=new Textura();
            textura[215].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa35.png"));


            textura[216]=new Textura();
            textura[216].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa36.png"));


            textura[217]=new Textura();
            textura[217].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa37.png"));
            textura[217].collision=true;

            textura[218]=new Textura();
            textura[218].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa38.png"));
            textura[218].collision=true;

            textura[219]=new Textura();
            textura[219].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa39.png"));
            textura[219].collision=true;

            textura[220]=new Textura();
            textura[220].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa40.png"));
            textura[220].collision=true;

            textura[221]=new Textura();
            textura[221].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa41.png"));


            textura[222]=new Textura();
            textura[222].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa42.png"));


            textura[223]=new Textura();
            textura[223].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa43.png"));


            textura[224]=new Textura();
            textura[224].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa44.png"));


            textura[225]=new Textura();
            textura[225].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa45.png"));


            textura[226]=new Textura();
            textura[226].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa46.png"));


            textura[227]=new Textura();
            textura[227].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa47.png"));


            textura[228]=new Textura();
            textura[228].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa48.png"));


            textura[229]=new Textura();
            textura[229].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa49.png"));


            textura[230]=new Textura();
            textura[230].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa50.png"));
            textura[230].collision=true;

            textura[231]=new Textura();
            textura[231].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa51.png"));
            textura[231].collision=true;

            textura[232]=new Textura();
            textura[232].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa52.png"));
            textura[232].collision=true;

            textura[233]=new Textura();
            textura[233].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa53.png"));
            textura[233].collision=true;

            textura[234]=new Textura();
            textura[234].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa54.png"));


            textura[235]=new Textura();
            textura[235].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa55.png"));


            textura[236]=new Textura();
            textura[236].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa56.png"));


            textura[237]=new Textura();
            textura[237].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa57.png"));


            textura[238]=new Textura();
            textura[238].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa58.png"));
            textura[238].collision=true;

            textura[239]=new Textura();
            textura[239].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa59.png"));
            textura[239].collision=true;

            textura[240]=new Textura();
            textura[240].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa60.png"));
            textura[240].collision=true;

            textura[241]=new Textura();
            textura[241].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa61.png"));
            textura[241].collision=true;

            textura[242]=new Textura();
            textura[242].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa62.png"));


            textura[243]=new Textura();
            textura[243].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa63.png"));


            textura[244]=new Textura();
            textura[244].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa64.png"));


            textura[245]=new Textura();
            textura[245].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa65.png"));


            textura[246]=new Textura();
            textura[246].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa66.png"));
            textura[246].collision=true;

            textura[247]=new Textura();
            textura[247].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa67.png"));


            textura[248]=new Textura();
            textura[248].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa68.png"));


            textura[249]=new Textura();
            textura[249].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa69.png"));


            textura[250]=new Textura();
            textura[250].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa70.png"));


            textura[251]=new Textura();
            textura[251].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa71.png"));
            textura[251].collision=true;

            textura[252]=new Textura();
            textura[252].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa72.png"));
            textura[252].collision=true;

            textura[253]=new Textura();
            textura[253].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa73.png"));
            textura[253].collision=true;

            textura[254]=new Textura();
            textura[254].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa74.png"));
            textura[254].collision=true;

            textura[255]=new Textura();
            textura[255].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa75.png"));


            textura[256]=new Textura();
            textura[256].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa76.png"));


            textura[257]=new Textura();
            textura[257].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa77.png"));


            textura[258]=new Textura();
            textura[258].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa78.png"));


            textura[259]=new Textura();
            textura[259].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa79.png"));
            textura[259].collision=true;

            textura[260]=new Textura();
            textura[260].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa80.png"));
            textura[260].collision=true;

            textura[261]=new Textura();
            textura[261].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa81.png"));


            textura[262]=new Textura();
            textura[262].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa82.png"));


            textura[263]=new Textura();
            textura[263].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa83.png"));


            textura[264]=new Textura();
            textura[264].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa84.png"));


            textura[265]=new Textura();
            textura[265].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa85.png"));


            textura[266]=new Textura();
            textura[266].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa86.png"));


            textura[267]=new Textura();
            textura[267].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa87.png"));


            textura[268]=new Textura();
            textura[268].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa88.png"));


            textura[269]=new Textura();
            textura[269].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa89.png"));


            textura[270]=new Textura();
            textura[270].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa90.png"));
            textura[270].collision=true;

            textura[271]=new Textura();
            textura[271].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa91.png"));
            textura[271].collision=true;

            textura[272]=new Textura();
            textura[272].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa92.png"));
            textura[272].collision=true;

            textura[273]=new Textura();
            textura[273].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa93.png"));
            textura[273].collision=true;

            textura[274]=new Textura();
            textura[274].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa94.png"));

            textura[275]=new Textura();
            textura[275].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa95.png"));


            textura[276]=new Textura();
            textura[276].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa96.png"));


            textura[277]=new Textura();
            textura[277].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa97.png"));


            textura[278]=new Textura();
            textura[278].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa98.png"));


            textura[279]=new Textura();
            textura[279].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa99.png"));


            textura[280]=new Textura();
            textura[280].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa100.png"));


            textura[281]=new Textura();
            textura[281].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa101.png"));


            textura[282]=new Textura();
            textura[282].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa102.png"));


            textura[283]=new Textura();
            textura[283].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa103.png"));


            textura[284]=new Textura();
            textura[284].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa104.png"));
            textura[284].collision=true;

            textura[285]=new Textura();
            textura[285].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa105.png"));
            textura[285].collision=true;

            textura[286]=new Textura();
            textura[286].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa106.png"));


            textura[287]=new Textura();
            textura[287].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa107.png"));


            textura[288]=new Textura();
            textura[288].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa108.png"));


            textura[289]=new Textura();
            textura[289].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa109.png"));


            textura[290]=new Textura();
            textura[290].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa110.png"));


            textura[291]=new Textura();
            textura[291].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa111.png"));


            textura[292]=new Textura();
            textura[292].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa112.png"));


            textura[293]=new Textura();
            textura[293].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa113.png"));


            textura[294]=new Textura();
            textura[294].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa114.png"));


            textura[295]=new Textura();
            textura[295].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa115.png"));


            textura[296]=new Textura();
            textura[296].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa116.png"));


            textura[297]=new Textura();
            textura[297].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa117.png"));


            textura[298]=new Textura();
            textura[298].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa118.png"));
            textura[298].collision=true;

            textura[299]=new Textura();
            textura[299].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa119.png"));
            textura[299].collision=true;

            textura[300]=new Textura();
            textura[300].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa120.png"));
            textura[300].collision=true;

            textura[301]=new Textura();
            textura[301].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa121.png"));
            textura[301].collision=true;

            textura[302]=new Textura();
            textura[302].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa122.png"));
            textura[302].collision=true;

            textura[303]=new Textura();
            textura[303].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa123.png"));
            textura[303].collision=true;

            textura[304]=new Textura();
            textura[304].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa124.png"));
            textura[304].collision=true;

            textura[305]=new Textura();
            textura[305].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa125.png"));
            textura[305].collision=true;

            textura[306]=new Textura();
            textura[306].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa126.png"));
            textura[306].collision=true;

            textura[307]=new Textura();
            textura[307].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa127.png"));
            textura[307].collision=true;

            textura[308]=new Textura();
            textura[308].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa128.png"));
            textura[308].collision=true;

            textura[309]=new Textura();
            textura[309].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa129.png"));
            textura[309].collision=true;

            textura[310]=new Textura();
            textura[310].image= ImageIO.read(getClass().getResourceAsStream("/tiles/InteriorCasa130.png"));
            textura[310].collision=true;

            //Tiles de lab

            textura[311] = new Textura();
            textura[311].image = ImageIO.read(getClass().getResourceAsStream("/tiles/PisoLab.png"));

            textura[312]= new Textura();
            textura[312].image = ImageIO.read(getClass().getResourceAsStream("/tiles/paredLab.png"));
            textura[312].collision=true;

            textura[313] = new Textura();
            textura[313].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fonditoBranco.png"));

            textura[314] = new Textura();
            textura[314].image = ImageIO.read(getClass().getResourceAsStream("/tiles/microondasLab.png"));
            textura[314].collision=true;

            textura[315] = new Textura();
            textura[315].image = ImageIO.read(getClass().getResourceAsStream("/tiles/limiteLab.png"));
            textura[315].collision=true;

            textura[316] = new Textura();
            textura[316].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Libreria2.png"));
            textura[316].collision=true;
            //Libreria2

            textura[317] = new Textura();
            textura[317].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mesaLab.png"));
            textura[317].collision=true;
            //mesalab

            textura[318] = new Textura();
            textura[318].image = ImageIO.read(getClass().getResourceAsStream("/tiles/MaquinaLab1.png"));
            textura[318].collision=true;
            //Maquinalab1

            textura[319] = new Textura();
            textura[319].image = ImageIO.read(getClass().getResourceAsStream("/tiles/MaquinaLab2.png"));
            textura[319].collision=true;
            //Maquinalab2

            textura[320] = new Textura();
            textura[320].image = ImageIO.read(getClass().getResourceAsStream("/tiles/PortaLab.png"));

            textura[321] = new Textura();
            textura[321].image = ImageIO.read(getClass().getResourceAsStream("/tiles/AlfombritaLab.png"));

            textura[322] = new Textura();
            textura[322].image = ImageIO.read(getClass().getResourceAsStream("/tiles/cadeiraPokeLab1.png"));
            textura[322].collision=true;

            textura[323] = new Textura();
            textura[323].image = ImageIO.read(getClass().getResourceAsStream("/tiles/cadeiraPokeLab2.png"));
            textura[323].collision=true;

            textura[324] = new Textura();
            textura[324].image = ImageIO.read(getClass().getResourceAsStream("/tiles/carpetasLab.png"));
            textura[324].collision=true;

            textura[325] = new Textura();
            textura[325].image = ImageIO.read(getClass().getResourceAsStream("/tiles/chichiLab.png"));
            textura[325].collision=true;

            textura[326] = new Textura();
            textura[326].image = ImageIO.read(getClass().getResourceAsStream("/tiles/silloncitonLab.png"));
            textura[326].collision=true;

            textura[327] = new Textura();
            textura[327].image = ImageIO.read(getClass().getResourceAsStream("/tiles/anaquelcitoLab.png"));
            textura[327].collision=true;

            textura[328] = new Textura();
            textura[328].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Estanteria2Lab.png"));
            textura[328].collision=true;


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
            int screenX =worldX-gamePanel.jugador.worldX + gamePanel.jugador.screenX;
            int screenY=worldY-gamePanel.jugador.worldY + gamePanel.jugador.screenY;
            if (tileNum < 0 || tileNum >= textura.length || textura[tileNum] == null) {
                System.out.println("tileNum inválido o textura no cargada: " + tileNum);
            }
            //Mejora de rendimiento?
            if(worldX + gamePanel.tileSize>gamePanel.jugador.worldX-gamePanel.jugador.screenX &&
                    worldX- gamePanel.tileSize <gamePanel.jugador.worldX+gamePanel.jugador.screenX &&
                    worldY + gamePanel.tileSize>gamePanel.jugador.worldY- gamePanel.jugador.screenY &&
                    worldY - gamePanel.tileSize<gamePanel.jugador.worldY+ gamePanel.jugador.screenY){
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