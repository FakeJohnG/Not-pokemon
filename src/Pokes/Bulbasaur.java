package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Bulbasaur extends Poke {
    public Bulbasaur(GamePanel gamepanel) {
        super(gamepanel);
        name="Bulbadont";
        pv=150;
        maxPV=150;
        statAtaque=85;
        statDefensa=60;
        movimientos[0] = new Movimientos("Latigo Cepa", "Planta", 85, 40, 15);
        movimientos[1] = new Movimientos("Placaje", "Normal", 60,100, 30);
        movimientos[2] = new Movimientos("Absorber", "Planta", 60, 80, 10);
        movimientos[3] = new Movimientos("Ataque Rapido", "Normal", 65, 80, 15);
        tipo="Planta";
        nivel=20;
        genero="Ninguno";
        ppMax=100;
        precio=200;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/poken/bulbasaurEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/bulbasaur.png"));
            Pokeshop = ImageIO.read(getClass().getResourceAsStream("/poken/bulbasaur.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
