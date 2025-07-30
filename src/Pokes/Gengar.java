package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Gengar extends Poke {
    public Gengar(GamePanel gamepanel) {
        super(gamepanel);
        name="Gengar";
        pv=150;
        maxPV=150;
        statAtaque=85;
        statDefensa=60;
        movimientos[0] = new Movimientos("Bola sombra", "Fantasma", 85, 40, 15);
        movimientos[1] = new Movimientos("Impactrueno", "Eléctrico", 60,100, 30);
        movimientos[2] = new Movimientos("Golpe Hielo", "Hielo", 60, 80, 10);
        movimientos[3] = new Movimientos("Golpe Fuego", "Fuego", 65, 80, 15);
        tipo="Fatasma";
        nivel=20;
        genero="Ninguno";
        ppMax=100;
        precio=200;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/poken/gengarEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/gengarFrente.png"));
            Pokeshop = ImageIO.read(getClass().getResourceAsStream("/poken/gengarFrente.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
