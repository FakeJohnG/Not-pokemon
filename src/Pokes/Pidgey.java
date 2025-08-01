package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pidgey extends Poke {
    public Pidgey(GamePanel gamepanel) {
        super(gamepanel);
        name="Pidgent";
        pv=100;
        maxPV=100;
        statAtaque=40;
        statDefensa=75;
        movimientos[0] = new Movimientos("Placaje", "Normal", 40, 100, 30);
        movimientos[1] = new Movimientos("Tornado", "Volador", 40, 100, 30);
        movimientos[2] = new Movimientos("Ataque Rapido", "Normal", 40, 90, 20);
        movimientos[3] = new Movimientos("Ataque Arena", "Tierra", 10, 100, 15);
        tipo="Normal";
        nivel=10;
        genero="Masculino";
        ppMax=100;
        precio=50;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/Poken/pidgeyEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/pidgey.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/pidgey.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
