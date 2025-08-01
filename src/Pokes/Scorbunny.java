package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Scorbunny extends Poke {
    public Scorbunny(GamePanel gamepanel) {
        super(gamepanel);
        name="Scorbunt";
        pv=110;
        maxPV=100;
        statAtaque=65;
        statDefensa=50;
        movimientos[0] = new Movimientos("Ascuas", "Fuego", 40, 100, 30);
        movimientos[1] = new Movimientos("Ataque Rápido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Patada doble", "Pelea", 60, 90, 20);
        movimientos[3] = new Movimientos("Lanzallamas", "Fuego", 90, 75, 15);
        tipo="Electrico";
        nivel=20;
        genero="Masculino";
        ppMax=100;
        precio=100;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/otros/spamton1.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/scorbunny.png"));
            Pokeshop= ImageIO.read(getClass().getResourceAsStream("/poken/scorbunny.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
