package Pokes;

import Notpokemon.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Porygon extends Poke {
    public Porygon(GamePanel gamepanel) {
        super(gamepanel);
        name="Porygon-Z";
        pv=100;
        maxPV=100;
        statAtaque=57;
        statDefensa=70;
        movimientos[0] = new Movimientos("Bola sombra", "Fantasma", 85, 40, 15);
        movimientos[1] = new Movimientos("Ataque Rapido", "Normal", 40, 100, 30);
        movimientos[2] = new Movimientos("Rayo Hielo", "Hielo", 90, 80, 10);
        movimientos[3] = new Movimientos("Impactrueno", "Eléctrico", 60, 100, 15);
        tipo="Normal";
        nivel=20;
        genero="Ninguno";
        ppMax=100;
        precio=100;
        try{
            Pokeimagen = ImageIO.read(getClass().getResource("/poken/porygonEspalda.png"));
            Pokeimagen2= ImageIO.read(getClass().getResourceAsStream("/poken/porygon.png"));
            Pokeshop = ImageIO.read(getClass().getResourceAsStream("/poken/porygon.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
