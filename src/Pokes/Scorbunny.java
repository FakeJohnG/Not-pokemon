package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Scorbunny extends Poke {
    public Scorbunny(GamePanel gamepanel) {
        super(gamepanel);
        name="Scorbunny";
        pv=110;
        movimientos[0] = new Movimientos("Ascuas", "Fuego", 40, 100, 30);
        movimientos[1] = new Movimientos("Ataque Rapido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Patada doble", "Pelea", 0, 90, 20);
        movimientos[3] = new Movimientos("Lanzallamas", "Fuego", 100, 75, 15);
        tipo="Electrico";
        nivel=10;
        genero="Masculino";
        ppMax=100;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/otros/gema.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/scorbunny.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
