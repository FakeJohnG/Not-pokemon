package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Snorlax extends Poke {
    public Snorlax(GamePanel gamepanel) {
        super(gamepanel);
        name="Snarlox";
        pv=400;
        maxPV=400;
        statAtaque=30;
        statDefensa=60;
        movimientos[0] = new Movimientos("Abocajaro", "Pelea", 85, 45, 15);
        movimientos[1] = new Movimientos("Golpe Bala", "Normal", 40, 80, 30);
        movimientos[2] = new Movimientos("Golpe Hielo", "Hielo", 85, 75, 10);
        movimientos[3] = new Movimientos("Velocidad Extrema", "Normal", 65, 100, 15);
        tipo="Normal";
        nivel=20;
        genero="Ninguno";
        ppMax=100;
        precio=300;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/poken/SnorlaxEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/snorlax.png"));
            Pokeshop = ImageIO.read(getClass().getResourceAsStream("/poken/snorlax.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
