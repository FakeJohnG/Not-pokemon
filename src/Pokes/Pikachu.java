package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pikachu extends Poke {
    public Pikachu(GamePanel gamepanel) {
        super(gamepanel);
        name="Pikachunt";
        pv=150;
        maxPV=150;
        statAtaque=75;
        statDefensa=50;
        movimientos[0] = new Movimientos("Impactrueno", "Eléctrico", 60,100, 30);
        movimientos[1] = new Movimientos("Ataque Rapido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Moflete Estatico", "Eléctrico", 10, 100, 20);
        movimientos[3] = new Movimientos("Cola de Hierro", "Acero", 85, 85, 15);
        tipo="Electrico";
        nivel=20;
        genero="Masculino";
        ppMax=100;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/Poken/pikachuEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/pikachu.png"));
            Pokeshop=ImageIO.read(getClass().getResourceAsStream("/poken/pikachu.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
