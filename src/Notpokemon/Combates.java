package Notpokemon;

import Pokes.Movimientos;
import Pokes.Pikachu;
import Pokes.Poke;
import Pokes.Scorbunny;

public class Combates {
    GamePanel gamePanel;
    public int combateState;
    public Poke jugador;


    public Combates(GamePanel gamepanel, Poke jugador) {
        this.gamePanel = gamepanel;
        this.jugador = jugador;



    }
    public Poke generarPokeSalvaje() {
        int rand = (int)(Math.random() * 2); //

        switch(rand) {
            case 0: return new Pikachu(gamePanel);
            case 1: return new Scorbunny(gamePanel);
            default: return new Pikachu(gamePanel);
        }
    }
    public void procesarTurno(Poke atacante, Poke defensivo, Movimientos movimiento){

    }

    public void calcularDaño(){

    }


}
