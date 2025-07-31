package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Lucario extends Poke {
    public Lucario(GamePanel gamepanel) {
        super(gamepanel);
        name="Lucario";
        pv=200;
        maxPV=200;
        statAtaque=70;
        statDefensa=45;
        movimientos[0] = new Movimientos("Abocajaro", "Pelea", 85, 45, 15);
        movimientos[1] = new Movimientos("Puno bala", "Normal", 40, 80, 30);
        movimientos[2] = new Movimientos("Mano de hielo", "Hielo", 85, 75, 10);
        movimientos[3] = new Movimientos("Velocidad extrema", "Normal", 65, 100, 15);
        tipo="Acero";
        nivel=20;
        genero="Ninguno";
        ppMax=100;
        precio=250;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/poken/LucarioEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/LucarioFrente.png"));
            Pokeshop = ImageIO.read(getClass().getResourceAsStream("/poken/LucarioFrente.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
