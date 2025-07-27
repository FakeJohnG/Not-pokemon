package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Charmander extends Poke {
    public Charmander(GamePanel gamepanel) {
        super(gamepanel);
        name="Charmander";
        pv=70;
        maxPV=70;
        statAtaque=65;
        statDefensa=50;
        movimientos[0] = new Movimientos("Impactrueno", "Eléctrico", 40, 100, 30);
        movimientos[1] = new Movimientos("Ataque Rapido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Paralisis", "Eléctrico", 0, 90, 20);
        movimientos[3] = new Movimientos("Lanzallamas", "Fuego", 100, 75, 15);
        tipo="Electrico";
        nivel=20;
        genero="Masculino";
        ppMax=100;
        precio=50;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/Poken/charmanderEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/charmander.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/charmander.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
