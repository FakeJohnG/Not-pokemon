package Notpokemon;

import Pokes.*;

public class Combates {
    GamePanel gamePanel;
    public int combateState;
    public Poke jugador;


    public Combates(GamePanel gamepanel, Poke jugador) {
        this.gamePanel = gamepanel;
        this.jugador = jugador;



    }
    public Poke generarPokeSalvaje() {
        int rand = (int)(Math.random() * 3); //
        System.out.println("spawneando pokemon"+rand);

        switch(rand) {
            case 0: return new Porygon(gamePanel);
            case 1: return new Pikachu(gamePanel);
            case 2: return new Scorbunny(gamePanel);

            default: return new Pikachu(gamePanel);
        }
    }
    public void procesarTurno(Poke atacante, Poke defensivo, Movimientos movimiento){
        int daño = calcularDaño(atacante, defensivo, movimiento);
        System.out.println(daño);
        gamePanel.ui.dañoCausado=daño;
        defensivo.recibirDaño(daño);


    }

    public int calcularDaño(Poke atacante,Poke defensivo,Movimientos movimiento){
        int poder = movimiento.getPoder(); // poder del movimiento
        int ataque = atacante.getStatAtaque(); // stat de atacante
        int defensa = defensivo.getStatDefensa(); // stat de defensa

        int dañoBase = (ataque * poder) / (defensa + 1);
        int variación = (int)(Math.random() * 5); // daño adicional aleatorio [0-4]

        return Math.max(1, dañoBase + variación);

    }


}
