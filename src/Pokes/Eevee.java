package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Eevee extends Poke {
    public Eevee(GamePanel gamepanel) {
        super(gamepanel);
        name="Eeveeunt";
        pv=150;
        maxPV=150;
        statAtaque=75;
        statDefensa=60;
        movimientos[0] = new Movimientos("Placaje", "Normal", 40,100, 30);
        movimientos[1] = new Movimientos("Ataque Rapido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Mordisco", "Eléctrico", 60, 100, 20);
        movimientos[3] = new Movimientos("Arañazo", "Normal", 40, 100, 15);
        tipo="Normal";
        nivel=15;
        genero="Masculino";
        ppMax=100;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/poken/eeveeEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/eevee.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/eevee.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

