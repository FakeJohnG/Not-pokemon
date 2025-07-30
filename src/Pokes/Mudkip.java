package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mudkip extends Poke {
    public Mudkip(GamePanel gamepanel) {
        super(gamepanel);
        name="Mudkip";
        pv=100;
        maxPV=100;
        statAtaque=40;
        statDefensa=75;
        movimientos[0] = new Movimientos("Hidropulso", "Agua", 60, 100, 30);
        movimientos[1] = new Movimientos("Placaje", "Normal", 40, 80, 30);
        movimientos[2] = new Movimientos("Bofeton Lodo", "Tierra", 20, 90, 20);
        movimientos[3] = new Movimientos("Hidro Muerte", "Agua", 100000, 10, 15);
        tipo="Agua";
        nivel=20;
        genero="Masculino";
        ppMax=100;
        precio=150;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/Poken/mudkipEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/mudkip.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/mudkip.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
