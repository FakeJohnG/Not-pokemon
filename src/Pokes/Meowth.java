package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Meowth extends Poke {
    public Meowth(GamePanel gamepanel) {
        super(gamepanel);
        name="Mudkip";
        pv=100;
        maxPV=100;
        statAtaque=40;
        statDefensa=75;
        movimientos[0] = new Movimientos("Sorpresa", "Agua", 40, 100, 30);
        movimientos[1] = new Movimientos("Mordisco", "Normal", 60, 100, 30);
        movimientos[2] = new Movimientos("Arañazo", "Normal", 40, 90, 20);
        movimientos[3] = new Movimientos("Cuchillada", "Normal", 80, 100, 15);
        tipo="Normal";
        nivel=10;
        genero="Masculino";
        ppMax=100;
        precio=50;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/Poken/meowthEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/meowth.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/meowth.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
