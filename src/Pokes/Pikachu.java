package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pikachu extends Poke {
    public Pikachu(GamePanel gamepanel) {
        super(gamepanel);
        name="Pikachu";
        pv=70;
        maxPV=70;
        statAtaque=65;
        statDefensa=50;
        movimientos[0] = new Movimientos("Impactrueno", "Eléctrico", 40, 100, 30);
        movimientos[1] = new Movimientos("Ataque Rapido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Paralisis", "Eléctrico", 0, 90, 20);
        movimientos[3] = new Movimientos("Cola de Hierro", "Acero", 100, 75, 15);
        tipo="Electrico";
        nivel=20;
        genero="Masculino";
        ppMax=100;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/Poken/PikachuBack.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/pikachuFront.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/pikachu.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
